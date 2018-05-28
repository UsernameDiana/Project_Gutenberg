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
public class PostGresControlFacade {
    public PostgDBMapper psql;
    private final Connection con;
    private static PostGresControlFacade instance;

    public PostGresControlFacade(){
        con = PostgDBConnector.getInstance().getConnection();
        psql = new PostgDBMapper();
    }


    public static PostGresControlFacade getInstance(){
        if (instance == null) {
            instance = new PostGresControlFacade();
        }
        return instance;
    }
      public Map<Long, IBook> getBooksByAuthor(String author) {
        return psql.getBooksByAuthor(author, con);
    }
      
    public Map<Long, IBook> getBooksByCityName(String cityName){
        return psql.getBooksByCityName(cityName, con);
    }
    
    public List<City> getCityByBookTitle(String book) {
        return psql.getCityByBookTitle(book, con);
    }
    
    public Map<Long, IBook> getBooksInVicinity(float lat, float lng, int radius){
        return psql.getBooksInVicinity(lat, lng, radius, con);
    }
}
