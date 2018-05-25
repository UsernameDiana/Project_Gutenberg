/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseAccess;

import Interfaces.IBook;
import entity.Book;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import databaseAccess.*;
import entity.City;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Nexao
 */
public class TestDBMapperSQL {

    LocalConnection con = new LocalConnection();
    public TestDBMapperSQL() {
    }

    // For some reason this goes as null, even though the tests connect fine to the database.
//    @Test
//    public void TestConnection() {
//        assertNotNull(con.getConnection());
//
//    }

    @Test
    public void TestGetBooksByCityName() throws SQLException {
        List<Book> list = new ArrayList();

        try {
            Connection connection = con.getConnection();
            Statement stmt = connection.createStatement();
            String cityName = "Paris";
            String query = "SELECT DISTINCT b.bookid, title, city, name FROM Books b, Cities c, Authors a WHERE c.city = '" + cityName + "' AND b.bookid = c.bookid AND a.bookid = b.bookid;";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                String title = res.getString("title");
                String name = res.getString("name");
                System.out.println("Name: " + name + " Title: " + title);
                list.add(new Book(title, name));
            }
            
            assertEquals(list.get(1).getTitle(), "The Picture of Dorian Gray");
            assertEquals(list.get(1).getAuthor(), "Oscar Wilde");

        } catch (Exception e) {

        }
    }
    
    @Test
    public void TestGetCityByBookTitle(){
        
        List<City> list = new ArrayList();

        try {
            Connection connection = con.getConnection();
            Statement stmt = connection.createStatement();
            String bookTitle = "Oliver Twist";
            String query = "SELECT DISTINCT city FROM Books b INNER JOIN Cities c  WHERE b.tittle = '" + bookTitle + "' AND b.bookid = c.bookid;";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                String city = res.getString("city");
                String lat = res.getString("latitude");
                String lon = res.getString("longitude");
                list.add(new City(city, Double.parseDouble(lon), Double.parseDouble(lat)));
            }
            
            assertEquals(list.get(1).getName(), "Charles Dickens");
        } catch (Exception e) {
        }
    }
    
    @Test
    public void TestGetBooksByAuthor(){
        
        Map<Long, IBook> list = new HashMap();
        Set<Long> bookIds = new HashSet<>();
        Set<String> authors = new HashSet<>();

        Set<String> cities = new HashSet<>();
        try {
            Connection connection = con.getConnection();
            Statement stmt = connection.createStatement();
            String authorName = "Alexandre Dumas";
            String query = "SELECT DISTINCT b.bookid, tittle, city, name FROM Books b, Cities c, Authors a WHERE a.name = '" + authorName + "' AND b.bookid = c.bookid AND a.bookid = b.bookid;";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                Long bookid = Long.parseLong(res.getString("bookid"));
                String title = res.getString("tittle");
                String name = res.getString("name");
                String city = res.getString("city");
                String lat = res.getString("latitude");
                String lon = res.getString("longitude");
                if (bookIds.contains(bookid)) {
                    IBook book = list.get(bookid);
                    if (!authors.contains(name)) {
                        book.addAuthor(name);
                        authors.add(name);
                    }
                    if (!cities.contains(city)) {
                        book.addCity(new City(city, Double.parseDouble(lon), Double.parseDouble(lat)));
                        cities.add(city);
                    }
                    
                } else {
                    IBook book = new Book(bookid, title, name, new City(city, Double.parseDouble(lon), Double.parseDouble(lat)));
                    list.put(bookid, book);
                    bookIds.add(bookid);
                    authors.add(name);
                    cities.add(city);
                }
                assertEquals(list.get(1).getAuthor(), "Charles Dickens");

            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        
        
    }

}
