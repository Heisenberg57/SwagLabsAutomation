import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwagLabsLoginTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver_for_login = new ChromeDriver();
        driver_for_login.get("https://www.saucedemo.com");
        driver_for_login.findElement(By.id("user-name")).sendKeys("standard_user");
        driver_for_login.findElement(By.id("password")).sendKeys("secret_sauce");

        driver_for_login.findElement(By.id("login-button")).click();

        Thread.sleep(3000);

        System.out.println("The Title after login is "+driver_for_login.getTitle());
        driver_for_login.quit();


    }
}
