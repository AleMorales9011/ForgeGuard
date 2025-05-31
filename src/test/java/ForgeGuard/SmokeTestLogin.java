package ForgeGuard;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmokeTestLogin {
    WebDriver driver;
    WebDriverWait wait;
    private String username;
    private String password;

    @Given("I am in the login page")
    public void i_am_on_the_login_page() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
        driver = new ChromeDriver(options);

        driver.get("https://practice.expandtesting.com/login");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("I enter the valid credentials {string} and {string}")
    public void i_enter_the_valid_credentials(String username, String password) {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"username\"]")));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='login']/button")));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    @Then("I should be redirected to the secure page")
    public void i_should_be_redirected_to_the_secure_page() {
        String currentUrl = wait.until(ExpectedConditions.urlContains("secure")) ? driver.getCurrentUrl() : "";
        assertTrue(currentUrl.contains("secure"), "The user is not redirected to the secure page.");

    }

    @Then("I should see a welcome message {string}")
    public void i_should_see_a_welcome_message(String expectedMessage) {
        WebElement welcomeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"flash\"]")));
        assertTrue(welcomeMessage.isDisplayed(), "Welcome message is not displayed");
        assertEquals(expectedMessage, welcomeMessage.getText(), "The message does not match");

        driver.quit();
    }

    @When("I enter the invalid credentials {string} and {string}")
    public void i_enter_the_invalid_credentials(String username, String password) {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"username\"]")));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedMessage) {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");
        assertEquals(expectedMessage, errorMessage.getText(), "Text does not match");

        driver.quit();
    }

    @When("I enter the special character{string}and{string}")
    public void i_enter_the_special_character(String special_one, String special_two) {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"username\"]")));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button"));
        usernameField.sendKeys(special_one);
        passwordField.sendKeys(special_two);
        loginButton.click();
    }

    @Then("I should see an error{string}")
    public void i_should_see_an_error(String expectedMessage) {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");
        assertEquals(expectedMessage, errorMessage.getText(), "Text does not match");

        driver.quit();
    }

    @When("I query the database for the credentials")
    public void i_query_the_database_for_the_credentials() throws Exception {
        //Step 01 Connect to the database.
        Connection connection = DriverManager.getConnection("jdbc:h2:file:./data/testdb", "sa", "");
        Statement statement = connection.createStatement();
        // Step 02 Create the table if it does not exist.
        statement.execute("CREATE TABLE IF NOT EXISTS USERS (ID INT PRIMARY KEY, NAME VARCHAR(255), PASSWORD VARCHAR(255));");
        // Step 03 Insert data if the table is empty.
        statement.execute("MERGE INTO USERS KEY(ID) VALUES (1, 'practice', 'SuperSecretPassword!');");
        // Step 04 Query the credentials.
        ResultSet resultSet = statement.executeQuery("SELECT NAME, PASSWORD FROM USERS WHERE ID = 1;");
        // Step 05 Move to the first result row.
        resultSet.next();

        // Step 06 Store the credentials in temporary(within the method) variables.
        String username = resultSet.getString("NAME");
        String password = resultSet.getString("PASSWORD");
        // Step 07 Transfer data from local to instance variables so they can be accessed from outside the method.
        this.username = username;
        this.password = password;

    }

    @Then("I should use those credentials to log in")
    public void i_should_use_those_credentials_to_log_in() {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"username\"]")));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button"));

        // Step 08 Request the data from the instance variables to log in.
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

    }

    @And("I should see a message{string}")
    public void i_should_see_a_message(String message) {
        WebElement welcomeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/div[4]/div/h1")));
        assertTrue(welcomeMessage.isDisplayed(), "Welcome message is not displayed");
        assertEquals(message, welcomeMessage.getText(), "The message does not match");

        driver.quit();
    }
}




