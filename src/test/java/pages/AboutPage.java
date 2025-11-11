package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitHelper;

public class AboutPage {
    private WebDriver driver;

    //Locators
    private By menuButton = By.id("react-burger-menu-btn");
    private By aboutLink = By.id("about_sidebar_link");

    //Constructor
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


}
