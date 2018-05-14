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
public interface IBookFacade {
    
    List<IBook> getBooksByCityName (String city);
    List<IBook> getBooksByAuthorName (String author);
    
}
