package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage {
    WebDriver driver;

    //Locators
    private By productNames = By.className("inventory_item_name");
    private By addToCartButtons = By.xpath("//button[contains(@id, 'add-to-cart')]");
    private By cartBadge = By.className("shopping_cart_badge");
    private By cartIcon = By.className("shopping_cart_link");

    //Constructor
    public InventoryPage(WebDriver driver){
        this.driver = driver;
    }

    //Add a specific product by name

    public void addProductToCart(String productName) {
        List<WebElement> products = driver.findElements(productNames);

        for (WebElement product : products) {
            if (product.getText().equalsIgnoreCase(productName)) {
                // Find corresponding Add to Cart button
                WebElement addButton = product.findElement(By.xpath("./ancestor::div[@class='inventory_item']//button"));
                addButton.click();
                break;
            }

        }
    }

    // Add all products to cart
    public void addAllProductsToCart() {
        List<WebElement> buttons = driver.findElements(addToCartButtons);
        for (WebElement btn : buttons) {
            btn.click();
        }
    }

//Get all items number in cart
    public int getCartItemCount() {
        List<WebElement> badge = driver.findElements(cartBadge);
        if (badge.size() > 0) {
            return Integer.parseInt(badge.get(0).getText());
        }
        return 0;
    }




    // Go to cart page
    public void goToCart() {
        driver.findElement(cartIcon).click();
    }



}
