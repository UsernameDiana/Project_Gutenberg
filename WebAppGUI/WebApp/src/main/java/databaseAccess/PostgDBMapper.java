/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseAccess;
import Interfaces.IBook;
import Interfaces.IDataAccess;
import entity.Book;
import entity.City;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 *
 * @author Plamen
 */
public class PostgDBMapper {
    
    private PostgDBConnector postgCon;
    
    public PostgDBMapper() {
    }
    
    public PostgDBMapper(PostgDBConnector postgCon) {
        this.postgCon = postgCon;
    }
    
    public Map<Long, IBook> getBooksByCityName(String cityName, Connection con) {
        Map<Long, IBook> list = new HashMap();
        Set<Long> bookIds = new HashSet<>();
        Set<String> cities = new HashSet<>();

        Set<String> authors = new HashSet<>();
        try {

            Statement stmt = con.createStatement();

            String query = "SELECT DISTINCT b.bookid, title, city, name, latitude, longitude FROM Books b, Cities c, Authors a WHERE c.city = '" + cityName + "' AND b.bookid = c.bookid AND a.bookid = b.bookid;";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                Long bookid = Long.parseLong(res.getString("bookid"));
                String title = res.getString("title");
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
                    cities.add(city);
                    bookIds.add(bookid);
                    authors.add(name);
                }

            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return list;
    }

    
    public List<City> getCityByBookTitle(String bookTitle, Connection con) {
        List<City> list = new ArrayList();

        try {
            Statement stmt = con.createStatement();
            String query = "SELECT DISTINCT city, latitude, longitude FROM books b INNER JOIN cities c ON b.title = '" + bookTitle + " ' AND b.bookid = c.bookid;";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                String city = res.getString("city");
                String lat = res.getString("latitude");
                String lon = res.getString("longitude");
                list.add(new City(city, Double.parseDouble(lon), Double.parseDouble(lat)));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return list;
    }

    
    public Map<Long, IBook> getBooksByAuthor(String authorName, Connection con) {
        Map<Long, IBook> list = new HashMap();
        Set<Long> bookIds = new HashSet<>();
        Set<String> authors = new HashSet<>();

        Set<String> cities = new HashSet<>();
        try {
            Statement stmt = con.createStatement();
            String query = "SELECT DISTINCT b.bookid, title, city, name, latitude, longitude FROM Books b, Cities c, Authors a WHERE a.name = '" + authorName + "' AND b.bookid = c.bookid AND a.bookid = b.bookid;";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                Long bookid = Long.parseLong(res.getString("bookid"));
                String title = res.getString("title");
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

            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return list;
    }

    
    public Map<Long, IBook> getBooksInVicinity(float lat, float lng, int radius, Connection con) {
       Map<Long, IBook> books = new HashMap<>();
        try {
            Statement stmt = con.createStatement();
            String query = "SELECT DISTINCT b.bookid, title, name , (\n"
                    + " 6371 * acos(\n"
                    + " cos( radians(" + lat + ") )\n"
                    + " * cos( radians( latitude ) )\n"
                    + " * cos( radians( longitude ) - radians(" + lng + ") ) + sin( radians(" + lat + ") )\n"
                    + " * sin( radians( latitude ) ) ) ) \n"
                    + "AS distance \n"
                    + "FROM Cities as c, Books as b, Authors as a\n"
                    + "WHERE b.bookid = c.bookid AND b.bookid = a.bookid\n"
                    + "HAVING distance < " + radius + ";";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                Long bookid = Long.parseLong(res.getString("bookid"));
                String title = res.getString("title");
                String name = res.getString("name");
                books.put(bookid, new Book(bookid, title, name));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return books;
    } 
}
    

