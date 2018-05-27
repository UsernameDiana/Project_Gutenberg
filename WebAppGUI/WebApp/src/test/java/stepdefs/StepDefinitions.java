/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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

    @Given("^Opening the page$")
    public void user_opens_page() throws Throwable {
        driver = new ChromeDriver();
        driver.navigate().to("http://localhost:8080/WebApp/");
    }

    @When("^Entering city '(.*)'$")
    public void user_enters_city_name(String city) throws Throwable {
        driver.findElement(By.name("BookRestful")).sendKeys("Paris");
        driver.findElement(By.name("submit")).click();

    }

    @Then("^I should get results$")
    public void user_gets_all_books_with_mentioned_city_name() throws Throwable {
        Assert.assertTrue("Result page", driver.getTitle().equals("Result page"));
    }
}
