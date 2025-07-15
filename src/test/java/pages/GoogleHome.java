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

public class GoogleHome {
    @FindBy(name = "q")
    public WebElement searchBox;
    @FindBy(id = "logo")
    public WebElement logo;
    WebDriver driver;

    public GoogleHome (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void navigate (){
        driver.get("https://google.com");
    }

    public void search (String keyword) {
        searchBox.sendKeys();
        searchBox.submit();
    }

    public void waitForSearchBoxExplicit () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(searchBox));
    }

    public void waitForSearchBoxFluent () {
        Wait<WebDriver> fluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        fluent.until(d->searchBox.isDisplayed());
    }

    public void handleAlertIfExists () {
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert Text: " + alert.getText());
            alert.accept();
        } catch (NoAlertPresentException ignored) {
        }
    }
    public void takeScreenshotOnFailure (String expectedTitle) throws Exception {
        if (!driver.getTitle().contains(expectedTitle)){
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(src.toPath(), new File("fail.png").toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
