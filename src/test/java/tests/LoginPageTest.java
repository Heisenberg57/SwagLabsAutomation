package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;
import utils.ScreenshotUtil;

public class LoginPageTest extends BaseTest {

    LoginPage lopa;

    @BeforeMethod
    public void setLopa(){
        lopa = new LoginPage(basedriver);
        basedriver.get("https://www.saucedemo.com/");
    }

    @Test
    public void verifyLogin() {
        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");

        basedriver.findElement(By.id("user-name")).sendKeys(username);
        basedriver.findElement(By.id("password")).sendKeys(password);
        basedriver.findElement(By.id("login-button")).click();
        ScreenshotUtil.captureScreenshot(basedriver, "testLogin_Failed");

        Assert.assertTrue(basedriver.getCurrentUrl().contains("inventory"), "Login failed");
        System.out.println("✅ Login Successful");
    }

//    @Test
//    public void testValidLogin(){
//        lopa.login("standard_user","secret_sauce");
//
//        String expectedUrl = "https://www.saucedemo.com/inventory.html";
//        String actualUrl = basedriver.getCurrentUrl();
//
//        assert actualUrl.equals(expectedUrl) :"Login failed! Expected: " + expectedUrl + " but got: " + actualUrl;
//
//
//    }

}
