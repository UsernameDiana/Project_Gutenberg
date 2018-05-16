/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;

/**
 *
 * @author diana
 */
public interface IDataAccess {

    public List<IBook> getBooksByCityName(String cityName); //User Story # 1

    public List<ICity> getCitiesByBookTitle(String bookTitle); //User Story # 2

    public List<IBook> getBooksByAuthorName(String authorName); //User Story # 3

    public String getName();
}
