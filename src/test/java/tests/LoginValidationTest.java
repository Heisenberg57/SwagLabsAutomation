package tests;

import base.BaseTest;
import org.openqa.selenium.By;
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
}
