/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Interfaces.IBook;


import facade.BookFacade;
import java.io.IOException;

import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Nexao
 */
@WebServlet(name = "BookRest", urlPatterns = {"/BookRest"})
public class BookService extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //-- Establish or reestablish application demainModeltext
        BookFacade bf = new BookFacade();
        System.out.println("works works works");
        
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
        
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("Success Data");
        System.out.println("booom boom");
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
