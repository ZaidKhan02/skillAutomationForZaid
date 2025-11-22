import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    /*
     * @DataProvider(name = "NegativeLoginTestData")
     * public Object[][] getDataFromDataProviders() {
     * return new Object[][] {
     * { "invalid@koel.dev", "invalidPass" },
     * { "demo@koel.dev", "invalidPass" },
     * { "invalid@email.com", "demo" },
     * { "", "" },
     * { "", "demo" },
     * { "demo@koel.dev", "" }
     * };
     * }
     */

    @Test(dataProvider = "NegativeLoginTestData", dataProviderClass = LoginDataProviders.class)
    public void negativeLoginTests(String email, String password) {
        provideEmail(email);
        providePassword(password);
        clickLogin();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        // Pre-condition: chromedriver is set up by BaseTest
        // I dont think we call setupClass, launchBrower, closebrowser becuase those are
        // beforesuite, beforemethod, aftermethod
        /* navigateToPage(); */

        provideEmail("demo@koel.dev");

        providePassword("demo");

        clickLogin();

        isAvatarDisplayed();

    }

    @Test
    public void changeProfileName() throws InterruptedException {
        loginAsUser();

        clickAvatarIcon();

        String randomName = generateRandomName();
        System.out.println("The random name is " + randomName);

        provideCurrentPassword("demo");

        provideProfileName(randomName);

        provideEmail("demo@koel.dev");
    }

    @Test
    public void loginInvalidEmailValidPassword() throws InterruptedException {
        // Pre-condition: chromedriver is set up by BaseTest
        // I dont think we call setupClass, launchBrower, closebrowser becuase those are
        // beforesuite, beforemethod, aftermethod
        /* navigateToPage(); */

        provideEmail("demo@joel.dev");

        providePassword("demo");

        clickLogin();

        /* If I remov these lines, it will pass */
        isAvatarDisplayed();
    }

    @Test
    public void loginValidEmailEmptyPassword() throws InterruptedException {
        // Pre-condition: chromedriver is set up by BaseTest
        // I dont think we call setupClass, launchBrower, closebrowser becuase those are
        // beforesuite, beforemethod, aftermethod
        /* navigateToPage(); */

        provideEmail("demo@joel.dev");

        clickLogin();

        /* If I remov these lines, it will pass */
        isAvatarDisplayed();
    }

}
