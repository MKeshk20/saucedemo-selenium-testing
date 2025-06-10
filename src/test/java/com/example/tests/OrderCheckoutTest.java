package com.example.tests;

import com.example.base.BaseTest;
import com.example.pages.*;
import com.example.utils.UserInfoFetcher;
import com.example.utils.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class OrderCheckoutTest extends BaseTest {

    String userName = "standard_user";
    String password = "secret_sauce";


    List<String> expectedNames = Arrays.asList(
            "Sauce Labs Fleece Jacket",
            "Sauce Labs Onesie"
    );

    List<String> expectedPrices = Arrays.asList(
            "$49.99",
            "$7.99"
    );
    String[] mockUserData = UserInfoFetcher.getRandomUserInfo();
    String firstName = mockUserData[0];
    String lastName = mockUserData[1];
    String postalCode = mockUserData[2];


    // Verifies that the cart icon correctly shows a count of 2 after adding two items
    @Test
    public void validateCartCount() {
        LoginPage sauceDemoLogin = new LoginPage(driver);
        sauceDemoLogin.login(userName, password);
        Wait.setImplicitWait(driver, 10);
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addItemsToCart();
        String countValue = productsPage.getCartCountValue();
        Assert.assertEquals(countValue, "2", "Cart count should be 2");
    }

    // Verifies that the correct items names and their prices appear correctly in the cart
    @Test
    public void validateCartItems() {
        LoginPage sauceDemoLogin = new LoginPage(driver);
        sauceDemoLogin.login(userName, password);
        Wait.setImplicitWait(driver, 10);
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addItemsToCart();
        productsPage.openCart();
        CartPage cartPage = new CartPage(driver);
        List<String> actualNames = cartPage.getItemNames();
        List<String> actualPrices = cartPage.getItemPrices();
        Assert.assertEquals(actualNames, expectedNames, "Item names do not match");
        Assert.assertEquals(actualPrices, expectedPrices, "Item prices do not match");
    }


    // Verifies that subtotal, tax, and total are calculated correctly on the overview page
    @Test
    public void validateOrderDetails() {
        LoginPage sauceDemoLogin = new LoginPage(driver);
        sauceDemoLogin.login(userName, password);
        Wait.setImplicitWait(driver, 10);
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addItemsToCart();
        productsPage.openCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();
        UserDataPage userDataPage = new UserDataPage(driver);
        userDataPage.enterUserInfo(firstName, lastName, postalCode);
        userDataPage.clickContinue();
        OverviewPage overviewPage = new OverviewPage(driver);
        String totalBeforeTax = overviewPage.getSubTotal();
        String taxValue = overviewPage.getTaxValue();
        String orderTotal = overviewPage.getOrderToral();
        Assert.assertEquals(totalBeforeTax, "57.98", "Subtotal is not calculated correctly");
        Assert.assertEquals(taxValue, "4.64", "Tax is not calculated correctly");
        Assert.assertEquals(orderTotal, "62.62", "Order total is not calculated correctly");


    }

    // Verifies that the user can complete the order and sees a success message
    @Test
    public void validateOrderCompletion() {
        LoginPage sauceDemoLogin = new LoginPage(driver);
        sauceDemoLogin.login(userName, password);
        Wait.setImplicitWait(driver, 10);
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addItemsToCart();
        productsPage.openCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();
        UserDataPage userDataPage = new UserDataPage(driver);
        userDataPage.enterUserInfo(firstName, lastName, postalCode);
        userDataPage.clickContinue();
        OverviewPage overviewPage = new OverviewPage(driver);
        overviewPage.clickFinish();
        OrderCompletionPage orderCompletionPage = new OrderCompletionPage(driver);
        String orderStatus = orderCompletionPage.isOrderCompleted();
        String orderCompletionText = orderCompletionPage.getOrderCompletionText();
        Assert.assertEquals(orderStatus, "Checkout: Complete!", "Order status is not complete");
        Assert.assertEquals(orderCompletionText, "Thank you for your order!", "Order completion message not displayed");
    }
}