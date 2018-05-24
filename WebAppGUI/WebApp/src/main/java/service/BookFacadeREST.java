/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Interfaces.IBook;
import com.google.gson.Gson;
import databaseAccess.DBConnector;
import databaseAccess.DBMapperSQL;
import entity.Book;
import facade.BookFacade;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Nexao
 */
@WebServlet(name = "BookRest", urlPatterns = {"/BookRest"})
public class BookFacadeREST extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //-- Establish or reestablish application demainModeltext
        BookFacade bf = new BookFacade();
        String command = request.getParameter("command");
        switch (command) {
            case "getBooksByCityName":
                getBooksByCityName(request, response, bf);
                break;

        }
    }

    public void getBooksByCityName(HttpServletRequest request, HttpServletResponse response, BookFacade bf) throws ServletException, IOException {
        String city = request.getParameter("city");
        Map<Long, IBook> books = bf.getBooksByCityName(city);
        String output = "<table style=\"width:100%\" id=\"books\">\n"
                + "  <tr>\n"
                + "    <th>ID</th>\n"
                + "    <th>Title</th> \n"
                + "    <th>Author</th>\n"
                + "  </tr>\n";
        for (Map.Entry<Long, IBook> book : books.entrySet()) {
            String authors = "";
            for (String author : book.getValue().getAuthor()) {
                authors += author + ", ";
            }
            output += "<tr>\n"
                    + "<td>" + book.getKey() + "</td>"
                    + "<td>" + book.getValue().getTitle() + "</td>"
                    + "<td>" + authors + "</td>"
                    + "</tr>\n";
        }
        output += "</table>";
        response.getWriter().write(output);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//        dispatcher.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

}
