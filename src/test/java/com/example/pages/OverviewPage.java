package com.example.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OverviewPage {
    private final WebDriver driver;

    private By finishBtn = By.id("finish");
    private By subtotal = By.className("summary_subtotal_label");
    private By taxValue = By.className("summary_subtotal_label");
    private By orderTotal = By.className("summary_total_label");


    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFinish() {
        driver.findElement(finishBtn).click();
    }

    public String getSubTotal() {
        return driver.findElement(subtotal).getText().trim().split("\\$")[1];

    }

    public String getTaxValue() {
        return driver.findElement(taxValue).getText().trim().split("\\$")[1];

    }

    public String getOrderToral() {
        return driver.findElement(orderTotal).getText().trim().split("\\$")[1];

    }


}