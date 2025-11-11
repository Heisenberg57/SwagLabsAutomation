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
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println(" Switched to About page tab");
        return driver.getTitle();
    }

    public void closeAboutTabAndReturn() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.close(); // Close current tab
        driver.switchTo().window(tabs.get(0)); // Return to main tab
        System.out.println(" Closed About tab and returned to app");
    }


}
