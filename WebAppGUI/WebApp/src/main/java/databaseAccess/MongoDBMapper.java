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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diana
 */
public class MongoDBMapper implements IDataAccess {

    private MongoDBConnector connector = null;
    private static MongoClient con = null;

    public MongoDBMapper() {
        this.connector = new MongoDBConnector();
        this.con = connector.getConnection();
    }

    @Override
    public List<IBook> getBooksByCityName(String cityName) {
        List<IBook> list = new ArrayList();
        // TODO
        
       return list;
    }

    @Override
    public List<ICity> getCitiesByBookTitle(String bookTitle) {
        List<ICity> list = new ArrayList();
        // TODO
        
        return list;
    }

    @Override
    public List<IBook> getBooksByAuthorName(String authorName) {
	List<IBook> list = new ArrayList();
        // TODO
        
        return list;
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
