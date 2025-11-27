import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class NegativeLoginTest extends BaseTest {

    @Test
    public void loginInvalidEmailValidPassword() throws InterruptedException {
        // Pre-condition: chromedriver is set up by BaseTest
        // Pre-condition: chromedriver is set up by BaseTest
        // I dont think we call setupClass, launchBrower, closebrowser becuase those are
        // beforesuite, beforemethod, aftermethod
        /* navigateToPage(); */

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("demo@joel.dev");
        loginPage.providePassword("demo");
        loginPage.clickLogin();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }
}
