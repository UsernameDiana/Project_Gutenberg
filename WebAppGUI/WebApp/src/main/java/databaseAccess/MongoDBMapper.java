/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseAccess;

import Interfaces.IBook;
import Interfaces.ICity;
import com.mongodb.BasicDBObject;
import com.mongodb.CommandResult;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.in;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import entity.Book;
import entity.City;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.FloatCodec;
import org.bson.codecs.LongCodec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Zygi and Emil
 */
public class MongoDBMapper {

    private MongoDBConnector mongoCon;
    private static MongoClient con = null;
    private String dbname = "gutenberg";
    private String authorsCol = "Authors";
    private String booksCol = "Books";
    private String citiesCol = "Cities";

    public Map<Long, IBook> getBooksByCityName(String cityName) {

        System.out.println("Connecting with Mongo");
        mongoCon = new MongoDBConnector();
        MongoDatabase db = mongoCon.getDatabase();
        Map<Long, IBook> listBooks = new HashMap<>();
        MongoCollection<Document> cityCol = db.getCollection(citiesCol);

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("city", cityName);
        AggregateIterable<Document> books = cityCol.aggregate(Arrays.asList(
                new Document("$match", new Document("city", cityName)),
                new Document("$sort", new Document("bookid", 1)),
                new Document("$limit", 200),
                new Document("$lookup", new Document("from", "Books")
                        .append("localField", "bookid")
                        .append("foreignField", "bookid")
                        .append("as", "Books")
                ),
                new Document("$lookup", new Document("from", "Authors")
                        .append("localField", "bookid")
                        .append("foreignField", "bookid")
                        .append("as", "Authors")
                ),
                new Document("$project", new Document("bookid", 1)
                        .append("_id", 1)
                        .append("Authors.name", 1)
                        .append("Books.title", 1)
                )));

        for (Document dbObject : books) {
            List<String> authorsList = new ArrayList<>();
//            System.out.println("Object" + dbObject);
            Long bookId = Long.parseLong(dbObject.get("bookid").toString());
            String title = ((Document) ((List) dbObject.get("Books")).get(0)).get("title").toString();
            List bookList = (List) dbObject.get("Authors");

            for (Object book : bookList) {
                String name = ((Document) book).get("name").toString();
                authorsList.add(name);
            }
            listBooks.put(bookId, new Book(bookId, title, authorsList));
//            System.out.println(bookId + " " + title + " " + authorsList);
//        MongoCursor<Document> booksDoc = bookCol.find().iterator();
        }
        //List<IBook> list = new ArrayList();
        System.out.println(listBooks);
        return listBooks;
    }

    public List<City> getCityByBookTitle(String bookTitle) {

        System.out.println("Connecting with Mongo");
        mongoCon = new MongoDBConnector();
        MongoDatabase db = mongoCon.getDatabase();
        List<City> cityList = new ArrayList<>();
        MongoCollection<Document> bookCol = db.getCollection(booksCol);

        AggregateIterable<Document> cities = bookCol.aggregate(Arrays.asList(
                new Document("$match", new Document("title", bookTitle)),
                new Document("$sort", new Document("bookid", 1)),
                new Document("$limit", 200),
                new Document("$lookup", new Document("from", "Cities")
                        .append("localField", "bookid")
                        .append("foreignField", "bookid")
                        .append("as", "C")
                ),
                new Document("$project", new Document("bookid", 1)
                        .append("_id", 1)
                        .append("C.city", 1)
                        .append("C.location", 1)
                        .append("title", 1)
                )
        ));

        for (Document dbObject : cities) {
            System.out.println(dbObject);
            List cList = (List) dbObject.get("C");
            for (Object city : cList) {
                String name = ((Document) city).get("city").toString();
                Object cord = ((Document) city).get("location");
                List coordinates = (List) ((Document) cord).get("coordinates");
                cityList.add(new City(name, Float.parseFloat(coordinates.get(0).toString()), Float.parseFloat(coordinates.get(1).toString())));

            }

        }
        return cityList;

    }

    public Map<Long, IBook> getBooksByAuthor(String authorName) {
        System.out.println("Connecting with Mongo");
        mongoCon = new MongoDBConnector();
        MongoDatabase db = mongoCon.getDatabase();
        Map<Long, IBook> listBooks = new HashMap<>();
        MongoCollection<Document> authorCol = db.getCollection(authorsCol);

        AggregateIterable<Document> books = authorCol.aggregate(Arrays.asList(
                new Document("$match", new Document("name", authorName)),
                new Document("$sort", new Document("bookid", 1)),
                new Document("$limit", 200),
                new Document("$lookup", new Document("from", "Books")
                        .append("localField", "bookid")
                        .append("foreignField", "bookid")
                        .append("as", "Title")
                ),
                new Document("$lookup", new Document("from", "Cities")
                        .append("localField", "bookid")
                        .append("foreignField", "bookid")
                        .append("as", "City")
                ),
                new Document("$project", new Document("bookid", 1)
                        .append("_id", 1)
                        .append("name", 1)
                        .append("Title.title", 1)
                        .append("City.city", 1)
                        .append("City.location", 1)
                )));

        Set<String> cityName = new HashSet<>();
        List<City> list = new ArrayList<>();
        for (Document dbObject : books) {
            String author = dbObject.get("name").toString();
            Long bookId = Long.parseLong(dbObject.get("bookid").toString());
            String title = ((Document) ((List) dbObject.get("Title")).get(0)).get("title").toString();
            List cities = (List) dbObject.get("City");
            for (Object city : cities) {
                System.out.println(city);
                String name = ((Document) city).get("city").toString();
                Object cord = ((Document) city).get("location");
                List coordinates = (List) ((Document) cord).get("coordinates");
                if (!cityName.contains(name)) {
                    list.add(new City(name, Float.parseFloat(coordinates.get(0).toString()), Float.parseFloat(coordinates.get(1).toString())));
                    cityName.add(name);
                }
            }
            listBooks.put(bookId, new Book(bookId, title, author, list));

        }

        return listBooks;
    }

    public Map<Long, IBook> getBooksInVicinity(float lan, float lon, int radius) {
//db.runCommand( { geoNear: "places",
//                 near: [ -74, 40.74 ],
//                 spherical: true
//               }  )
//        db.places.find( { loc: { $geoWithin: { $centerSphere: [ [ -74, 40.74 ] ,
//                                                   100 / 3963.2 ] } } } )
        Map<Long, IBook> listBooks = new HashMap<>();
        System.out.println("Connecting with Mongo");
        mongoCon = new MongoDBConnector();
        System.out.println(lan + " " + lon);
        MongoDatabase db = mongoCon.getDatabase();
        
        MongoCollection<Document> city = db.getCollection(citiesCol);
        MongoCollection<Document> book = db.getCollection(booksCol);

        
        double[] location = new double[]{lon, lan};
        BasicDBObject myCmd = new BasicDBObject();
        myCmd.append("geoNear", "Cities");
        myCmd.append("near", location);
        myCmd.append("spherical", true);
        myCmd.append("maxDistance", radius*1000);
        Document myResults = db.runCommand(myCmd);
        
        
        
         List<Document> result = (ArrayList)myResults.get("results");
        
        List<Integer> bookIds = new ArrayList<>();
        for (Document doc : result) {
            Document obj = (Document) doc.get("obj");
            bookIds.add(obj.getInteger("bookid"));
               
        }
            MongoCursor<Document> book_objs = book.find(in("bookid", bookIds.toArray(new Integer[0]))).iterator();
            
            while (book_objs.hasNext())
            {
                Document doc = book_objs.next();
                Integer id = doc.getInteger("bookid");
                Long bookid = id.longValue();
                listBooks.put(bookid, new Book(bookid, doc.getString("title")));

            }
        return listBooks;
    }
}
