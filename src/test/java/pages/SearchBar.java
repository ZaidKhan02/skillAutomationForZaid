package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBar extends BasePage {

    public SearchBar(WebDriver driver) {
        super(driver);
    }

    /*
     * By songNameField = By.cssSelector("input[type='search']");
     * By viewAllBtn = By.cssSelector("button[data-testid='view-all-songs-btn']");
     */
    By firstSong = By.xpath("//div[contains(@class, 'items-wrapper')]//div[1]");
    By addToBtn = By.xpath("//div[@data-testid='song-list-controls']//button[2]");

    /*
     * public void searchSong(String songName) {
     * findElement(songNameField).clear();
     * findElement(songNameField).sendKeys(songName);
     * }
     * 
     * public void clickViewAllBtn() {
     * findElement(viewAllBtn).click();
     * }
     */

    public void selectFirstSongResult() {
        findElement(firstSong).click();
    }

    public void clickAddToBtn() {
        findElement(addToBtn).click();
    }

}
