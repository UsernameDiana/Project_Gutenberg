
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import Interfaces.IBook;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nexao
 */
@Entity
@XmlRootElement
public class Book implements IBook, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String title;
    List<String> author = new ArrayList<>();
    List<City> cities = new ArrayList<>();

    public Book() {
    }

    public Book(String title, String author) {
        this.title = title;
        this.author.add(author);
    }

    public Book(String title, String author, City city) {
        this.title = title;
        this.author.add(author);
        this.cities.add(city);
    }
    public Book(Long bookid, String title, String author){
        this.id = bookid;
        this.title = title;
        this.author.add(author);
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthor() {
        return author;
    }

    public void addAuthor(String author) {
        this.author.add(author);
    }

    public List<City> getCities() {
        return cities;
    }

    public void addCity(City city) {
        this.cities.add(city);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "entity.Book[ id=" + id + " ]";
    }

   
}
