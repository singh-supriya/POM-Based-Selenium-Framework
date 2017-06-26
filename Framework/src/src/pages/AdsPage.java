package src.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import src.utils.DriverHelper;

public class AdsPage extends DriverHelper {

	@FindBy(xpath = "//a[contains(@href,'/post-ad')]")
	private WebElement addsLink;

	@FindBy(xpath = "//a[contains(@href,'/post-ad/category?type=for_sale')]")
	private WebElement sellItemServiceLink;

	public AdsPage(WebDriver webdriver) {
		super(webdriver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Verify Adds Page
	 * 
	 * @return
	 */
	public AdsPage verifyAddsPage() {
		Assert.assertTrue(addsLink.isDisplayed());
		return PageFactory.initElements(driver, AdsPage.class);
	}

	/**
	 * Click Post Add Button
	 * 
	 * @return
	 */
	public AdsPage clickPostAddButton() {
		addsLink.click();
		return PageFactory.initElements(driver, AdsPage.class);
	}

	/**
	 * Click Sell An Item Service Link
	 * 
	 * @return
	 */
	public CategoryPage clickSellAnItemServiveLink() {
		sellItemServiceLink.click();
		return PageFactory.initElements(driver, CategoryPage.class);
	}

}
