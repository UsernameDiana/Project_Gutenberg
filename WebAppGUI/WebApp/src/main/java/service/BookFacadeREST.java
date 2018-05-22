/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Interfaces.IBookFacade;
import Interfaces.IDataAccess;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Book;
import facade.BookFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Nexao
 */
@Stateless
@Path("/book")
public class BookFacadeREST {

    @PersistenceContext(unitName = "sqlDatabase")
    private EntityManager em;
    static IBookFacade facade = new BookFacade(Persistence.createEntityManagerFactory(""));
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public BookFacadeREST() {
        
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Book find(@PathParam("id") Long id) {
        
        
        
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Book> findAll() {
        return null;
    }


    protected EntityManager getEntityManager() {
        return em;
    }
    
}
