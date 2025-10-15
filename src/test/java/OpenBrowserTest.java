import org.openqa.selenium.WebDriver;
import  org.openqa.selenium.chrome.ChromeDriver;
import  io.github.bonigarcia.wdm.WebDriverManager;

public class OpenBrowserTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver_for_saucedemo =  new ChromeDriver();
        driver_for_saucedemo.get("https://www.saucedemo.com");
        System.out.println("Title: "+driver_for_saucedemo.getTitle());
        driver_for_saucedemo.quit();
    }
}
