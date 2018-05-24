
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import entity.City;
import java.util.List;

/**
 *
 * @author diana
 */
public interface IBook {

    List<City> getCities();
    
    void addCity(City city);

    String getTitle();

    void setTitle(String title);

    List<String> getAuthor();

    void addAuthor(String author);
    
    Long getId();

    void setId(Long id);
}
