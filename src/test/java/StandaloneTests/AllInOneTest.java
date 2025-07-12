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
    public void testGoogleSearchWithEverything() throws Exception { // Executes the tests from the Google Home Page.
        ChromeOptions options = new ChromeOptions(); // Initialize the class ChromeOptions.
        options.addArguments("--headless"); // Add the headless mode.
        WebDriver driver;  // Creates a driver variable of type WebDriver.

        boolean useGrid = false; // Logic to implement Grid if required.
        if (useGrid) {
            driver = new RemoteWebDriver(new URL("https://localhost:4444"), options);
        } else {
            driver = new ChromeDriver(options);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implements implicit wait.
        driver.get("https://google.com");  // Navigates to page.

        AllInOnePage page = new AllInOnePage(driver); // Initialize the Page Object.
        Assertions.assertNotNull(page.searchBox); // Asserts the  searchBox element is not null.
        page.waitForSearchBoxExplicit(); // Call the explicit wait.
        page.waitForSearchBoxFluent(); // Calls the fluent Wait.
        page.search("Selenium WebDriver"); // Send keys to the search box.

        Assertions.assertTrue(page.logo.isDisplayed(), "Logo is not visible"); //Asserts the logo.
        Assertions.assertEquals("Selenium WebDriver - Google Search", driver.getTitle()); // Asserts the Title.
        page.handleAlertIfExists(); // Calls the Alert Handling method.
        page.takeScreenshotOnFailure("Selenium Webdriver"); // Calls the screenshot method
        driver.quit(); // Close the session.
    }
}
