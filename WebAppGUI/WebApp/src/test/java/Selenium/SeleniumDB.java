/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Selenium;

import java.util.List;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Nexao
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SeleniumDB {

    static WebDriver driver;
    private static final int WAIT_MAX = 4;

    @BeforeClass
    public static void setup() {

        // Call it in each test, otherwise it won't make a window for that test.
        
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nexao\\Downloads\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("http://localhost:8080/WebApp/");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void test() {

        (new WebDriverWait(driver, WAIT_MAX)).until((ExpectedCondition<Boolean>) (WebDriver d) -> {
            WebElement el = driver.findElement(By.name("city"));
            Assert.assertNotNull(el);
            return true;
        });
    }

    @Test
    public void test1() {
        
        WebElement filter = driver.findElement(By.name("city"));
        filter.sendKeys("Copenhagen");

        WebElement body = driver.findElement(By.name("Submit"));
        body.click();

        List<WebElement> books = driver.findElements(By.tagName("tr"));
        Assert.assertTrue(books.size() == 13);
    }

    @Test
    public void test2() {

        setup();
        
        WebElement filter = driver.findElement(By.name("city"));
        filter.sendKeys("New York");

        WebElement body = driver.findElement(By.name("Submit"));
        body.click();

        List<WebElement> books = driver.findElements(By.tagName("tr"));
        Assert.assertTrue(books.size() == 1);
        
    }
    
    @Test
    public void test3(){
        
        setup();
        
        WebElement filter = driver.findElement(By.name("city"));
        filter.sendKeys("");

        WebElement body = driver.findElement(By.name("Submit"));
        body.click();

        List<WebElement> books = driver.findElements(By.tagName("tr"));
        Assert.assertTrue(books.size() == 1);
        
    }

}
