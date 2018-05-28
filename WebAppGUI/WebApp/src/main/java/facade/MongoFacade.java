/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Interfaces.IBook;
import databaseAccess.MongoControlFacade;
import entity.City;
import java.util.List;
import java.util.Map;

/**
 *
 * @author przyg
 */
public class MongoFacade {
    MongoControlFacade mgf;

    public MongoFacade() {
        mgf = MongoControlFacade.getInstance();
    }
    public List<City> getCityByBookTitle(String book) {
        return mgf.getCityByBookTitle(book);
    }

   
    public Map<Long, IBook> getBooksByCityName(String city) {
        return mgf.getBooksByCityName(city);
    }

    
    public Map<Long, IBook> getBooksByAuthor(String author) {
        return mgf.getBooksByAuthor(author);
    }

     public Map<Long, IBook> getBooksInVicinity(float lat, float lng, int radius){
        return mgf.getBooksInVicinity(lat, lng, radius);
    }
}
