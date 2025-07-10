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

public class HomePage {
    WebDriver driver;
    @FindBy(name= "q")
    public WebElement searchBox;
    @FindBy(id = "logo")
    public WebElement logo;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void search (String keyword){
        searchBox.sendKeys(keyword);
        searchBox.submit();
    }

    public void ExplicitWait (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
    }

    public void CustomWait(){
        Wait<WebDriver> fluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        fluent.until(d->searchBox.isDisplayed());
    }

    public void HandleAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Title is: " + driver.getTitle());
            alert.accept();
        } catch (NoAlertPresentException ignored) {
        }
    }

    public void ScreenShotOnFailure(String expectedTitle) throws Exception {
        if (!driver.getTitle().contains(expectedTitle)){
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(src.toPath(), new File("fail.png").toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }
}