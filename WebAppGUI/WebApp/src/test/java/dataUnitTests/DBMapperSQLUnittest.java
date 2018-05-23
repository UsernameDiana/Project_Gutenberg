/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataUnitTests;

import databaseAccess.DBConnector;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

/**
 *
 * @author diana
 */
public class DBMapperSQLUnittest {

    @Mock
    private DBConnector sqlCon;

    @Before
    public void setUp() throws Exception{
        assertNotNull(sqlCon);
    }
    
    @Test
    public void testGetBooksByCityName() throws Exception{
    }
    
    @Test
    public void testGetCitiesByBookTitle() throws Exception{
    }
    
    @Test
    public void testGetBooksByAuthorName() throws Exception{
    }
    
}
