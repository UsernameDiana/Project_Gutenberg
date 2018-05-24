/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nexao
 */
public class LocalConnection {
    
    private Connection connection = null;
    static LocalConnection instance;
    
    public LocalConnection(){
//        System.out.println("Inside the connection");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
//            System.out.println("Just did the DRIVER ");
            
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root1");
             
            System.out.println("Connected to Testdata ");
                       
        } catch (ClassNotFoundException | SQLException e) {
        }
//        System.out.println("Done");
    }
    
    public static LocalConnection getInstance()
    {
        if (instance == null)
            instance = new LocalConnection();
        return instance;
    }

    public Connection getConnection() {
        return this.connection;
    }
}
