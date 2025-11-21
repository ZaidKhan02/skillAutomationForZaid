import org.testng.annotations.Test;

public class Homework16 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        loginAsUser();

        searchSong("Dark");
        Thread.sleep(2000);

        clickViewAllBtn();
        Thread.sleep(2000);

        selectFirstSongResult();
        Thread.sleep(2000);

        clickAddToBtn();
        Thread.sleep(2000);

    }
}
