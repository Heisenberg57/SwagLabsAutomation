package tests;

import base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ActionMasterTest extends BaseTest {

    Actions actions;
    WebDriverWait wait;
    JavascriptExecutor js;

    public void init() {
        actions = new Actions(basedriver);
        wait = new WebDriverWait(basedriver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) basedriver;
    }

    @Test(groups = {"actions"})
    public void testHoverAction() {
        init();
        basedriver.get("https://www.spicejet.com/");
        WebElement addonsMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Add-ons']")));
        actions.moveToElement(addonsMenu).perform();
        Assert.assertTrue(addonsMenu.isDisplayed(), "Hover failed!");
        System.out.println(" Hovered over Add-ons menu successfully!");
    }

    @Test(groups = {"actions"})
    public void testDragAndDrop() {
        init();
        basedriver.get("https://jqueryui.com/droppable/");
        basedriver.switchTo().frame(0);
        WebElement source = basedriver.findElement(By.id("draggable"));
        WebElement target = basedriver.findElement(By.id("droppable"));
        actions.dragAndDrop(source, target).perform();
        String text = target.getText();
        Assert.assertTrue(text.contains("Dropped"), " Drag and drop failed!");
        System.out.println("Drag and Drop completed!");
        basedriver.switchTo().defaultContent();
    }

//    @Test
//    public void practiseAllActions() throws InterruptedException, IOException {
//
//        Actions actions = new Actions(basedriver);
//        WebDriverWait wait = new WebDriverWait(basedriver, Duration.ofSeconds(10));
//        JavascriptExecutor js = (JavascriptExecutor) basedriver;
//
//        //Hover Action
//        basedriver.get("https://www.spicejet.com/");
//        WebElement addonsMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Add-ons']")));
//        actions.moveToElement(addonsMenu).perform();
//        System.out.println(" Hovered over Add-ons menu successfully!");
//        Thread.sleep(1000);
//
//        //Double click
//        basedriver.get("https://testautomationpractice.blogspot.com/");
//        WebElement doubleClickBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Copy Text']")));
//        actions.doubleClick(doubleClickBtn).perform();
//        System.out.println(" Double-click action performed!");
//        Thread.sleep(1000);
//
//        //Drag and Drop
//        basedriver.get("https://jqueryui.com/droppable/");
//        basedriver.switchTo().frame(0);
//        WebElement source = basedriver.findElement(By.id("draggable"));
//        WebElement target = basedriver.findElement(By.id("droppable"));
//        actions.dragAndDrop(source,target).perform();
//        System.out.println("Drag and Drop completed!");
//        basedriver.switchTo().defaultContent();
//        Thread.sleep(1000);
//
//        //Keyboard Actions
//
//        basedriver.get("https://the-internet.herokuapp.com/key_presses");
//        WebElement body = basedriver.findElement(By.tagName("body"));
//        body.sendKeys(Keys.ARROW_RIGHT);
//        String text = basedriver.findElement(By.id("result")).getText();
//        System.out.println(" Key press result: " + text);
//        Thread.sleep(1000);
//
//        //Scrolling using JavaScriptExecutor
//
//        basedriver.get("https://www.selenium.dev/");
//        js.executeScript("window.scrollBy(0, 800)");
//        System.out.println(" Scrolled down 800px!");
//        Thread.sleep(1000);
//        WebElement footer = basedriver.findElement(By.xpath("//footer"));
//        js.executeScript("arguments[0].scrollIntoView(true);", footer);
//        System.out.println(" Scrolled to footer!");
//        Thread.sleep(1000);
//
//        //File Upload
//        basedriver.get("https://the-internet.herokuapp.com/upload");
//        WebElement uploadBtn = basedriver.findElement(By.id("file-upload"));
//
//        // create dummy file if not exists
//        File file = new File("sample.txt");
//        if (!file.exists()) {
//            file.createNewFile();
//        }
//
//        uploadBtn.sendKeys(file.getAbsolutePath());
//        basedriver.findElement(By.id("file-submit")).click();
//        System.out.println("File uploaded successfully!");
//        Thread.sleep(1000);
//
//
//        /*
//         *  Alerts (The Internet)
//         */
//        basedriver.get("https://the-internet.herokuapp.com/javascript_alerts");
//        basedriver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
//        Alert alert = basedriver.switchTo().alert();
//        System.out.println(" Alert text: " + alert.getText());
//        alert.accept();
//        System.out.println(" Alert accepted!");
//        Thread.sleep(1000);
//
//        /*
//         * Slider (LetCode)
//         */
//
//        basedriver.get("https://letcode.in/slider");
//        WebElement slider = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='range']")));
//        actions.clickAndHold(slider).moveByOffset(80, 0).release().perform();
//        System.out.println("Slider moved successfully!");
//        Thread.sleep(1000);









}
