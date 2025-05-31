package ForgeGuard;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;

public class BasicTest {

    @Test
    public void testGooglePageTitle() {
        // WebDriver setup
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Open Google and print title
        driver.get("https://google.com");
        System.out.println("Page Title: " + driver.getTitle());

        // Quit browser
        driver.quit();
    }
}