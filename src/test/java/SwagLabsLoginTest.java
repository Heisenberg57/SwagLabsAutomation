import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class SwagLabsLoginTest extends BaseTest {
    public static void main(String[] args) throws InterruptedException {
        SwagLabsLoginTest loginTest = new SwagLabsLoginTest();
        loginTest.setUp();

        try {

            loginTest.basedriver.get("https://www.saucedemo.com");
            loginTest.basedriver.findElement(By.id("user-name")).sendKeys("standard_user");
            loginTest.basedriver.findElement(By.id("password")).sendKeys("secret_sauce");

            loginTest.basedriver.findElement(By.id("login-button")).click();

            WebDriverWait wait = new WebDriverWait(loginTest.basedriver, Duration.ofSeconds(10));

            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-menu-btn")));

            button.click();

            System.out.println("The Title after login is " + loginTest.basedriver.getTitle());

            WebDriverWait wait2 = new WebDriverWait(loginTest.basedriver, Duration.ofSeconds(10));

            WebElement loginbutton = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));

            loginbutton.click();

            if(loginTest.basedriver.findElement(By.id("login-button")).isDisplayed()){
                System.out.println("Log Out succesfull");
            }
            else {
                System.out.println("Log out fail");
            }





        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            loginTest.basedriver.quit();
        }



    }
}
