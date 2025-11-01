package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionMasterTest extends BaseTest {

    @Test
    public void practiseAllActions() throws InterruptedException{

        Actions actions = new Actions(basedriver);
        WebDriverWait wait = new WebDriverWait(basedriver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) basedriver;

        //Hover Action
        basedriver.get("https://www.spicejet.com/");
        WebElement addonsMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Add-ons']")));
        actions.moveToElement(addonsMenu).perform();
        System.out.println(" Hovered over Add-ons menu successfully!");
        Thread.sleep(1000);
    }
}
