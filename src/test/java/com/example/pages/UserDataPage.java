package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.example.utils.Wait.waitUntilVisibility;

public class UserDataPage {

    private final WebDriver driver;

    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueBtn = By.id("continue");


    public UserDataPage(WebDriver driver) {
        this.driver = driver;
    }

    // Enter user info fetched form the API
    public void enterUserInfo(String firstName, String lastName, String postalCode) {
        System.out.println("Fetched First Name: " + firstName);
        System.out.println("FetchedLast Name: " + lastName);
        System.out.println("Fetched Zip Code: " + postalCode);
        waitUntilVisibility(driver, "first-name");
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);

    }


    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }
}




