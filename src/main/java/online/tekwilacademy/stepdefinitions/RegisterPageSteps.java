package online.tekwilacademy.stepdefinitions;

import io.cucumber.java.en.And;
import online.tekwilacademy.managers.DriverManager;
import online.tekwilacademy.managers.RandomDataManager;
import online.tekwilacademy.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;
import java.util.Map;

public class RegisterPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @And("the register form is populated with data")
    public void theRegisterFormIsPopulatedWithData() {
        // Generate random data
        String firstName = RandomDataManager.getRandomFirstName();
        String lastName = RandomDataManager.getRandomLastName();
        String email = RandomDataManager.getRandomEmail();
        String password = RandomDataManager.getRandomPassword();

        registerPage.completeTheRegisterForm(firstName, lastName, email, password);
    }


    @And("the register form is populated as following:")
    public void theRegisterFormIsPopulatedAsFollowing(Map<String, String> userDetailsMap) {
        String firstNameValue = userDetailsMap.get("firstName");
        if (firstNameValue != null && firstNameValue.toUpperCase().equals("RANDOM")) {
            firstNameValue = RandomDataManager.getRandomFirstName();
        }

        String lastNameValue = userDetailsMap.get("lastName");

        if (lastNameValue != null && lastNameValue.toUpperCase().equals("RANDOM")) {
            lastNameValue = RandomDataManager.getRandomLastName();
        }

        String emailValue = userDetailsMap.get("email");
        if (emailValue != null && emailValue.toUpperCase().equals("RANDOM")) {
            emailValue = RandomDataManager.getRandomEmail();
        }

        String passwordValue = userDetailsMap.get("password");
        if (passwordValue != null && passwordValue.toUpperCase().equals("RANDOM")) {
            passwordValue = RandomDataManager.getRandomPassword();
        }

        registerPage.completeTheRegisterForm(firstNameValue, lastNameValue, emailValue, passwordValue);
    }
}