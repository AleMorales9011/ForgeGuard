package StandaloneTests;

import pages.GoogleHomePage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class BasicPracticeTest {

    public static void main(String[] args) {

        // Headless Browser Config ✅
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // or "--headless" for older versions

        // Start the session ✅
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);

        // Implicit Wait (for general stability) ✅
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Navigate ✅
        driver.get("https://www.google.com");

        // Page Object usage ✅
        GoogleHomePage google = new GoogleHomePage(driver);

        // Explicit Wait already used in POM
        google.searchFor("Selenium WebDriver");

        // Request element info ✅
        System.out.println("Search box label: " + google.getSearchInputPlaceholder());

        // Practice: handle alert if triggered (UI handling) ✅
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert message: " + alert.getText());
            alert.dismiss();
        } catch (NoAlertPresentException ignored) {}

        // Practice: switch to iframe (UI handling) ✅
        try {
            driver.switchTo().frame(0); // example index
            System.out.println("Switched to iframe.");
            driver.switchTo().defaultContent();
        } catch (NoSuchFrameException ignored) {}

        // End session ✅
        driver.quit();
    }
}
