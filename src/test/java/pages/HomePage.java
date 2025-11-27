package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Element locators
    By userAvatarIcon = By.cssSelector(".view-profile");
    By avatarIcon = By.cssSelector(".view-profile");

    // Helper methods
    public void clickAvatarIcon() {
        findElement(avatarIcon).click();
    }

    public WebElement getUserAvatar() {
        return findElement(userAvatarIcon);
        // like public String and we return string, here we do public WebElement and
        // return an element
    }

}
