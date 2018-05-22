/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseAccess;

import Interfaces.IBook;
import Interfaces.ICity;
import Interfaces.IDataAccess;
import com.mongodb.MongoClient;
import entity.Book;
import entity.City;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diana
 */
public class MongoDBMapper implements IDataAccess {

    private MongoDBConnector mongoCon;

    public MongoDBMapper(MongoDBConnector mongoCon) {
        this.mongoCon = mongoCon;
    }
    
    @Override
    public List<Book> getBooksByCityName(String cityName) {
            List<Book> list = new ArrayList();
            
            try {
                    mongoCon.getConnection();
        } catch (Exception e) {
        }
        
          return null;

    }

    @Override
    public List<City> getCitiesByBookTitle(String bookTitle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Book> getBooksByAuthorName(String authorName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
