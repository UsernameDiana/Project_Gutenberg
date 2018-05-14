package entity;

import java.util.List;

/**
 *
 * @author diana
 */
public class Book {

    String id;
    String title;
    String author;
    List<City> cities;

    public Book() {

    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Book(String title, String author, List<City> cities) {
        this.title = title;
        this.author = author;
        this.cities = cities;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<City> getCities() {
        return cities;
    }

}
