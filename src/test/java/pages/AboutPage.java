package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitHelper;

import java.util.ArrayList;

public class AboutPage {
    private WebDriver driver;

    //Locators
    private By menuButton = By.id("react-burger-menu-btn");
    private By aboutLink = By.id("about_sidebar_link");

    //Constructor

    public AboutPage(WebDriver driver){
        this.driver=driver;
    }
    public void openMenu(){
        WebElement menu =  driver.findElement(menuButton);
        WaitHelper.waitForClickable(driver,menu,10);
        menu.click();
        System.out.println("SideBar Menu opened");
    }

    public void clickAbout(){
        WebElement about = driver.findElement(aboutLink);
        WaitHelper.waitForClickable(driver,about,10);
        about.click();
        System.out.println("Clicked About Link");
    }

    public String switchToAboutPageAndGetTitle(){
        // Wait for title to load.
        for(int i=0;i<10;i++){
            if(driver.getTitle().toLowerCase().contains("sauce labs")){
                break;
            }
            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(" Navigated to About page");
        return driver.getTitle();
    }

    public void goBackToApp() {
        driver.navigate().back();
        System.out.println(" Returned back to SauceDemo app");
    }


}
