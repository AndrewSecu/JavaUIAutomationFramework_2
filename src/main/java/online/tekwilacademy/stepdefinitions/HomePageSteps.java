package online.tekwilacademy.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import online.tekwilacademy.managers.DriverManager;
import online.tekwilacademy.pageobjects.HomePage;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    HomePage homePage = new HomePage(driver);

    @Given("The Home Page is displayed")
    public void theHomePageIsDisplayed() {
        driver.get("https://tekwillacademy-opencart.online/");
    }

    @And("Register Page is accessed from the Home Page buttons")
    public void registerPageIsAccessedFromTheHomePageButtons() {
        homePage.navigateToRegisterPage();
    }
}
