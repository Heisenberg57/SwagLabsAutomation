import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class OpenBrowserTest extends BaseTest {



    @Test
    public void loginTest(){
        //open website
        basedriver.get("https://www.saucedemo.com");

        //enter credentials and login
        basedriver.findElement(By.id("user-name")).sendKeys("standard_user");
        basedriver.findElement(By.id("password")).sendKeys("secret_sauce");
        basedriver.findElement(By.id("login-button")).click();

        WebDriverWait wait = new WebDriverWait(basedriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_link")));
        boolean isLogin = basedriver.findElement(By.className("shopping_cart_link")).isDisplayed();

        Assert.assertTrue(isLogin,"Login is succesfull");
        System.out.println("Test Passed ");


    }

    @Test
    public void verifyInvalidLogin(){
        //open website
        basedriver.get("https://www.saucedemo.com");

        //enter credentials and login
        basedriver.findElement(By.id("user-name")).sendKeys("wrong_user");
        basedriver.findElement(By.id("password")).sendKeys("secret_sauce");
        basedriver.findElement(By.id("login-button")).click();

        boolean errorDisplayed = basedriver.findElement(By.className("error-button")).isDisplayed();

        Assert.assertTrue(errorDisplayed,"Login failed, Invalid Credentials bruv");

        System.out.println("Man login is failing bruv, You gotta put em right creds");

    }



}
