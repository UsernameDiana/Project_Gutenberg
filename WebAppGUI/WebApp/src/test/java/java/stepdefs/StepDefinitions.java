/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author diana
 */
public class StepDefinitions {

    static WebDriver driver;

    @Given("^The city is '(.*)'$")
    public void the_city(String city) throws Throwable {
        driver.get("http://localhost:8080/WebApp/");
    }

    @When("^Enter the city '(.*)' and choose database '(.*)'$")
    public void enter_city_name_and_choose_db(String city, String database) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^I should get book list result '(.*)'$")
    public void i_should_get_success(String result) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }
}
