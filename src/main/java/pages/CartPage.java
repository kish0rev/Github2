package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean verifyProductAdded(String productName) {
        By cartItemLocator = By.xpath("//span[contains(text(), '" + productName + "')]");
        WebElement cartItem = wait.until(ExpectedConditions.visibilityOfElementLocated(cartItemLocator));
        return cartItem.isDisplayed();
    }
}