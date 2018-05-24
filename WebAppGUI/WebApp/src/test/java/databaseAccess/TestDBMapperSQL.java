/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseAccess;

import entity.Book;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import databaseAccess.*;
import java.sql.SQLException;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Nexao
 */
public class TestDBMapperSQL {

    LocalConnection con = new LocalConnection();

    public TestDBMapperSQL() {
    }

    @Before
    public void setUp() throws SQLException {
        //Setting up the database
//        TestPopulateDatabase testdb = new TestPopulateDatabase(con);
//        testdb.populate();

    }

    @Test
    public void TestConnection() {
        Connection connected = con.getConnection();
        assertNotNull(connected);

    }

    @Test
    public void TestGetBooksByCityName() throws SQLException {
        List<Book> list = new ArrayList();

        try {
            Connection connection = con.getConnection();
            Statement stmt = connection.createStatement();
            String cityName = "Paris";
            String query = "SELECT DISTINCT b.bookid, title, city, name FROM Books b, Cities c, Authors a WHERE c.city = '" + cityName + "' AND b.bookid = c.bookid AND a.bookid = b.bookid;";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                String title = res.getString("title");
                String name = res.getString("name");
                list.add(new Book(title, name));
            }
            // Checking what we get from the query
//            for(int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getTitle());
//        }
//            for(int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getAuthor());
//        }
            assertEquals(list.get(0).getTitle(), "The Picture of Dorian Gray");
            assertEquals(list.get(0).getAuthor(), "Oscar Wilde");

        } catch (Exception e) {

        }
    }

}
