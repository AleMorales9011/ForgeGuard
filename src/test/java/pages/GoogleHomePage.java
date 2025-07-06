package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class GoogleHomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators (practice with different types)
    private By searchBoxByName = By.name("q");
    private By searchBoxByCSS = By.cssSelector("textarea.gLFyf");
    private By searchBoxByXPath = By.xpath("//textarea[@name='q']");

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void searchFor(String query) {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBoxByXPath));
        searchBox.sendKeys(query + Keys.ENTER);
    }

    public String getSearchInputPlaceholder() {
        return driver.findElement(searchBoxByCSS).getAttribute("aria-label");
    }
}
