package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ElementClickInterceptedException;
import java.util.List;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoard {

    private WebDriver driver;
    private WebDriverWait wait;

    public DashBoard(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void searchProduct(String productName) {
        By searchBoxLocator = By.id("twotabsearchtextbox");
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBoxLocator));
        searchBox.clear();
        searchBox.sendKeys(productName);

        By searchButtonLocator = By.id("nav-search-submit-button");
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(searchButtonLocator));
        searchButton.click();
    }

    public void sortByPriceLowToHigh() {
      

        By sortButtonLocator = By.xpath("//span[@id='a-autoid-2-announce']");
        WebElement sortButton = wait.until(ExpectedConditions.elementToBeClickable(sortButtonLocator));
        sortButton.click();
     
        By priceLowToHighOptionLocator = By.xpath("//*[@id=\"s-result-sort-select_4\"]");
        WebElement priceLowToHighOption = wait.until(ExpectedConditions.elementToBeClickable(priceLowToHighOptionLocator));
        priceLowToHighOption.click();
    }

    public void selectFirstResult() {
        By firstProductLink = By.cssSelector(".s-main-slot .s-result-item[data-component-type='s-search-result'] h2 a");
        WebElement productLink = wait.until(ExpectedConditions.elementToBeClickable(firstProductLink));
        productLink.click();
    }
}
