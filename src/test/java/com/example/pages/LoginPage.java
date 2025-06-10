package com.example.pages;

import org.openqa.selenium.*;

import static com.example.utils.Wait.waitUntilVisibility;


public class LoginPage {
    private final WebDriver driver;

    private By userNameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String userName, String password) {

        waitUntilVisibility(driver, "user-name");
        driver.findElement(userNameField).sendKeys(userName);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }


}