import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SearchBar;

public class Homework16 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        SearchBar searchBar = new SearchBar(driver);

        loginPage.provideEmail("demo@koel.dev");
        loginPage.providePassword("demo");
        loginPage.clickLogin();

        searchBar.searchSong("Dark");

        searchBar.clickViewAllBtn();

        searchBar.selectFirstSongResult();

        searchBar.clickAddToBtn();

    }
}
