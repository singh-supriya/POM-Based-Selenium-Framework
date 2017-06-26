package src.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import src.utils.DriverHelper;

public class CategoryPage extends DriverHelper {

	@FindBy(xpath = "//a[contains(@href,'/post-ad/category?type=for_sale&category=')]//span[contains(@class,electronics)]")
	private WebElement electronics;

	@FindBy(xpath = "//a[contains(@href,'/post-ad/category?type=for_sale&category=851')]")
	private WebElement tvs;

	public CategoryPage(WebDriver webdriver) {
		super(webdriver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Click Electronics Link
	 * 
	 * @return
	 */
	public CategoryPage clickElectronicsLink() {
		waitForWebElementPresent(electronics,getTimeOut());
		Assert.assertTrue(electronics.isDisplayed());
		electronics.click();
		return PageFactory.initElements(driver, CategoryPage.class);
	}

	/**
	 * This method will click on TV link
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public CityDivisionPage clickTVsLink() throws InterruptedException {
		waitForWebElementPresent();
		javaScriptExecute(tvs);
		return PageFactory.initElements(driver, CityDivisionPage.class);
	}

}
