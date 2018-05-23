/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataUnitTests;

import databaseAccess.DBConnector;
import databaseAccess.DBMapperSQL;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author diana
 */
public class DBMapperSQLUnittest {

    private DBConnector sqlCon;
    DBMapperSQL mapper = new DBMapperSQL(sqlCon);

    @Before
    public void setUp() throws Exception{
        assertNotNull(sqlCon);
    }
    
    @Test
    public void testGetBooksByCityName() throws Exception{
        String cityName = "Paris";
        mapper.getBooksByCityName(cityName);
        
    }
    
    @Test
    public void testGetCitiesByBookTitle() throws Exception{
    }
    
    @Test
    public void testGetBooksByAuthorName() throws Exception{
    }
    
}
