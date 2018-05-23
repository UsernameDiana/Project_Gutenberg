/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseAccess;

import Interfaces.IDataAccess;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.in;
import entity.Book;
import entity.City;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.Document;

/**
 *
 * @author diana
 */
public class MongoDBMapper implements IDataAccess {

    private MongoDBConnector mongoCon;
    private static MongoClient con = null;
    private String dbname = "gutenberg";
    private String col = "books";

    public MongoDBMapper() {
        this.mongoCon = mongoCon;
        this.con = mongoCon.getConnection();
    }

    MongoDBMapper(MongoDBConnector dbcmongo) {
        this.mongoCon = mongoCon;
        this.con = mongoCon.getConnection();
    }

    @Override
    public List<Book> getBooksByCityName(String cityName) {

        try {
            List<Book> list = new ArrayList();
            MongoDatabase database = con.getDatabase(dbname);
            MongoCollection coll = database.getCollection(col);
            FindIterable<Document> findIterable = coll.find(in("cities.name", cityName));
            for (Document document : findIterable) {
                System.out.println("");
            }

        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public List<City> getCitiesByBookTitle(String bookTitle
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Book> getBooksByAuthorName(String authorName
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
