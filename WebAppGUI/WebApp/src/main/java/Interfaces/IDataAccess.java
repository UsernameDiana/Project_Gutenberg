
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import entity.Book;
import entity.City;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 *
 * @author diana
 */
public interface IDataAccess {

    public Map<Long, IBook> getBooksByCityName(String cityName, Connection con); //User Story # 1

    public List<City> getCityByBookTitle(String bookTitle, Connection con); //User Story # 2

    public Map<Long, IBook> getBooksByAuthor(String authorName, Connection con); //User Story # 3
    
    public Map<Long, IBook> getBooksInVicinity(float lat, float lng, int radius, Connection con);

}
