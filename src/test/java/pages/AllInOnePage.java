package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class AllInOnePage {
    WebDriver driver; // Declare a variable driver of type WebDriver
    @FindBy(name = "q") // Use Page Factory to find the searchBox element by is name "q".
    public WebElement searchBox;
    @FindBy(id = "logo") // Use Page Factory to find the logo element by is id "logo".
    public WebElement logo;

    public AllInOnePage(WebDriver driver) { // Constructor that creates a variable that takes a driver as input.
        this.driver = driver; // It saves the driver into the driver variable.
        PageFactory.initElements(driver, this); // Initialize all FindBy elements
    }

    public void search(String keyword) { // Creates a method that takes a string keyword and send keys to the search box and submit the search.
        searchBox.sendKeys(keyword);
        searchBox.submit();
    }

    public void waitForSearchBoxExplicit() { // Creates a method that creates an explicit wait for the searchBox element.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
    }

    public void waitForSearchBoxFluent() { // Creates a custom wait for the search box element
        Wait<WebDriver> fluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        fluent.until(d -> searchBox.isDisplayed());
    }

    public void handleAlertIfExists() { // Exception handling with alerts.
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert" + alert.getText());
            alert.accept();
        } catch (NoAlertPresentException ignored) {
        }
    }

    public void takeScreenshotOnFailure(String expectedTitle) throws Exception {
        if (!driver.getTitle().contains(expectedTitle)) {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(src.toPath(), new File("fail.png").toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
