package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.example.utils.Wait.waitUntilVisibility;

public class ProductsPage {
    private final WebDriver driver;

    private By fleeceJacketAddToCartBtn = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private By onesieItem = By.id("item_2_title_link");
    private By onesieAddToCartBtn = By.id("add-to-cart");
    private By cartIcon = By.id("shopping_cart_container");


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Add fleece jacket and onesie items to cart
    public void addItemsToCart() {
        driver.findElement(fleeceJacketAddToCartBtn).click();
        driver.findElement(onesieItem).click();
        waitUntilVisibility(driver, "add-to-cart");
        driver.findElement(onesieAddToCartBtn).click();
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }

    public String getCartCountValue() {
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        String cartValue = cartBadge.getText();
        System.out.println("cart has " + cartValue + " items");
        return cartValue;

    }


}