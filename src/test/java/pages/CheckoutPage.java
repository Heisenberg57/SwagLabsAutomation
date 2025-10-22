package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    WebDriver driver;

    //Locators
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By  successMessage = By.className("complete-header");

    //Construtor
    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    // Fill checkout form
    public void fillCheckoutInformation(String firstName, String lastName, String postalCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    // Click Continue
    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    // Click Finish
    public void clickFinish() {
        driver.findElement(finishButton).click();
    }

    // Get success message
    public String getSuccessMessage() {
        WebElement message = driver.findElement(successMessage);
        return message.getText();
    }




}
