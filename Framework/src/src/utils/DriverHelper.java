package src.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import src.utils.PropertyReader;

public abstract class DriverHelper {

	protected WebDriver driver;
	protected static WebDriverWait ajaxWait;
	private int TIME_OUT;
	private String time;
	protected PropertyReader propertyReader;

	public DriverHelper(WebDriver webdriver) {
		this.driver = webdriver;
		ajaxWait = new WebDriverWait(driver, TIME_OUT);
		propertyReader = new PropertyReader();
	}

	/**
	 * This method will wait for Webelement to appear
	 * 
	 * @param element
	 * @param timeout
	 */
	// Wait for element present for WebElement
	public static void waitForWebElementPresent(WebElement element, int timeout) {
		ajaxWait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is used to execute a Java script
	 * 
	 * @param we
	 */
	public void javaScriptExecute(WebElement we) {
		final JavascriptExecutor js = (JavascriptExecutor) this.driver;
		js.executeScript("arguments[0].click();", we);
	}

	/**
	 * This method will wait for a web element present
	 */
	// Wait for element not present
	public void waitForWebElementPresent() {
		try {
			Thread.sleep(25000);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will return a time we want to wait
	 * 
	 * @return
	 */
	public int getTimeOut() {
		time = propertyReader.readApplicationFile("Time_Out");
		TIME_OUT = Integer.parseInt(time);
		return TIME_OUT;
	}

}
