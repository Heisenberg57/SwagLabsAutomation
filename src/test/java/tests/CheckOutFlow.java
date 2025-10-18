package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutFlow extends BaseTest {

    public static void main(String[] args) {
        CheckOutFlow check = new CheckOutFlow();
        check.setUp();

        WebDriver driver = check.getDriver();

        try{
            driver.get("https://www.saucedemo.com");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");

            driver.findElement(By.id("login-button")).click();

            driver.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']")).click();
            driver.findElement(By.xpath("//button[contains(@id,'bike-light')]")).click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge")));

            driver.findElement(By.className("shopping_cart_link")).click();

            // wait until checkout button is clickable
            WebElement checkoutbtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout")));
            checkoutbtn.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"header_container\"]/div[2]/span")));

            driver.findElement(By.id("first-name")).sendKeys("Test");
            driver.findElement(By.id("last-name")).sendKeys("TestLast");
            driver.findElement(By.id("postal-code")).sendKeys("401305");
            driver.findElement(By.id("continue")).click();

            WebElement finishbtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("finish")));
            finishbtn.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("complete-header")));

            if(driver.findElement(By.id("back-to-products")).isDisplayed()){
                System.out.println("Test Passed, Congratulations");
            }

            else {
                System.out.println("Test Failed");
            }





        }
        catch (Exception e){
            e.printStackTrace();
        } finally {
            check.tearDown();
        }
    }
}
