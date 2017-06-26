package src.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import src.utils.DriverHelper;

public class AdDetailsPage extends DriverHelper {

	@FindBy(id = "fields-condition-value")
	private WebElement conditionValue;

	@FindBy(id = "fields-brand-value")
	private WebElement brandValue;

	@FindBy(id = "fields-model-value")
	private WebElement modelValue;

	@FindBy(id = "fields-title-value")
	private WebElement titleValue;

	@FindBy(id = "fields-description-value")
	private WebElement descriptionValue;

	@FindBy(id = "fields-price-amount")
	private WebElement priceValue;

	@FindBy(id = "fields-price-negotiable")
	private WebElement negotiable;

	@FindBy(id = "name")
	private WebElement nameOfOwner;

	@FindBy(id = "phone0")
	private WebElement phoneNumber;

	@FindBy(id = "email")
	private WebElement emailID;

	@FindBy(xpath = "//button[@name='post']")
	private WebElement postAdd;

	@FindBy(xpath = "//a[contains(@href,'/my/dashboard')]")
	private WebElement myAdds;

	public AdDetailsPage(WebDriver webdriver) {
		super(webdriver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Select Condition
	 * 
	 * @param condition
	 * @return
	 */
	public AdDetailsPage selectConditionFromDropdown(String condition) {
		waitForWebElementPresent(conditionValue,getTimeOut());
		Assert.assertTrue(conditionValue.isDisplayed());
		Select sel = new Select(conditionValue);
		sel.selectByValue(condition);
		return PageFactory.initElements(driver, AdDetailsPage.class);
	}

	/**
	 * Select Brand
	 * 
	 * @param brand
	 * @return
	 */
	public AdDetailsPage selectBrandOption(String brand) {
		Assert.assertTrue(brandValue.isDisplayed());
		Select sel = new Select(brandValue);
		sel.selectByValue(brand);
		return PageFactory.initElements(driver, AdDetailsPage.class);
	}

	/**
	 * Enter Model
	 * 
	 * @param model
	 * @return
	 */
	public AdDetailsPage enterModel(String model) {
		Assert.assertTrue(modelValue.isDisplayed());
		modelValue.sendKeys(model);
		return PageFactory.initElements(driver, AdDetailsPage.class);
	}

	/**
	 * Enter Title
	 * 
	 * @param title
	 * @return
	 */
	public AdDetailsPage enterTitle(String title) {
		Assert.assertTrue(titleValue.isDisplayed());
		titleValue.sendKeys(title);
		return PageFactory.initElements(driver, AdDetailsPage.class);
	}

	/**
	 * Enter Description
	 * 
	 * @param description
	 * @return
	 */
	public AdDetailsPage entertDescription(String description) {
		Assert.assertTrue(descriptionValue.isDisplayed());
		descriptionValue.sendKeys(description);
		return PageFactory.initElements(driver, AdDetailsPage.class);
	}

	/**
	 * Enter Price
	 * 
	 * @param price
	 * @return
	 */
	public AdDetailsPage entertPrice(String price) {
		Assert.assertTrue(priceValue.isDisplayed());
		priceValue.sendKeys(price);
		return PageFactory.initElements(driver, AdDetailsPage.class);
	}

	/**
	 * Fill Details And Click On Post Add Button
	 * 
	 * @param phn
	 * @return
	 */
	public AdDetailsPage fillAboutYouDtails(String phn) {
		phoneNumber.sendKeys(phn);
		postAdd.click();
		return PageFactory.initElements(driver, AdDetailsPage.class);
	}

	/**
	 * Click on MyAdds Button
	 * 
	 * @return
	 */
	public MyAdsPage clickMyAddsButton() {
		Assert.assertTrue(myAdds.isDisplayed());
		myAdds.click();
		return PageFactory.initElements(driver, MyAdsPage.class);
	}

}
