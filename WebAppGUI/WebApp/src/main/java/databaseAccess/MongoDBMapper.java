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
import java.util.List;

/**
 *
 * @author diana
 */
public class MongoDBMapper implements IDataAccess {

    private MongoDBConnector connector = null;
    private static MongoClient con = null;

    @Override
    public List<IBook> getBooksByCityName(String cityName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ICity> getCitiesByBookTitle(String bookTitle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IBook> getBooksByAuthorName(String authorName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
