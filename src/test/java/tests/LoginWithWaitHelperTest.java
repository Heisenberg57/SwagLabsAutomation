package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.WaitHelper;

public class LoginWithWaitHelperTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(LoginWithWaitHelperTest.class);

    @Test

    public void testLoginUsingWaitHelper(){
        WebDriver driver = getDriver();

        driver.get("https://www.saucedemo.com/");

        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        WaitHelper.waitForVisibility(driver,usernameField,10);
        usernameField.sendKeys("standard_user");

        WaitHelper.waitForVisibility(driver,usernameField,10);
        passwordField.sendKeys("secret_sauce");

        WaitHelper.waitForClickable(driver,loginButton,10);
        loginButton.click();

        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
        WaitHelper.waitForVisibility(driver, cartIcon, 10);

        Assert.assertTrue(cartIcon.isDisplayed(), "✅ Login successful - Cart icon visible!");
        System.out.println("🎉 Login verified successfully using WaitHelper!");

    }
}
