/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseAccess;

import Interfaces.IBook;
import entity.City;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 *
 * @author przyg
 */
public class MongoControlFacade {
    public MongoDBMapper mgsql;
    private static MongoControlFacade instance;

    public MongoControlFacade(){
        mgsql = new MongoDBMapper();
    }


    public static MongoControlFacade getInstance(){
        if (instance == null) {
            instance = new MongoControlFacade();
        }
        return instance;
    }
      public Map<Long, IBook> getBooksByAuthor(String author) {
        return mgsql.getBooksByAuthor(author);
    }
      
    public Map<Long, IBook> getBooksByCityName(String cityName){
        return mgsql.getBooksByCityName(cityName);
    }
    
    public List<City> getCityByBookTitle(String book) {
        return mgsql.getCityByBookTitle(book);
    }
    
    public Map<Long, IBook> getBooksInVicinity(float lat, float lng, int radius){
        return mgsql.getBooksInVicinity(lat, lng, radius);
    }
}
