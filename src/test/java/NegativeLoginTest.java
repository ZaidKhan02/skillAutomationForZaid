import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class NegativeLoginTest extends BaseTest {

    @Test
    public void loginInvalidEmailValidPassword() throws InterruptedException {
        // Pre-condition: chromedriver is set up by BaseTest
        // Pre-condition: chromedriver is set up by BaseTest
        // I dont think we call setupClass, launchBrower, closebrowser becuase those are
        // beforesuite, beforemethod, aftermethod
        /* navigateToPage(); */

        provideEmail("demo@joel.dev");

        providePassword("demo");

        clickLogin();
        Thread.sleep(2000);

        /* If I remov these lines, it will pass */
        isAvatarDisplayed();
    }
}
