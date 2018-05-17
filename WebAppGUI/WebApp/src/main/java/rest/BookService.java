/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Book;
import facade.BookFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Nexao
 */
@Path("books")
public class BookService {

    @PersistenceContext(unitName = "sqlDatabase")
    private EntityManager em;
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    BookFacade facade = new BookFacade(Persistence.createEntityManagerFactory("pu"));

    @Context
    private UriInfo context;
    
    public BookService() {        
    }
   
//    @GET
//    @Path("/books/{cityid}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public Book find(@PathParam("cityid") String cityid) {
//        Book b = facade.getBooksByCity();
//    }
    
    @GET
    @Path("/books/all/{cityid}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String getBooksByCity(@PathParam("cityid") String cityid) {
        List<Book> books = facade.getBooksByCity();
        return gson.toJson(books);
        
    }
    

    protected EntityManager getEntityManager() {
        return em;
    }
    
}
