package src.test;

import org.testng.annotations.Test;
import org.apache.log4j.xml.DOMConfigurator;

import src.utils.Log;
import src.utils.DriverTestCase;
import src.utils.PropertyReader;
import src.pages.AdDetailsPage;
import src.pages.AdsPage;
import src.pages.CategoryPage;
import src.pages.CityDivisionPage;
import src.pages.HomePage;
import src.pages.SignUpPage;

public class ValidatePostAddFlow extends DriverTestCase {

	private HomePage homePage;
	private SignUpPage signUpPage;
	private AdsPage adsPage;
	private CategoryPage categoryPage;
	private CityDivisionPage cityDivisionPage;
	private AdDetailsPage adDetailsPage;
	

	// Initialize Object
	public PropertyReader propertyReader = new PropertyReader();

	// Define Variable
	String user = propertyReader.readTestData("Name");
	String email = propertyReader.readTestData("email");
	String pwd = propertyReader.readTestData("password");
	String postfix = propertyReader.readTestData("emailPostfix");
	String city = propertyReader.readTestData("city");
	String condition = propertyReader.readTestData("condition");
	String brand = propertyReader.readTestData("brand");
	String model = propertyReader.readTestData("model");
	String title = propertyReader.readTestData("title");
	String description = propertyReader.readTestData("description");
	String phoneNumber = propertyReader.readTestData("phoneNumber");
	String price = propertyReader.readTestData("price");

	@Test
	public void testValidatePostAddFlow() throws InterruptedException {

		String emailId = "email" + getRandomInteger(10000, 99999);
		String fullEmailId = emailId + postfix;
		System.out.println("Email id is:" + fullEmailId);
		DOMConfigurator.configure("log4j.xml");

		// Open the Application
		homePage = loginSetUp();
		Log.info("Open the Application");

		// Verify Home Page
		homePage = homePage.verifyHomePage();
		Log.info("Verify Home Page");

		// Click SignUp on the Home Page
		signUpPage = homePage.clickSignUp();
		Log.info("Click SignUp on the Home Page");

		// Verify SignUp Page
		signUpPage = signUpPage.verifySignUpPage();
		Log.info("Verify SignUp Page");

		// Click SignUp Button
		signUpPage = signUpPage.clickSignUpButton();
		Log.info("Click SignUp Page");

		// Sign Up to the application
		adsPage = signUpPage.signUpWithUser(user, fullEmailId, pwd);
		Log.info("Sign Up to the application");

		// Click Post Your Add Button
		adsPage = adsPage.clickPostAddButton();
		Log.info("Click Post Your Add Button");

		// Click on Sell and Item or service link
		categoryPage = adsPage.clickSellAnItemServiveLink();
		Log.info("Click on Sell and Item or service link");

		// Click Electronics Link
		categoryPage = categoryPage.clickElectronicsLink();
		Log.info("Click Electronics Link");

		// Click TVs Link
		cityDivisionPage = categoryPage.clickTVsLink();
		Log.info("Click TVs Link");

		// Select City Or Division Dhaka
		cityDivisionPage = cityDivisionPage.clickDhakaLink();
		Log.info("Select City Or Division Dhaka");

		// Select Local area
		adDetailsPage = cityDivisionPage.selectOptionFromDropdown(city);
		Log.info(" Select Local area");

		// Select Brand
		adDetailsPage = adDetailsPage.selectBrandOption(brand);
		Log.info("Select Brand");

		// Enter Model
		adDetailsPage = adDetailsPage.enterModel(model);
		Log.info("Enter Model");

		// Enter Title
		adDetailsPage = adDetailsPage.enterTitle(title);
		Log.info("Enter Title");

		// Enter Description
		adDetailsPage = adDetailsPage.entertDescription(description);
		Log.info("Enter Description");

		// Enter Price
		adDetailsPage = adDetailsPage.entertPrice(price);
		Log.info("Enter Price");

		
	}

}
