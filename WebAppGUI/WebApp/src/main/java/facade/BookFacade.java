/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Interfaces.IBook;
import databaseAccess.DBConnector;
import databaseAccess.DBFacade;
import databaseAccess.DBMapperSQL;
import entity.Book;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Nexao
 */
public class BookFacade {

    EntityManagerFactory emf;
    Book book;
    DBFacade dbfacade;

    public BookFacade() {
        dbfacade = DBFacade.getInstance();
    }
    public List<IBook> getBooksByCity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public Map<Long, IBook> getBooksByCityName(String city) {
        return dbfacade.getBooksByCityName(city);
    }

    
    public List<IBook> getBooksByAuthorName(String author) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
