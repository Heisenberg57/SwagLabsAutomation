package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class InventoryTest extends BaseTest {

    InventoryPage it;

    @BeforeMethod
    public void setupInventory(){
        it = new InventoryPage(basedriver);
        basedriver.get("https://www.saucedemo.com/");
        LoginPage lg = new LoginPage(basedriver);
        lg.login("standard_user","secret_sauce");
    }

    @Test
    public void testAddSingleProductToCart(){
        it.addProductToCart("Sauce Labs Backpack");
        Assert.assertEquals(it.getCartItemCount(),1);
    }
}
