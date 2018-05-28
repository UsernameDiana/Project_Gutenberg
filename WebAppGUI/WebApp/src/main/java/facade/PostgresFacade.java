/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Interfaces.IBook;
import databaseAccess.MysqlControlFacade;
import entity.Book;
import entity.City;
import java.util.List;
import java.util.Map;
import databaseAccess.PostGresControlFacade;
/**
 *
 * @author przyg
 */
public class PostgresFacade {
    
    
    PostGresControlFacade pcf;

    public PostgresFacade() {
        pcf = PostGresControlFacade.getInstance();
    }
    public List<City> getCityByBookTitle(String book) {
        return pcf.getCityByBookTitle(book);
    }

   
    public Map<Long, IBook> getBooksByCityName(String city) {
        return pcf.getBooksByCityName(city);
    }

    
    public Map<Long, IBook> getBooksByAuthor(String author) {
        return pcf.getBooksByAuthor(author);
    }

     public Map<Long, IBook> getCitiesByBookInVicinity(float lat, float lng, int radius){
        return pcf.getBooksInVincinity(lat, lng, radius);
    }
}
