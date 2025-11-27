package pages;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    By currentPasswordField = By.cssSelector("input[data-testid='currentPassword']");
    By profileNameField = By.cssSelector("input[data-testid='name']");
    By emailField = By.cssSelector("input[type='email']");

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public void provideCurrentPassword(String currentPassword) {
        findElement(currentPasswordField).clear();
        findElement(currentPasswordField).sendKeys(currentPassword);
    }

    public void provideProfileName(String newName) {
        findElement(profileNameField).clear();
        findElement(profileNameField).sendKeys(newName);
    }

    public void provideEmail(String email) {
        findElement(emailField).clear();
        findElement(emailField).sendKeys(email);
    }
}
