package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTest extends BaseTest {

    LoginPage lopa;

    @BeforeMethod
    public void setLopa(){
        lopa = new LoginPage(basedriver);
        basedriver.get("https://www.saucedemo.com/");
    }

    @Test
    public void testValidLogin(){
        lopa.login("standard_user","secret_sauce");

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = basedriver.getCurrentUrl();

        assert actualUrl.equals(expectedUrl) :"Login failed! Expected: " + expectedUrl + " but got: " + actualUrl;


    }

}
