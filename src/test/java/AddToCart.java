import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class AddToCart {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
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


        WebDriver driver_for_atc = new ChromeDriver(options);



        driver_for_atc.get("https://www.saucedemo.com");
        driver_for_atc.findElement(By.id("user-name")).sendKeys("standard_user");
        driver_for_atc.findElement(By.id("password")).sendKeys("secret_sauce");

        driver_for_atc.findElement(By.id("login-button")).click();

        Thread.sleep(3000);

//        driver_for_atc.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
//        driver_for_atc.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

        driver_for_atc.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']")).click();
        driver_for_atc.findElement(By.xpath("//button[contains(@id,'bike-light')]")).click();

        String cartCount = driver_for_atc.findElement(By.className("shopping_cart_badge")).getText();
        //System.out.println("Cart Count : "+cartCount);

        if(cartCount.equals("2")){
            System.out.println("Test Passed ");
        }
        else{
            System.out.println("Test Failed ");
        }

        driver_for_atc.quit();
    }
}
