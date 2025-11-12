package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ProductPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void increaseQuantity(int quantity) {
        By quantityDropdownLocator = By.id("quantity");
        WebElement quantityDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(quantityDropdownLocator));
        Select select = new Select(quantityDropdown);
        select.selectByValue(String.valueOf(quantity));
    }

    public void addToCart() {
        By addToCartButtonLocator = By.id("add-to-cart-button");
        // Wait for overlays or dropdowns to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".a-popover-modal, .a-dropdown-active, .a-spinner-wrapper")));
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonLocator));
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
        try {
            addToCartButton.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            // Fallback: click with JS if intercepted
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);
        }
    }
}
