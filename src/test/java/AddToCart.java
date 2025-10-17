import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCart {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver_for_atc = new ChromeDriver();
        driver_for_atc.get("https://www.saucedemo.com");
        driver_for_atc.findElement(By.id("user-name")).sendKeys("standard_user");
        driver_for_atc.findElement(By.id("password")).sendKeys("secret_sauce");

        driver_for_atc.findElement(By.id("login-button")).click();

        Thread.sleep(3000);

        driver_for_atc.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver_for_atc.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

        String cartCount = driver_for_atc.findElement(By.className("shopping_cart_badge")).getText();
        System.out.println("Cart Count : "+cartCount);
    }
}
