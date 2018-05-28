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
import com.mongodb.Mongo;
import entity.City;
import facade.MongoFacade;
import facade.MysqlFacade;
import facade.PostgresFacade;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
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
import static javax.ws.rs.client.Entity.json;
import javax.ws.rs.core.MediaType;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author Zygis
 */
@Path("search")
public class WebServices {

    MysqlFacade mf = new MysqlFacade();
    PostgresFacade pf = new PostgresFacade();
    MongoFacade mgf = new MongoFacade();
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
     *
     * @return an instance of java.lang.String
     */
    @POST
    @Path("byAuthor")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String byAuthorJSON(String content) {
        Map<Long, IBook> books = null;
        JSONObject obj = new JSONObject(content);
        String item = obj.get("item").toString();
        String db = obj.get("database").toString();
        switch (db) {
            case "1b":
                books = mf.getBooksByAuthor(item);
                break;
            case "2b":
                books = pf.getBooksByAuthor(item);
                break;
            case "3b":
                books = mgf.getBooksByAuthor(item);
                break;

        }
        System.out.println(books);
        return gson.toJson(books);
    }

    /**
     * PUT method for updating or creating an instance of MembersService
     *
     * @param content representation for the resource
     * @return an instance of java.lang.String
     */
    @POST
    @Path("byCity")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String byCityJSON(String content) {
        Map<Long, IBook> books = null;
        System.out.println(content);
        JSONObject obj = new JSONObject(content);
        String item = obj.get("item").toString();
        String db = obj.get("database").toString();
        switch (db) {
            case "1b":
                books = mf.getBooksByCityName(item);
                break;
            case "2b":
                books = pf.getBooksByCityName(item);
                break;
            case "3b":
                books = mgf.getBooksByCityName(item);
                break;

        }
        System.out.println(gson.toJson(books));
        return gson.toJson(books);
    }

    @POST
    @Path("byBook")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String byBookJSON(String content) {
        List<City> cities = null;

        JSONObject obj = new JSONObject(content);
        String item = obj.get("item").toString();
        String db = obj.get("database").toString();
        switch (db) {
            case "1b":
                cities = mf.getCityByBookTitle(item);
                break;
            case "2b":
                cities = pf.getCityByBookTitle(item);
                break;
            case "3b":
                cities = mgf.getCityByBookTitle(item);
                break;

        }
        System.out.println(gson.toJson(cities));
        return gson.toJson(cities);
    }

    @POST
    @Path("byGeo")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String byGeoJSON(String content) throws ParseException {
        Map<Long, IBook> books = null;

        JSONObject obj = new JSONObject(content);
        String db = obj.get("database").toString();

        System.out.println(content);
        float lat = Float.parseFloat(obj.get("lat").toString());
        float lng = Float.parseFloat(obj.get("lng").toString());

        int radius = Integer.parseInt(obj.get("radius").toString());
        switch (db) {
            case "1b":
                books = mf.getBooksInVicinity(lat, lng, radius);
                break;
            case "2b":
                books = pf.getBooksInVicinity(lat, lng, radius);
                break;
            case "3b":
                books = mgf.getBooksInVicinity(lat, lng, radius);
                break;

        }
        System.out.println(gson.toJson(books));
        return gson.toJson(books);
    }
}
