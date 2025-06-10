package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage {
    private final WebDriver driver;


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckout() {
        driver.findElement(By.id("checkout")).click();
    }

    // Get all item names in the cart
    public List<String> getItemNames() {
        List<WebElement> nameElements = driver.findElements(By.className("inventory_item_name"));
        List<String> itemNames = new ArrayList<>();
        for (WebElement el : nameElements) {
            itemNames.add(el.getText().trim());

        }
        System.out.println("Item prices are " + itemNames);

        return itemNames;
    }

    // Get all item prices in the cart
    public List<String> getItemPrices() {
        List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
        List<String> itemPrices = new ArrayList<>();
        for (WebElement el : priceElements) {
            itemPrices.add(el.getText().trim());

        }
        System.out.println("Item prices are " + itemPrices);

        return itemPrices;


    }

}