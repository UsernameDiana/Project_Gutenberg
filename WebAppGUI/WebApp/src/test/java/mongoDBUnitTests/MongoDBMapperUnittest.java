/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongoDBUnitTests;

import databaseAccess.MongoDBMapper;
import static org.hamcrest.CoreMatchers.equalTo;
import junitparams.FileParameters;
import entity.Book;
import java.util.List;
import junitparams.FileParameters;
import org.hamcrest.CoreMatchers;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author diana
 */
public class MongoDBMapperUnittest {

    private MongoDBMapper MongoDBMapper;

    @Before
    public void setup() {
        this.MongoDBMapper = new MongoDBMapper();
    }

    @Test
    @FileParameters("src/test/resources/UserStory1_mongodb.csv")
    public void getBooksByCityTest(String city, String title, String author) {
        List<Book> books;
        books = MongoDBMapper.getBooksByCityName(city);
        assertThat(books.get(0).getTitle(), CoreMatchers.is(equalTo(title)));
        assertThat(books.get(0).getAuthor(), CoreMatchers.is(equalTo(author)));
    }
}
