package ForgeGuard;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormSteps {
    WebDriver driver;
    WebDriverWait wait;
    private String username;
    private String number;
    private String date;
    private String payment;

    @Given("I am in the form page")
    public void i_am_in_the_form_page() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
        driver = new ChromeDriver(options);

        driver.get("https://practice.expandtesting.com/form-validation");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("I extract the information from the database")
    public void i_extract_the_information_from_the_database() throws Exception {

        try (Connection connection = DriverManager.getConnection("jdbc:h2:file:C:/03JOB SEARCH/04ForgeGuard/ForgeGuard/data/testdb", "sa", "");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS WHERE ID = 2;")) {
            // Connect to the H2 database

            // Execute query to fetch user data
            if (resultSet.next()) {
                // Store the retrieved data into instance variables
                this.username = resultSet.getString("NAME");
                this.number = resultSet.getString("CONTACT_NUMBER");
                this.date = resultSet.getString("PICKUP_DATE");
                this.payment = resultSet.getString("PAYMENT_METHOD");
            } else {
                throw new Exception("No data found in the USERS table.");
            }
        }
        // Ensure resources are closed properly
    }

    @When("I use the information to fill up the form")
    public void i_use_the_information_to_fill_up_the_form() {
        // Locate the form fields
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("validationCustom01")));
        WebElement numberField = driver.findElement(By.id("validationCustom05"));
        WebElement dateField = driver.findElement(By.name("pickupdate"));
        Select paymentField = new Select(driver.findElement(By.id("validationCustom04")));
        WebElement submitButton = driver.findElement(By.xpath("/html/body/main/div[3]/div/div/div/div/form/div[5]/button"));

        // Fill the form with extracted data
        usernameField.sendKeys(username);
        numberField.sendKeys(number);
        dateField.sendKeys(date);
        paymentField.selectByVisibleText(payment);
        submitButton.click();
    }

    @Then("I should see the message{string}")
    public void i_should_see_the_message(String expectedMessage) {
        // Verify the success message
        WebElement submissionMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/div[3]/div/div/p")));
        assertEquals(expectedMessage, submissionMessage.getText(), "The message does not match");
        driver.quit();
    }
}
