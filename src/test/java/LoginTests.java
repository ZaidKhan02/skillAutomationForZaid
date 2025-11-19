import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        // Pre-condition: chromedriver is set up by BaseTest
        // I dont think we call setupClass, launchBrower, closebrowser becuase those are
        // beforesuite, beforemethod, aftermethod
        navigateToPage();

        provideEmail("demo@koel.dev");

        providePassword("demo");

        clickLogin();

        Thread.sleep(2000);

        isAvatarDisplayed();

    }

    @Test
    public void changeProfileName() throws InterruptedException {
        loginAsUser();

        clickAvatarIcon();
        Thread.sleep(2000);

        String randomName = generateRandomName();
        System.out.println("The random name is " + randomName);

        provideCurrentPassword("demo");
        Thread.sleep(2000);

        provideProfileName(randomName);
        Thread.sleep(2000);

        provideEmail("demo@koel.dev");
        Thread.sleep(2000);
    }

    @Test
    public void loginInvalidEmailValidPassword() throws InterruptedException {
        // Pre-condition: chromedriver is set up by BaseTest
        // I dont think we call setupClass, launchBrower, closebrowser becuase those are
        // beforesuite, beforemethod, aftermethod
        navigateToPage();

        provideEmail("demo@joel.dev");

        providePassword("demo");

        clickLogin();
        Thread.sleep(2000);

        /* If I remov these lines, it will pass */
        isAvatarDisplayed();
    }

    @Test
    public void loginValidEmailEmptyPassword() throws InterruptedException {
        // Pre-condition: chromedriver is set up by BaseTest
        // I dont think we call setupClass, launchBrower, closebrowser becuase those are
        // beforesuite, beforemethod, aftermethod
        navigateToPage();

        provideEmail("demo@joel.dev");

        clickLogin();

        Thread.sleep(2000);

        /* If I remov these lines, it will pass */
        isAvatarDisplayed();
    }

}
