
# Selenium
Selenium Web Driver : API. Interact with browser programmatically.
```java
WebDriverManager driver = new ChromeDriver();
````
Selenium IDE: Browser Extension. Record text and exports code.
Selenium Grid: Platform. Run parallel test across browsers.
Locators: Object. Defines strategy to find element
```java
By locatorById = By.id("username");
By locatorByName = By.name("email");
By locatorsByPath = By.xpath("//input");
By locatorsByCss = By.cssSelector("div.box");
```
```java
WebElement input = driver.findElement(locatorById);
```
Waits: Class. Handles wait strategies.
- Implicit Wait: Global wait applied to the entire WebDriver session.
```java
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
```
Explicit Wait: Wait for specific condition
```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
```
Custom(fluent) Wait: Advanced Explicit Wait
```java
Wait<WebDriver> fluentWait = new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(15))
        .pollingEvery(Duration.ofSeconds(2))
        .ignoring(NoSuchElementExecption.class);
WebElement searchBox = fluentwait.until(driver1 -> driver1.findElement(By.id("search")));
```
CrossBrowser Testing: Process. Ensure coverage across browsers.
Selenium Grid: Class. Run test on other machines.
```java
ChromeOptions options = new ChromeOptions();
WebDriver driver = new RemoteWebDriver(new URL("https://localhost:4444"), options);
```
Assertions(API Statements): Statement. Validate the outcome of tests.
assertEquals: Equality
```java
String actualTitle = driver.getTitle();
Assertions.assertEquals("Example Domain", actualTitle);
```
assertTrue: Truth
```java 
WebElement logo = driver.findElement(By.id("logo"));
Assertions.assertTrue(logo.isDisplayed());
```
assertNotNull: Null Check
```java
WebElement search = driver.findElement(By.name("q"));
Assertions.assertNotNull(search);
```
POM: Design pattern. Enhance reusability and maintainability.
Page Object Class
```java
public class GoogleHomePage {
        private WebDriver driver;
        private By searchBox = By.name("q");
        public GoogleHomePage(WebDriver driver) {
            this.driver = driver;
        }
        public void search (String keyword) {
            WebElement box = driver.findElement(searchBox);
            box.sendKeys(keyword);
            box.submit();
        }
    }
}
```
Test Class:
```java
public class POMtest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        GoogleHomePage google = new GoogleHomePage(driver);
        google.search("Selenium");
        driver.quit();
    }
}
```
Headless Browser: Mode applied to a browser class.
```java
ChromeOptions options = new ChromeOptions();
option.addArguments("--headless");
WebDriver driver = new ChromeDriver(options);
```
Alerts: Interface. Switch context from Webdriver to pop up.
```java
driver.findElement(By.id("trigger")).click();
Alert alert = driver.switchTo().alert();
alert.accept();
```
Screenshots: Interface with methods to take screenshots.
```java
public class ScreenShots {
    public static void main (String[] args) throws Exeption {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        if (!driver.getTitle().contains("Expected")) {
            File src = ((TakesScreenshot) driver).getScreenshotsAs(OutputType.FILE);
            Files.copy(src.toPath(), new File("fail.png").toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
```
Web Elements: Interface. Abstraction of HTML elements that allow interactions 
via Interaction methods.
```java
WebElement searchBox = driver.findElement(By.name("q"));
searchBox.sendKeys("Selenium");
```
PageFactory: Selenium support class. Automatically initialize WebElements.
in a PageObject. Makes code cleaner and easy to maintain.
Page Object with PageFactory
```java
public class LoginPage {
    WebDriver driver;
    @FindBy(id = "username")
    WebElement usernameField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(id = "login")
    WebElement loginButton;
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void login(String user, String pass) {
        usernameField.sendKeys(user);
        passwordField.sendKeys(pass);
        loginButton.click();
    }
}
```
Test Class:
```java
public class PageFactoryTest {
    public static void main (String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "password");
        driver.quit();
    }
}
```










