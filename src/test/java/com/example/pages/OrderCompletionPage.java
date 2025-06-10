package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class OrderCompletionPage {
    private final WebDriver driver;

    private By orderCompletionText = By.className("complete-header");
    private By checkoutStatus = By.className("title");

    public OrderCompletionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String isOrderCompleted() {
        return driver.findElement(checkoutStatus).getText();
    }

    public String getOrderCompletionText() {
        return driver.findElement(orderCompletionText).getText();
    }


}