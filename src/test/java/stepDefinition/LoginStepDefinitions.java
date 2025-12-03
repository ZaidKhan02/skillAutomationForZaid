package stepDefinition;

import java.time.Duration;

import org.checkerframework.common.reflection.qual.GetClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;
import io.cucumber.java.After;


public class LoginStepDefinitions {

    WebDriver driver;
    WebDriverWait wait;

    LoginPage loginPage;
    HomePage homePage;
    ProfilePage profilePage;

    @Before
    public void setUpPages() {
        loginPage = new LoginPage(driver); // getDriver()
        homePage = new HomePage(driver);
        profilePage = new ProfilePage(driver);
    }

    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Given("I open Login Page")
    public void openLoginPage() {
        driver.get("http://testkoel.skillup.study/#/home");
    }

    @When("I enter email {string}")
    public void i_enter_email(String email) {
        loginPage.provideEmail(email);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']"))).sendKeys(email);
    }

    @And("I enter password {string}")
    public void i_enter_password(String password) {
        loginPage.providePassword(password);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']"))).sendKeys(password);
    }

    @And("I click login")
    public void clickSubmit() {
        loginPage.clickLogin();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']"))).click();
    }

    @Then("I am logged in") 
        public void userIsLoggedIn() {
            Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
        }
}
