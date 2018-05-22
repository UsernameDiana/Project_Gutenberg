/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Interfaces.IBook;
import Interfaces.IBookFacade;
import databaseAccess.DBConnector;
import databaseAccess.DBFacade;
import databaseAccess.DBMapperSQL;
import entity.Book;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Nexao
 */
public class BookFacade implements IBookFacade {

    EntityManagerFactory emf;
    Book book;
    DBFacade dbfacade;

    public BookFacade(EntityManagerFactory emf) {
        dbfacade = DBFacade.getInstance();
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void addEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<Book> getBooksByCity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Book> getBooksByCityName(String city) {
        return dbfacade.getBooksByCityName(city);
    }

    @Override
    public List<Book> getBooksByAuthorName(String author) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
