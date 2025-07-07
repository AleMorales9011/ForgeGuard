package StandaloneTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.AllInOnePage;

import java.net.URL;
import java.time.Duration;

public class AllInOneTest {
    @Test
    public void testGoogleSearchWithEverything() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver;

        boolean useGrid = false;
        if (useGrid) {
            driver = new RemoteWebDriver(new URL("https://localhost:4444"), options);
        } else {
            driver = new ChromeDriver(options);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://google.com");

        AllInOnePage page = new AllInOnePage(driver);
        Assertions.assertNotNull(page.searchBox);
        page.waitForSearchBoxExplicit();
        page.waitForSearchBoxFluent();
        page.search("Selenium WebDriver");

        Assertions.assertTrue(page.logo.isDisplayed(), "Logo is not visible");
        Assertions.assertEquals("Selenium WebDriver - Google Search", driver.getTitle());
        page.handleAlertIfExists();
        page.takeScreenshotOnFailure("Selenium Webdriver");
        driver.quit();
    }
}
