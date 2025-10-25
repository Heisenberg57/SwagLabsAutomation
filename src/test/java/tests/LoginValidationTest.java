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
}
