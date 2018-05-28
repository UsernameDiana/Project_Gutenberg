/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongoUnitTests;

import Interfaces.IBook;
import databaseAccess.MongoDBMapper;
import entity.Book;
import java.util.List;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.CoreMatchers.equalTo;
import org.hamcrest.Matchers;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author diana
 */
@RunWith(JUnitParamsRunner.class)
public class MongoUnitTests {

    private MongoDBMapper MongoDBMapper;

    @Before
    public void setup() {
        this.MongoDBMapper = new MongoDBMapper();
    }

    @Test
    @FileParameters("src/test/resources/UserStory1_mongodb.csv")
    public void testGetBooksByCity(String city, String title, String author) {
//        List<IBook> books = MongoDBMapper.getBooksByCityName(city);
//        assertThat(books, Matchers.<Book>hasItem(Matchers.hasProperty("bookTitle", equalTo(title))));
//        assertThat(books.get(0).getTitle(), CoreMatchers.is(equalTo(title)));
    }
}
