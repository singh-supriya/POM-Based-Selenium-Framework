package src.utils;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import src.utils.PropertyReader;
import src.pages.HomePage;

public abstract class DriverTestCase {

	protected WebDriver driver;

	// Initialize Object
	public PropertyReader propertyReader = new PropertyReader();

	// Define Variable
	protected String url = propertyReader.readApplicationFile("Url");

	/**
	 * Before Class is setting up the driver for execution
	 */
	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();
	}

	/**
	 * This method is used to quit the driver
	 */
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	/**
	 * This method is used to Open the application
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public HomePage loginSetUp() throws InterruptedException {
		driver.navigate().to(url);
		return PageFactory.initElements(driver, HomePage.class);
	}

	/**
	 * This method will generate some random Integer
	 * 
	 * @param aStart
	 * @param aEnd
	 * @return
	 */
	// Get random integer
	public int getRandomInteger(final long aStart, final long aEnd) {
		final Random aRandom = new Random();
		if (aStart > aEnd) {
			throw new IllegalArgumentException("Start cannot exceed End.");
		}
		// get the range, casting to long to avoid overflow problems
		final long range = aEnd - aStart + 1;
		// compute a fraction of the range, 0 <= frac < range
		final long fraction = (long) (range * aRandom.nextDouble());
		final int randomNumber = (int) (fraction + aStart);
		return randomNumber;
	}

}
