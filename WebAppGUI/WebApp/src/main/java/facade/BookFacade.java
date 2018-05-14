/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Interfaces.IBook;
import Interfaces.IBookFacade;
import java.util.List;

/**
 *
 * @author diana
 */
public class BookFacade implements IBookFacade{

    @Override
    public List<IBook> getBooksByCityName(String city) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IBook> getBooksByAuthorName(String author) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
