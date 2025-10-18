import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddToCart extends BaseTest {
    public static void main(String[] args) throws InterruptedException {
       AddToCart atc = new AddToCart();
       atc.setUp();

       try{
           atc.basedriver.get("https://www.saucedemo.com");
           atc.basedriver.findElement(By.id("user-name")).sendKeys("standard_user");
           atc.basedriver.findElement(By.id("password")).sendKeys("secret_sauce");

           atc.basedriver.findElement(By.id("login-button")).click();

           Thread.sleep(3000);

//        atc.basedriver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
//        atc.basedriver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

           atc.basedriver.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']")).click();
           atc.basedriver.findElement(By.xpath("//button[contains(@id,'bike-light')]")).click();

           String cartCount = atc.basedriver.findElement(By.className("shopping_cart_badge")).getText();
           //System.out.println("Cart Count : "+cartCount);

           if(cartCount.equals("2")){
               System.out.println("Test Passed ");
           }
           else{
               System.out.println("Test Failed ");
           }

           List<WebElement> products = atc.basedriver.findElements(By.className("inventory_item_name"));

           for(WebElement p : products ){
               System.out.println(p.getText());
           }

       }
       catch (Exception e){
           e.printStackTrace();
       }
       finally {
           atc.basedriver.quit();
       }






    }
}
