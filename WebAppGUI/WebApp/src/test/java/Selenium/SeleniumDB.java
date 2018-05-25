package Selenium;

import java.util.List;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SeleniumDB {

    static WebDriver driver;
    private static final int WAIT_MAX = 10;

    @BeforeClass
    public static void setup() {

//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nexao\\Downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "chromedriver");
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
            WebElement el = driver.findElement(By.id("option"));
            WebElement button = driver.findElement(By.id("submit"));
            Assert.assertNotNull(el);
            Assert.assertNotNull(button);
            return true;
        });
    }

    @Test
    public void test1() {

        // test for existing city
        setup();

        try {
            Select droplist = new Select(driver.findElement(By.id("option")));
            droplist.selectByIndex(3); // 3 = city

            WebElement filter = driver.findElement(By.name("city"));
            filter.sendKeys("Riga");

            WebElement body = driver.findElement(By.name("Submit"));
            body.click();

            List<WebElement> books = driver.findElements(By.id("modal2"));
            Assert.assertTrue(books.size() == 3);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Test
    public void test2() {

        // test for a city in `Title`, should return emply table
        setup();

        try {
            Select droplist = new Select(driver.findElement(By.id("option")));
            droplist.selectByIndex(2); // 2 = title

            WebElement filter = driver.findElement(By.name("title"));
            filter.sendKeys("Riga");

            WebElement body = driver.findElement(By.name("Submit"));
            body.click();

            List<WebElement> books = driver.findElements(By.id("modal2"));
            Assert.assertTrue(books.isEmpty());

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
