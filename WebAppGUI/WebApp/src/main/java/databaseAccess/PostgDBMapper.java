/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseAccess;
import Interfaces.IBook;
import Interfaces.IDataAccess;
import entity.City;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Plamen
 */
public class PostgDBMapper {

    
    public Map<Long, IBook> getBooksByCityName(String cityName, Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<City> getCityByBookTitle(String bookTitle, Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Map<Long, IBook> getBooksByAuthor(String authorName, Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Map<Long, IBook> getBooksInVincinity(float lat, float lng, int radius, Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
