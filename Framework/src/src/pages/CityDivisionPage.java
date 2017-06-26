package src.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import src.utils.DriverHelper;

public class CityDivisionPage extends DriverHelper {

	@FindBy(xpath = "(//a[contains(@href,'/post-ad/location?type=for_sale&category=')])[2]")
	private WebElement dhakaLink;

	@FindBy(xpath = "//select[@class = 'ui-select']")
	private WebElement selectArea;

	@FindBy(xpath = "//option[contains(@value = '/post-ad/details?type=for_sale&category=851&location=')]")
	private WebElement subCity;

	@FindBy(xpath = "//a[contains(@href,'/post-ad/details?type=for_sale&category=851&location=1215')]")
	private WebElement state;

	@FindBy(id = "locations-1211")
	private WebElement selectDropdown;

	public CityDivisionPage(WebDriver webdriver) {
		super(webdriver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Select City
	 * 
	 * @return
	 */
	public CityDivisionPage clickDhakaLink() {
		waitForWebElementPresent(dhakaLink,getTimeOut());
		Assert.assertTrue(dhakaLink.isDisplayed());
		dhakaLink.click();
		return PageFactory.initElements(driver, CityDivisionPage.class);
	}

	/**
	 * Select Sub Category
	 * 
	 * @param option
	 * @return
	 */
	public AdDetailsPage selectOptionFromDropdown(String option) {
		waitForWebElementPresent();
		javaScriptExecute(state);
		return PageFactory.initElements(driver, AdDetailsPage.class);
	}

}
