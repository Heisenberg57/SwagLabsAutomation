package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CheckoutTest extends BaseTest {
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void setInventoryPage(){
        checkoutPage = new CheckoutPage(basedriver);
        basedriver.get("https://www.saucedemo.com/");
        loginPage= new LoginPage(basedriver);
        inventoryPage = new InventoryPage(basedriver);

    }

    @Test
    public void testSuccessfulCheckoutflow(){
        //login
        loginPage.login("standard_user","secret_sauce");

        //Add Product
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        Assert.assertEquals(inventoryPage.getCartItemCount(), 1, "Item not added to cart");

        // Step 3: Go to cart and click checkout
        inventoryPage.goToCart();


    }
}
