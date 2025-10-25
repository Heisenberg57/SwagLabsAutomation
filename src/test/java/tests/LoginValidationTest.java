package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginValidationTest extends BaseTest {

    @Test(priority = 1)
    public void validLoginTest(){
        basedriver.get("https://www.saucedemo.com");

        basedriver.findElement(By.id("user-name")).sendKeys("standard_user");
        basedriver.findElement(By.id("password")).sendKeys("secret_sauce");
        basedriver.findElement(By.id("login-button")).click();

        WebDriverWait wait = new WebDriverWait(basedriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("inventory"));

        String actualTitle = basedriver.getTitle();
        String actualUrl = basedriver.getCurrentUrl();

        Assert.assertEquals(actualTitle, "Swag Labs", " Title mismatch after login!");
        Assert.assertTrue(actualUrl.contains("inventory"), " Login failed, not redirected to inventory page.");

        System.out.println("✅ Valid Login Test Passed!");

    }

    @Test(priority = 2)

    public void invalidLoginTest(){
        basedriver.get("https://www.saucedemo.com");

        basedriver.findElement(By.id("user-name")).sendKeys("wrong_user");
        basedriver.findElement(By.id("password")).sendKeys("wrong_pass");
        basedriver.findElement(By.id("login-button")).click();

        WebDriverWait wait = new WebDriverWait(basedriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']")));

        String errorText = basedriver.findElement(By.cssSelector("[data-test='error']")).getText();
        System.out.println("Error Message Displayed: " + errorText);

        // Assertion for validation
        Assert.assertTrue(errorText.contains("Username and password do not match"),
                " Unexpected error message or login did not fail as expected.");

        System.out.println("✅ Invalid Login Test Passed!");
    }

    @Test(priority = 3)
    public void VerifyElementNaPostLogout(){
        basedriver.get("https://www.saucedemo.com");

        basedriver.findElement(By.id("user-name")).sendKeys("standard_user");
        basedriver.findElement(By.id("password")).sendKeys("secret_sauce");
        basedriver.findElement(By.id("login-button")).click();

        WebDriverWait wait = new WebDriverWait(basedriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("inventory"));


        basedriver.findElement(By.id("react-burger-menu-btn")).click();


        //wait for logout button to appear
        WebDriverWait wait2 = new WebDriverWait(basedriver, Duration.ofSeconds(10));
        WebElement logoutbutton = wait2.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));

        logoutbutton.click();

        // Wait until redirected to login page again
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));

        boolean isCartVisible = isElementPresent(By.className("shopping_cart_link"));
        Assert.assertFalse(isCartVisible, " Cart icon still visible after logout — logout may have failed.");

        System.out.println(" Logout successful — protected element not visible anymore.");


    }

    // Helper to safely check if element exists without throwing an exception
    private boolean isElementPresent(By locator) {
        try {
            return basedriver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
