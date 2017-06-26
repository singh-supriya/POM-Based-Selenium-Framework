package src.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import src.utils.DriverHelper;

public class MyAdsPage extends DriverHelper {

	@FindBy(xpath = "//h3[@class = 'is-section']/span")
	private WebElement addedAdds;

	public MyAdsPage(WebDriver webdriver) {
		super(webdriver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Verify Added Post
	 * 
	 * @return
	 */
	public MyAdsPage verifyPostedAdd() {
		waitForWebElementPresent(addedAdds,getTimeOut());
		Assert.assertTrue(addedAdds.isDisplayed());
		String val = addedAdds.getText();
		int num = Integer.parseInt(val);
		if (num < 0) {
			Assert.fail();
		}
		return PageFactory.initElements(driver, MyAdsPage.class);
	}

}
