package databaseAccess;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {

    private Connection connection = null;

    //Constants
    private static final String URL = "jdbc:mysql://46.101.57.37:3306/project?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USERNAME = "remote";
    private static final String PASSWORD = "test";

    public DBConnector() throws Exception {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = null;
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            System.out.println("Failed to connect: " + e);
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

}
