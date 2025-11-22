import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public String url;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({ "BaseURL" })
    public void launchBrowser(@Optional("https://demo.koel.dev/#/home") String baseURL) {
        this.url = baseURL;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        navigateToPage(url);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public void navigateToPage(String url) {
        driver.get(url);
    }

    public void provideEmail(String email) {
        /*
         * WebElement emailField =
         * driver.findElement(By.cssSelector("input[type='email']"));
         */
        WebElement emailField = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        /*
         * WebElement passwordField =
         * driver.findElement(By.cssSelector("input[type='password']"));
         */
        WebElement passwordField = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        /*
         * WebElement loginBtn =
         * driver.findElement(By.cssSelector("button[type='submit']"));
         */
        WebElement loginBtn = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        loginBtn.click();
    }

    public void isAvatarDisplayed() {
        /*
         * WebElement avatarIcon = driver.findElement(By.cssSelector(".view-profile"));
         */
        WebElement avatarIcon = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".view-profile")));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    public void clickAvatarIcon() {
        /*
         * WebElement avatarIcon = driver.findElement(By.cssSelector(".view-profile"));
         */
        WebElement avatarIcon = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".view-profile")));
        avatarIcon.click();
    }

    public void provideCurrentPassword(String currentPassword) {
        /*
         * WebElement currentPasswordField =
         * driver.findElement(By.cssSelector("input[data-testid='currentPassword']"));
         */
        WebElement currentPasswordField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-testid='currentPassword']")));
        currentPasswordField.clear();
        currentPasswordField.sendKeys(currentPassword);
    }

    public void provideProfileName(String newName) {
        /*
         * WebElement profileNameField =
         * driver.findElement(By.cssSelector("input[data-testid='name']"));
         */
        WebElement profileNameField = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-testid='name']")));
        profileNameField.clear();
        profileNameField.sendKeys(newName);
    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public void searchSong(String songName) {
        WebElement songNameField = driver.findElement(By.cssSelector("input[type='search']"));
        songNameField.clear();
        songNameField.sendKeys(songName);
    }

    public void clickViewAllBtn() {
        WebElement viewAllBtn = driver.findElement(By.cssSelector("button[data-testid='view-all-songs-btn']"));
        viewAllBtn.click();
    }

    public void selectFirstSongResult() {
        WebElement firstSong = driver.findElement(By.xpath("//div[contains(@class, 'items-wrapper')]//div[1]"));
        firstSong.click();
    }

    public void clickAddToBtn() {
        WebElement addToBtn = driver.findElement(By.xpath("//div[@data-testid='song-list-controls']//button[2]"));
        addToBtn.click();
    }

    public void loginAsUser() {
        /* navigateToPage(); */
        provideEmail("demo@koel.dev");
        providePassword("demo");
        clickLogin();
    }

}