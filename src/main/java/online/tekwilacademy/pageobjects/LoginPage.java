package online.tekwilacademy.pageobjects;

import online.tekwilacademy.managers.ExplicitWaitManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#input-email")
    private WebElement emailInput;

    @FindBy(css = "#input-password")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement loginBtn;

    public void completeLoginForm(String email, String password) {
        ExplicitWaitManager.waitTillElementIsVisible(emailInput);
        emailInput.sendKeys(email);
        ExplicitWaitManager.waitTillElementIsVisible(passwordInput);
        passwordInput.sendKeys(password);
    }
}
