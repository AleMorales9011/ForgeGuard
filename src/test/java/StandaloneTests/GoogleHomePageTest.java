package StandaloneTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.GoogleHome;

import java.net.URL;
import java.time.Duration;

public class GoogleHomePageTest {
    @Test
    public void TestGoogleHomePage() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver;

        boolean UseGrid = false;
        if (UseGrid) {
            driver = new RemoteWebDriver(new URL("https:localhost:4444"), options);
        } else {
            driver = new ChromeDriver();
        }
        GoogleHome page = new GoogleHome(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        page.navigate();
        Assertions.assertTrue(page.searchBox.isDisplayed());
        page.waitForSearchBoxExplicit();
        page.waitForSearchBoxFluent();
        page.search("Selenium");
        Assertions.assertTrue(page.logo.isDisplayed());
        Assertions.assertEquals("Selenium - Google Search", driver.getTitle());
        page.handleAlertIfExists();
        page.takeScreenshotOnFailure("Selenium");
        driver.quit();
    }
}
