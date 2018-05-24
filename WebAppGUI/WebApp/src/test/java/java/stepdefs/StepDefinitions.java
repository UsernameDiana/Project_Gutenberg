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

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author diana
 */
public class StepDefinitions {

    static WebDriver driver;
    MongoDBMapper mapper = new MongoDBMapper();

    @Given("^The city name is $")
    public void user_pick_city_name(String city) throws Throwable {
        driver = new ChromeDriver();
        driver.navigate().to("http://localhost:8080/WebApp/");
    }

//    @When("^Entering city '(.*)'$")
//    public void click_on_form(String city) throws Throwable {
//        driver.findElement(By.name("BookRestful").click());
//        
//    }
    
    @When("^Entering city '(.*)'$")
    public void user_enters_city_name(String city) throws Throwable {
        driver.findElement(By.name("BookRestful")).sendKeys("Paris");
        driver.findElement(By.name("submit")).click();
        
    }

    @Then("^I should get a page with books'(.*)'$")
    public void user_gets_all_books_with_mentioned_city_name(String result) throws Throwable {
        Assert.assertTrue("Result page", driver.getTitle().equals("Result page"));
    }
}
