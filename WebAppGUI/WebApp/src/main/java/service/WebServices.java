/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Interfaces.IBook;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import entity.City;
import facade.BookFacade;
import java.util.List;
import java.util.Map;
import javafx.scene.chart.PieChart;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import org.json.JSONObject;


/**
 * REST Web Service
 *
 * @author Zygis
 */
@Path("search")
public class WebServices {

    BookFacade bf = new BookFacade();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MembersService
     */
    public WebServices() {
    }

    /**
     * Retrieves representation of an instance of rest.MembersService
     * @return an instance of java.lang.String
     */
    @POST
    @Path("byAuthor")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String byAuthorJSON(String content) {
        Map<Long, IBook> books = bf.getBooksByAuthor(content);
        return gson.toJson(books);
    }

    /**
     * PUT method for updating or creating an instance of MembersService
     * @param content representation for the resource
     */
    @POST
    @Path("byCity")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String byCityJSON(String content) {
        Map<Long, IBook> books = bf.getBooksByCityName(content);
        return gson.toJson(books);
    }
    
    @POST
    @Path("byBook")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String byBookJSON(String content) {
        List<City> cities = bf.getCityByBookTitle(content);
        return gson.toJson(cities);
    }
}