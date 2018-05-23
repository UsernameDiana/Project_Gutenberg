/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import databaseAccess.MongoDBMapper;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author diana
 */
public class StepDefinitions {

    static WebDriver driver;
    MongoDBMapper mapper = new MongoDBMapper();

    @Given("^Given city name is '(.*)'$")
    public void user_pick_city_name(String city) throws Throwable {
        driver.get("http://localhost:8080/WebApp/");
    }

    @When("^Entering the city '(.*)' and choose database '(.*)'$")
    public void user_enters_city_name_and_chooses_db(String city, String database) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^I should get book list result '(.*)'$")
    public void user_gets_all_books_with_mentioned_city_name(String result) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }
}
