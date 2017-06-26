package src.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import src.utils.DriverHelper;

public class HomePage extends DriverHelper {

	@FindBy(xpath = "//div[@class = 'ui-logo']")
	private WebElement logo;

	@FindBy(xpath = "//a[contains(@href,'/users/login-options')]")
	private WebElement signUp;
	
	@FindBy(xpath = "//span[contains(.,'লগ ইন')]")
	private WebElement login;
	

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method is used to verify the home page
	 * 
	 * @return
	 */
	public HomePage verifyHomePage() {
		waitForWebElementPresent(logo,getTimeOut());
		Assert.assertTrue(logo.isDisplayed());
		return PageFactory.initElements(driver, HomePage.class);
	}

	/**
	 * This method is for clicking on SignUp button
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public SignUpPage clickSignUp() throws InterruptedException {
		Assert.assertTrue(login.isDisplayed());
		login.click();
		Assert.assertTrue(signUp.isDisplayed());
		signUp.click();
		return PageFactory.initElements(driver, SignUpPage.class);
	}

}
