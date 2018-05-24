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
    public void setUp() throws SQLException{
        
//        TestPopulateDatabase testdb = new TestPopulateDatabase(con);
//        testdb.populate();
    }
    

    
    @Test
    public void TestGetBooksByCityName() throws SQLException {
        List<Book> list = new ArrayList();
//        List<Book> expected = new ArrayList("");
        
        try {
            Connection connection = con.getConnection();
            Statement stmt = connection.createStatement();
            String cityName = "Paris";
            assertTrue(cityName, true);
            String query = "SELECT DISTINCT b.bookid, title, city, name FROM Books b, Cities c, Authors a WHERE c.city = '" + cityName + "' AND b.bookid = c.bookid AND a.bookid = b.bookid;";
            ResultSet res = stmt.executeQuery(query);
            assertEquals(res, stmt);
            while (res.next()) {
                String title = res.getString("tittle");
                String name = res.getString("name");
                list.add(new Book(title, name));
            }
            System.out.println("List: " + list);
//            assertArrayEquals(cityName, , actuals);
//            assertArrayEquals(cityName, "The Picture of Dorian Gray", actuals);
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
    }

}
