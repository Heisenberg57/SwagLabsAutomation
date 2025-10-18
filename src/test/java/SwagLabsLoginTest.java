import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class SwagLabsLoginTest extends BaseTest {
    public static void main(String[] args) throws InterruptedException {
        SwagLabsLoginTest loginTest = new SwagLabsLoginTest();
        loginTest.setUp();

        WebDriver driver = loginTest.getDriver();

        try {
            //open website
            driver.get("https://www.saucedemo.com");

            //enter credentials and login
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            //wait for menu button to be visible - asserting login was succesful
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-menu-btn")));
            button.click();

            //Login succesful now try logout
            System.out.println("✅ Login successful, now attempting logout...");
            System.out.println("The Title after login is " + driver.getTitle());

            //wait for logout button to appear
            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement logoutbutton = wait2.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));

            logoutbutton.click();

            // Wait until redirected to login page again
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));

            if(driver.findElement(By.id("login-button")).isDisplayed()){
                System.out.println("Log Out succesfull");
            }
            else {
                System.out.println("Log out fail");
            }





        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }



    }
}
