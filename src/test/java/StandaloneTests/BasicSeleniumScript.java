package StandaloneTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
public class BasicSeleniumScript {
    public static void main(String[] args) {
        // 1. Start the session ✅
        WebDriver driver = new ChromeDriver();

        // 2. Take action on the browser ✅
        driver.get("https://www.google.com");

        // 3. Request browser information ✅
        System.out.println("Page Title is: " + driver.getTitle());

        // 4. Establish a wait strategy ✅
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 5. Find an element (using findElement directly) ✅
        WebElement searchBox = driver.findElement(By.name("q"));
        // 6. Take action on the element ✅
        searchBox.sendKeys("Selenium");

        // 7. Request element information ✅
        System.out.println("Placeholder: " + searchBox.getAttribute("aria-label"));

        // 8. End the session ✅
        driver.quit();
    }
}
