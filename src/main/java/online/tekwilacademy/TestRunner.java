package online.tekwilacademy;

import online.tekwilacademy.managers.DriverManager;
import online.tekwilacademy.managers.RandomDataManager;
import online.tekwilacademy.managers.ScrollManager;
import org.openqa.selenium.*;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://www.google.com/");
        System.out.println("The driver is on page:" + driver.getCurrentUrl());

        String theNameOfTheFirstTab = driver.getWindowHandle();

        // Open a new window and navigate to the DIEZ page
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://tekwillacademy-opencart.online/");
        System.out.println("The driver is on page:" + driver.getCurrentUrl());

        WebElement myAccountDropDownIcon = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        myAccountDropDownIcon.click();

        WebElement registerLink = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registerLink.click();

        //Print the url of the new page
        System.out.println("The driver is on page:" + driver.getCurrentUrl());

        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        firstNameInput.sendKeys(RandomDataManager.getRandomFirstName());

        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
        lastNameInput.sendKeys(RandomDataManager.getRandomLastName());

        WebElement emailInput = driver.findElement(By.id("input-email"));
        String emailData = RandomDataManager.getRandomEmail();
        System.out.println("Email: " + emailData);
        emailInput.sendKeys(emailData);

        WebElement passwordInput = driver.findElement(By.cssSelector("#input-password"));
        String passwordData = RandomDataManager.getRandomPassword(3, 21, true, true);
        System.out.println("Password: " + passwordData);
        passwordInput.sendKeys(passwordData);

        WebElement privacyToggleBar = driver.findElement(By.name("agree"));
        ScrollManager.scrollToElement(privacyToggleBar);

        privacyToggleBar.click();

        WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();
        System.out.println("The driver is on page:" + driver.getCurrentUrl());

        Thread.sleep(3000);

        // Close the current tab
        driver.close();

        driver.switchTo().window(theNameOfTheFirstTab);
        System.out.println("The driver is on page:" + driver.getCurrentUrl());
        driver.quit();
    }
}