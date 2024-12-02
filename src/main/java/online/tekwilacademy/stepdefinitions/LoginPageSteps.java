package online.tekwilacademy.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import online.tekwilacademy.managers.DriverManager;
import online.tekwilacademy.pageobjects.LoginPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class LoginPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    LoginPage loginPage = new LoginPage(driver);


    @And("the login form is populated with the following data:")
    public void theLoginFormIsPopulatedWithTheFollowingData(List<String> collectedDataList) {
        loginPage.completeLoginForm(collectedDataList.get(0), collectedDataList.get(1));
    }


    @When("the loginBtn is clicked")
    public void theLoginBtnIsClicked() {
        loginPage.clickTheLoginBtn();
    }
}
