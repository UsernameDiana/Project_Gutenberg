/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataUnitTests;

import databaseAccess.MongoDBMapper;
import static org.hamcrest.CoreMatchers.equalTo;
import junitparams.FileParameters;
import Interfaces.IBook;
import java.util.ArrayList;
import java.util.List;
import org.hamcrest.CoreMatchers;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author diana
 */
public class MongoUnitTests {

    private MongoDBMapper MongoDBMapper;

    @Before
    public void setup() {
        this.MongoDBMapper = new MongoDBMapper();
    }

    @Test
    @FileParameters("src/test/resources/UserStory1_mongodb.csv")
    public void getBooksByCityTest(String city, String title, String author) {
        List<IBook> books = new ArrayList();
        books = MongoDBMapper.getBooksByCityName(city);
        assertThat(books.get(0).getTitle(), CoreMatchers.is(equalTo(title)));
        //assertThat(books.get(0).getAuthor(), CoreMatchers.is(equalTo(author)));
    }
}
