package StandaloneTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.HomePage;

import java.net.URL;
import java.time.Duration;

public class HomePageTest {
    @Test
    public void Test () throws Exception {
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        boolean UseGrid = false;
        if (UseGrid){
            driver = new RemoteWebDriver(new URL("https://localhost:4444"), options);
        }else{
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://google.com");

        HomePage page = new HomePage(driver);
        page.search("Selenium");
        Assertions.assertNotNull(page.searchBox);
        page.ExplicitWait();
        page.CustomWait();
        page.search("Selenium");
        Assertions.assertTrue(page.logo.isDisplayed());
        Assertions.assertEquals("Selenium - Google Search", driver.getTitle());
        page.HandleAlert();
        page.ScreenShotOnFailure("Selenium");
        driver.quit();
    }
}