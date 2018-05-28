package databaseAccess;

import java.util.ArrayList;
import java.util.List;

import Interfaces.IBook;

import com.mongodb.BasicDBObject;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class Main {

    public static void main(String[] args) throws Exception {

//        SQLDBMapper sqlCon = new SQLDBMapper(new SQLDBConnector());
        MongoDBConnector con = new MongoDBConnector();
        MongoDatabase mongodb = con.getDatabase();
        MongoDBMapper mMap = new MongoDBMapper();
//        MongoCollection<Document> collection = mongodb.getCollection("books");

//        BasicDBObject searchQuery = new BasicDBObject();
//        searchQuery.put("title", "Within the Tides");
//        System.out.println("Books: " + mMap.getBooksByAuthorName("Herbert George Wells"));
//        System.out.println("Books: " + mMap.getBooksByAuthorName("Anonymous"));
        System.out.println("Cities: " + mMap.getCitiesByBookTitle("Apocolocyntosis"));

//        MongoCursor<Document> cursor = collection.find(searchQuery).iterator();
//        try {
//            while (cursor.hasNext()) {
//                System.out.println(cursor.next().toJson());
//            }
//        } finally {
//            cursor.close();
//        }
        
//        Map<Long, IBook> bblist = new HashMap();
//        List<IBook> blist = new ArrayList();
//        blist = sqlCon.getBooksByAuthorName("John Lord");
//        bblist = sqlCon.getBooksByCityName("Paris");
//        System.out.println("------------ 1st Query");
//        for (IBook iBook : blist) {
//            System.out.println(iBook.getTitle());
//        }
//
//        System.out.println("------------ 2nd Query");
//        for (IBook iBook : bblist) {
//            System.out.println(iBook.getTitle());
//        }
    }

}
