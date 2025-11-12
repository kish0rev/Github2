package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class LoginPage extends BaseTest {

	public LoginPage(WebDriver wd, WebDriverWait wait) {
		this.wd = wd;
		this.wait = wait;
	}

	public void helloSignin(){
		By helloSigninLocator = By.id("nav-link-accountList-nav-line-1") ;
		WebElement helloSignin = wait.until(ExpectedConditions.visibilityOfElementLocated(helloSigninLocator));
		helloSignin.click();

	}


	public void loginToAmazon() {
		String mobileNumber = getUsername();
		By enterMobileNumberLocator = By.xpath("//input[@id='ap_email_login']");
		WebElement enterMobileNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(enterMobileNumberLocator));
		enterMobileNumber.sendKeys(mobileNumber);
	}

	public void clickContinueButton() {

		By continueButtonLocator = By.xpath("//input[@aria-labelledby='continue-announce']");
		WebElement continueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(continueButtonLocator));
		continueButton.click();

	}

	public void enterPassword() {
		String password = getPassword();
		By enterPasswordLocator = By.xpath("//*[@id=\"ap_password\" and @name='password']");
		WebElement enterPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(enterPasswordLocator));
		enterPassword.sendKeys(password);
	}

	public void clickSignInSubmitButton() {
		By SignInSubmitButtonLocator = By.xpath("//input[@id='signInSubmit' and @type='submit']");
		WebElement SignInSubmitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(SignInSubmitButtonLocator));
		SignInSubmitButton.click();

	}

}
