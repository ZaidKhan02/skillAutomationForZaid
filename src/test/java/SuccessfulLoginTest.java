import org.testng.annotations.Test;

public class SuccessfulLoginTest extends BaseTest {

    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        // Pre-condition: chromedriver is set up by BaseTest
        // I dont think we call setupClass, launchBrower, closebrowser becuase those are
        // beforesuite, beforemethod, aftermethod
        /* navigateToPage(); */

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
}
