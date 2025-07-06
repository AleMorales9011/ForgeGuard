package ForgeGuard;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicTest {
    private WebDriver driver;

    @Given("I'm at Google's Home Page")
    public void GetToHomePage() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
    }

    @Then("I should be able to extract the Page Title")
    public void ExtractTheTitle() {
        System.out.println("Page Title: " + driver.getTitle());
        // Quit browser
        driver.quit();
    }
}