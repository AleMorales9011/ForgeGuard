package StandaloneTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.HomePage;

import java.net.URL;

public class HomePageTest {
    @Test
    public void TestHomePage() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver;

        boolean UseGrid = false;
        if (UseGrid){
            driver = new RemoteWebDriver(new URL("https://localhost:4444"), options);
        }else{
            driver = new ChromeDriver();
        }

        HomePage page = new HomePage(driver);
        page.Navigate();
        Assertions.assertNotNull(page.searchBox);
        Assertions.assertTrue(page.logo.isDisplayed());
        Assertions.assertEquals("Selenium", driver.getTitle());
        page.search("Selenium");
        page.ExplicitWait();
        page.CustomWait();
        page.HandleAlert();
        page.ScreenShotOnFailure("Selenium - Google Search");
        driver.quit();
    }
}