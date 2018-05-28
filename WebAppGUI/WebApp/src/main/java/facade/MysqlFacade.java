
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Interfaces.IBook;
import databaseAccess.SQLDBConnector;
import databaseAccess.MysqlControlFacade;
import databaseAccess.SQLDBMapper;
import entity.Book;
import entity.City;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Nexao
 */
public class MysqlFacade {

    EntityManagerFactory emf;
    Book book;
    MysqlControlFacade dbfacade;

    public MysqlFacade() {
        dbfacade = MysqlControlFacade.getInstance();
    }
    public List<City> getCityByBookTitle(String book) {
        return dbfacade.getCityByBookTitle(book);
    }

   
    public Map<Long, IBook> getBooksByCityName(String city) {
        return dbfacade.getBooksByCityName(city);
    }

    
    public Map<Long, IBook> getBooksByAuthor(String author) {
        return dbfacade.getBooksByAuthor(author);
    }

     public Map<Long, IBook> getBooksInVicinity(float lat, float lng, int radius){
        return dbfacade.getBooksInVicinity(lat, lng, radius);
    }
}

