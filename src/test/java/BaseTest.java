import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

import java.net.MalformedURLException;
import java.net.URI;
import java.nio.charset.MalformedInputException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public String url;
    Actions actions;

    /*
     * @BeforeSuite
     * public void setupClass() {
     * WebDriverManager.chromedriver().setup();
     * }
     */

    // Both are part of parallel testing
    // private static final ThreadLocal<WebDriver> threadDriver = new
    // ThreadLocal<>();

    /*
     * public static WebDriver getDriver() {
     * return threadDriver.get();
     * }
     */

    @BeforeMethod
    @Parameters({ "BaseURL" })
    public void launchBrowser(@Optional("https://demo.koel.dev/#/home") String baseURL) /*
                                                                                         * throws MalformedURLException
                                                                                         */ {
        this.url = baseURL;
        driver = pickBrowser(System.getProperty("browser", "chrome"));
        // part of Parallel testing
        // threadDriver.set(pickBrowser(System.getProperty("browser", "chrome")));
        /*
         * ChromeOptions options = new ChromeOptions();
         * options.addArguments("--remote-allow-origins=*");
         * options.addArguments("--disable-notifications");
         * driver = new ChromeDriver(options);
         */
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        /* navigateToPage(url); */
        driver.get(url);

        // part of Parallel testing
        /*
         * getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         * getDriver().manage().window().maximize();
         * wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
         * actions = new Actions(getDriver());
         */
    }

    public WebDriver pickBrowser(String browser) /* throws MalformedURLException */ {
        // this is for grid selenium
        /*
         * DesiredCapabilities caps = new DesiredCapabilities();
         * String gridURL = "http://192.168.55.103:4444"; //replace with my grid url
         */

        switch (browser.toLowerCase()) {

            case "firefox": // gradle clean test -Dbrowser=firefox
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();

            case "edge": // gradle clean test -Dbrowser=MicrosoftEdge
            case "microsoftedge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return new EdgeDriver(edgeOptions);

            /*
             * case "grid-edge": //gradle clean test -Dbrowser=grid-edge
             * caps.setCapability("browserName", "MicrosoftEdge");
             * return new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
             * 
             * case "grid-firefox": //gradle clean test -Dbrowser=grid-firefox
             * caps.setCapability("browserName", "firefox");
             * return new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
             * 
             * case "grid-chrome": //gradle clean test -Dbrowser=grid-chrome
             * caps.setCapability("browserName", "chrome");
             * return new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
             */

            default: // chrome
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--disable-notifications");
                return new ChromeDriver(chromeOptions);
        }
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    // part of Parallel testing
    /*
     * @AfterMethod
     * public void tearDown() {
     * threadDriver.get().close();
     * threadDriver.remove();
     * }
     */

    /*
     * public void navigateToPage(String url) {
     * driver.get(url);
     * }
     */

    // REMOVE THESE HELPERS BELOW AND MOVE THEM TO THEIR RESPECTIVE OBJECTS

    /*
     * public void provideEmail(String email) {
     * WebElement emailField = wait
     * .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
     * "input[type='email']")));
     * emailField.clear();
     * emailField.sendKeys(email);
     * }
     */

    /*
     * public void providePassword(String password) {
     * WebElement passwordField = wait
     * .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
     * "input[type='password']")));
     * passwordField.clear();
     * passwordField.sendKeys(password);
     * }
     */

    /*
     * public void clickLogin() {
     * WebElement loginBtn = wait
     * .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
     * "button[type='submit']")));
     * loginBtn.click();
     * }
     */

    /*
     * public void isAvatarDisplayed() {
     * WebElement avatarIcon = wait
     * .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
     * ".view-profile")));
     * Assert.assertTrue(avatarIcon.isDisplayed());
     * }
     */

    /*
     * public void clickAvatarIcon() {
     * WebElement avatarIcon = wait
     * .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
     * ".view-profile")));
     * avatarIcon.click();
     * }
     */

    /*
     * public void provideCurrentPassword(String currentPassword) {
     * WebElement currentPasswordField = wait.until(
     * ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
     * "input[data-testid='currentPassword']")));
     * currentPasswordField.clear();
     * currentPasswordField.sendKeys(currentPassword);
     * }
     */

    /*
     * public void provideProfileName(String newName) {
     * WebElement profileNameField = wait
     * .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
     * "input[data-testid='name']")));
     * profileNameField.clear();
     * profileNameField.sendKeys(newName);
     * }
     */

    /*
     * public String generateRandomName() {
     * return UUID.randomUUID().toString().replace("-", "");
     * }
     */

    /*
     * public void searchSong(String songName) {
     * WebElement songNameField =
     * driver.findElement(By.cssSelector("input[type='search']"));
     * songNameField.clear();
     * songNameField.sendKeys(songName);
     * }
     */

    /*
     * public void clickViewAllBtn() {
     * WebElement viewAllBtn =
     * driver.findElement(By.cssSelector("button[data-testid='view-all-songs-btn']")
     * );
     * viewAllBtn.click();
     * }
     */

    /*
     * public void selectFirstSongResult() {
     * WebElement firstSong = driver.findElement(By.
     * xpath("//div[contains(@class, 'items-wrapper')]//div[1]"));
     * firstSong.click();
     * }
     */

    /*
     * public void clickAddToBtn() {
     * WebElement addToBtn = driver.findElement(By.xpath(
     * "//div[@data-testid='song-list-controls']//button[2]"));
     * addToBtn.click();
     * }
     */

    public void chooseAllSongsList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='menu']//li[1]"))).click();
    }

    public void contextClickFirstSong() {
        WebElement firstSongElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='song-list'][1]")));
        actions.contextClick(firstSongElement).perform();
    }

    public void choosePlay() {
        wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//nav[@data-testid='song-context-menu']//span")))
                .click();
        ;
    }

    /*-------------------------------------- */
    public void choosePlayListByName(String playListName) {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[contains(text(),'" + playListName + "')]/..")))
                .click();
    }

    public void displayAllSongs() {
        List<WebElement> songList = driver.findElements(
                By.xpath("//section[@id='playlistWrapper']//div[@class='song-list-wrap']//div[@class='song-item']"));

        System.out.println("Number of Songs found: " + songList.size());

        for (WebElement e : songList) {
            System.out.println(e.getText());
        }
    }

    public String getPlayListDetails() {
        return driver.findElement(
                By.xpath("//section[@id='playlistWrapper']//span[@class='meta text-secondary']")).getText();
    }

    public int countSongs() {
        return driver.findElements(
                By.xpath("//section[@id='playlistWrapper']//div[@class='song-list-wrap']//div[@class='song-item']"))
                .size();
    }

}