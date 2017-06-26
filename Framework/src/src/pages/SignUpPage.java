package src.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import src.utils.DriverHelper;

public class SignUpPage extends DriverHelper {

	@FindBy(xpath = "//a[contains(@href,'/users/login')]")
	private WebElement logIn;

	@FindBy(xpath = "//a[contains(@href,'/users/signup')]")
	private WebElement signUpButton;

	@FindBy(id = "name")
	private WebElement userName;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "password-confirm")
	private WebElement confirmPassword;

	@FindBy(xpath = "//button[contains(@class,'ui-btn is-secondary has-busy is-auto is-island')]")
	private WebElement signUpbutton;
	
	

	public SignUpPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method will verify the Sign Up page
	 * 
	 * @return
	 */
	public SignUpPage verifySignUpPage() {
		Assert.assertTrue(logIn.isDisplayed());
		return PageFactory.initElements(driver, SignUpPage.class);
	}

	/**
	 * This method will click on Sign Up Button
	 * 
	 * @return
	 */
	public SignUpPage clickSignUpButton() {
		Assert.assertTrue(signUpButton.isDisplayed());
		signUpButton.click();
		return PageFactory.initElements(driver, SignUpPage.class);
	}

	/**
	 * This method will sign up with a new user
	 * 
	 * @param name
	 * @param emailId
	 * @param pwd
	 * @return
	 */
	public AdsPage signUpWithUser(String name, String emailId, String pwd) {
		Assert.assertTrue(userName.isDisplayed());
		userName.sendKeys(name);
		email.sendKeys(emailId);
		password.sendKeys(pwd);
		confirmPassword.sendKeys(pwd);
		signUpbutton.click();
		return PageFactory.initElements(driver, AdsPage.class);
	}

}
