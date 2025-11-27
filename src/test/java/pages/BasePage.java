package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    By songNameField = By.cssSelector("input[type='search']");
    By viewAllBtn = By.cssSelector("button[data-testid='view-all-songs-btn']");

    // Constructor Method
    public BasePage(WebDriver driver) {
        this.driver = driver; // can also be WebDriver givenDriver as parameter and then driver = givenDriver
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void searchSong(String songName) {
        findElement(songNameField).clear();
        findElement(songNameField).sendKeys(songName);
    }

    public void clickViewAllBtn() {
        findElement(viewAllBtn).click();
    }
}
