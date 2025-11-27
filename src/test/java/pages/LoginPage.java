package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) { // constructor
        super(driver);
    }

    @FindBy(css = "input[type='email']")
    WebElement emailField;

    @FindBy(css = "input[type='password']")
    WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    WebElement loginBtn;
    // WebElement
    /*
     * By emailField = By.cssSelector("input[type='email']");
     * By passwordField = By.cssSelector("input[type='password']");
     * By loginBtn = By.cssSelector("button[type='submit']");
     */

    // Helper Methods
    public /* void */ LoginPage provideEmail(String email) {
        /*
         * findElement(emailField).clear();
         * findElement(emailField).sendKeys(email);
         */
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public /* void */ LoginPage providePassword(String password) {
        /*
         * findElement(passwordField).clear();
         * findElement(passwordField).sendKeys(password);
         */
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public /* void */ LoginPage clickLogin() {
        /* findElement(loginBtn).click(); */
        loginBtn.click();
        return this;
    }

    /*
     * public void loginToKoel() {
     * provideEmail("demo@koel.dev");
     * providePassword("demo");
     * clickLogin();
     * }
     */
}
