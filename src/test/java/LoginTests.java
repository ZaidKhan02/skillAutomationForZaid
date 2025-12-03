import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class LoginTests extends BaseTest {

    // Can I have these in BaseTest.java?
    LoginPage loginPage;
    HomePage homePage;
    ProfilePage profilePage;

    // part of Parallel testing
    /*
     * @BeforeMethod
     * public void setUpPages() {
     * loginPage = new LoginPage(getDriver());
     * homePage = new HomePage(getDriver());
     * profilePage = new ProfilePage(getDriver());
     * }
     */

    @BeforeMethod
    public void setUpPages() {
        loginPage = new LoginPage(driver); // getDriver()
        homePage = new HomePage(driver);
        profilePage = new ProfilePage(driver);
    }

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
        /* LoginPage loginPage = new LoginPage(driver); */

        loginPage.provideEmail("demo@koel.dev").providePassword("demo").clickLogin();

        /*
         * loginPage.provideEmail("demo@koel.dev");
         * loginPage.providePassword("demo");
         * loginPage.clickLogin();
         */
        /*
         * provideEmail(email);
         * providePassword(password);
         * clickLogin();
         */
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void changeProfileName() throws InterruptedException {
        /*
         * LoginPage loginPage = new LoginPage(driver);
         * HomePage homePage = new HomePage(driver);
         */

        loginPage.provideEmail("demo@koel.dev").providePassword("demo").clickLogin();

        /*
         * loginPage.provideEmail("demo@koel.dev");
         * loginPage.providePassword("demo");
         * loginPage.clickLogin();
         */

        homePage.clickAvatarIcon();

        String randomName = profilePage.generateRandomName();
        System.out.println("The random name is " + randomName);

        profilePage.provideCurrentPassword("demo");
        profilePage.provideProfileName(randomName);

        profilePage.provideEmail("demo@koel.dev");
    }

    @Test
    public void countSongsInPlaylist() throws InterruptedException {
        /* LoginPage loginPage = new LoginPage(driver); */

        loginPage.provideEmail("demo@koel.dev").providePassword("demo").clickLogin();

        /*
         * loginPage.provideEmail("demo@koel.dev");
         * loginPage.providePassword("demo");
         * loginPage.clickLogin();
         */

        choosePlayListByName("skillup");
        displayAllSongs();
        Assert.assertTrue(
                getPlayListDetails().contains(String.valueOf(countSongs())),
                "Playlist song count does not match!");
    }

    @Test(enabled = false, description = "Skip due to conditions failing")
    public void playSongWithContextClick() throws InterruptedException {
        /* LoginPage loginPage = new LoginPage(driver); */

        loginPage.provideEmail("demo@koel.dev").providePassword("demo").clickLogin();

        /*
         * loginPage.provideEmail("demo@koel.dev");
         * loginPage.providePassword("demo");
         * loginPage.clickLogin();
         */

        chooseAllSongsList();
        contextClickFirstSong();
        choosePlay();
    }

    @Test
    public void loginTest() {
        // Page Objects
        /*
         * LoginPage loginPage = new LoginPage(driver);
         * HomePage homePage = new HomePage(driver);
         */
        // Test
        loginPage.provideEmail("demo@koel.dev").providePassword("demo").clickLogin();

        /*
         * loginPage.provideEmail("demo@koel.dev");
         * loginPage.providePassword("demo");
         * loginPage.clickLogin();
         */
        // Assertion
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

}
