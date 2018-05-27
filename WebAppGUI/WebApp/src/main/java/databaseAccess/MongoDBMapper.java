/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseAccess;

import Interfaces.IBook;
import Interfaces.ICity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.in;
import entity.Book;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author diana
 */
public class MongoDBMapper {

    private MongoDBConnector mongoCon;
    private static MongoClient con = null;
    private String dbname = "gutenberg";
    private String bcol = "books";

    public MongoDBMapper() {
        this.mongoCon = new MongoDBConnector();
        this.con = mongoCon.getConnection();
    }

    public List<IBook> getBooksByCityName(String cityName) {

        List<IBook> books = new ArrayList();

        try {
            MongoDatabase database = con.getDatabase(dbname);
            MongoCollection coll = database.getCollection(bcol);
            FindIterable<Document> findIterable = coll.find(in("city.name", cityName));
            for (Document document : findIterable) {
                String jsonStr = document.toJson();
                System.out.println(jsonStr);
                books.add((IBook) document);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return books;
    }

    public List<ICity> getCitiesByBookTitle(String bookTitle) {

        List<ICity> cities = new ArrayList();

        try {
            ObjectMapper mapper = new ObjectMapper();
            MongoDatabase database = con.getDatabase(dbname);
            MongoCollection coll = database.getCollection(bcol);
            FindIterable<Document> findIterable = coll.find(eq("bookTitle", bookTitle));
            for (Document document : findIterable) {
                String jsonStr = document.toJson();
                IBook b = mapper.readValue(jsonStr, Book.class);
                for (ICity c : b.getCities()) {
                    cities.add(c);
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return cities;
    }

    public List<Book> getBooksByAuthorName(String authorName) {

        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

}
