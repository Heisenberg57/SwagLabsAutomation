package base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import  io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test; // For the @Test annotation, marking methods as test methods.
import org.testng.Assert; // For various assertion methods like assertEquals, assertTrue, etc.

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected WebDriver basedriver;

    public void setUp(){
        ChromeOptions options = new ChromeOptions();

        // Disable all password / credential prompts
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("profile.default_content_setting_values.popups", 0);
        options.setExperimentalOption("prefs", prefs);

        // Hardcore disable everything Chrome might spawn
        options.addArguments("--incognito");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-features=AutofillServerCommunication,PasswordManagerOnboarding,PasswordImport,PasswordChange,AutofillEnableAccountWalletStorage");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--start-maximized");

        basedriver = new ChromeDriver(options);
        basedriver.manage().window().maximize();

    }

    public WebDriver getDriver(){
        return  basedriver;

    }

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

        if(isLogin){
            System.out.println("Login Succesfull");
        }
        else {
            System.out.println("login failed");
        }


    }

    public void tearDown(){
        basedriver.quit();
    }
}
