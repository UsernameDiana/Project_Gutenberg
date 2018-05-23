/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import entity.Book;
import entity.City;
import java.util.List;

/**
 *
 * @author diana
 */
public interface IDataAccess {

    public List<Book> getBooksByCityName(String cityName); //User Story # 1

    public List<City> getCitiesByBookTitle(String bookTitle); //User Story # 2

    public List<Book> getBooksByAuthorName(String authorName); //User Story # 3

}
