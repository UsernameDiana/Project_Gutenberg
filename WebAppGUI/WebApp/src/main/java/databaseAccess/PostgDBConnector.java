package databaseAccess;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgDBConnector {

    private Connection connection = null;
    private static PostgDBConnector instance;
    //Constants
    private static final String URL = "jdbc:postgresql://46.101.57.37:5432";
    private static final String USERNAME = "gutenberg";
    private static final String PASSWORD = "gutenberg1";
   

    public PostgDBConnector() {

        try {
            Class.forName("org.postgresql.Driver");
            this.connection = null;
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            System.out.println("Failed to connect: " + e);
        }
    }
    
    public static PostgDBConnector getInstance()
    {
        if (instance == null)
            instance = new PostgDBConnector();
        return instance;
    }

    public Connection getConnection() {
        return this.connection;
    }
    
    

}
