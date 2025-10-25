package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LoginSoftAssertTest extends BaseTest {

    @Test
    public void verifyMultipleConditionsAfterLogin(){
        SoftAssert softAssert = new SoftAssert();

        basedriver.get("https://www.saucedemo.com");
        basedriver.findElement(By.id("user-name")).sendKeys("standard_user");
        basedriver.findElement(By.id("password")).sendKeys("secret_sauce");
        basedriver.findElement(By.id("login-button")).click();

        WebDriverWait wait = new WebDriverWait(basedriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("inventory"));

        // ✅ Validation 1: Title Check
        String actualTitle = basedriver.getTitle();
        softAssert.assertEquals(actualTitle, "Swag Labs", " Title mismatch!");

        // ✅ Validation 2: URL Check
        String currentUrl = basedriver.getCurrentUrl();
        softAssert.assertTrue(currentUrl.contains("inventory"), " URL does not contain 'inventory'");

        // ✅ Validation 3: Shopping cart icon visible
        boolean isCartVisible = basedriver.findElement(By.className("shopping_cart_link")).isDisplayed();
        softAssert.assertTrue(isCartVisible, " Cart icon not visible after login");

        // ✅ Validation 4: Page header text
        String headerText = basedriver.findElement(By.className("title")).getText();
        softAssert.assertEquals(headerText, "Products", " Header text mismatch!");

        // ✅ Important: Collect results at end
        softAssert.assertAll();

        System.out.println("✅ Test completed — SoftAssert executed all validations.");


    }
}
