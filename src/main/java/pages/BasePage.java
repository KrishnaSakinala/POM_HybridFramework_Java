package pages;

import java.util.List;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.github.javafaker.Faker;

import util.MyLogger;

public class BasePage {// extends GenericPage{

	// WebDriverWait wait = new WebDriverWait(this.driver, 60);
	public WebDriver driver;
	public WebDriverWait wait;
	public Faker faker;
	MyLogger logger;
	public static final Logger LOGGER = LogManager.getLogger("nopCommerce");

	public BasePage(WebDriver driver) {
		// super(driver);
		this.driver = driver;
		faker = new Faker(new Locale("en-IND"));
		logger = new MyLogger();
	}

	/**
	 * This method used to wait the execution until the required element is visible.
	 * And the maximum time it will wait is 60 seconds.
	 * @param element
	 */
	public void waitUntilElementVisible(WebElement element) {
		// use try-catch to throw the proper exception. do it for all the methods.
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitUntilElementClickable(WebElement element) {
		// use try-catch to throw the proper exception. do it for all the methods.
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void assertTableColumnValues(List<WebElement> elements, String value) {
		for (WebElement element : elements) {
			Assert.assertEquals(element.getText().trim(), value);
		}
	}

	public void selectValue(WebElement element, String selectType, String value) {
		checkElementAvailable(element);
		highlightElement(element);
		Select select = new Select(element);
		if (selectType.equalsIgnoreCase("index")) {
			select.selectByIndex(Integer.parseInt(value));
		} else if (selectType.equalsIgnoreCase("text")) {
			select.selectByVisibleText(value);
		} else {
			select.selectByValue(value);
		}

	}

	public void highlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", element);
	}

	public void highlightElement1(WebElement element) {
	    for (int i = 0; i < 3; i++) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
	                element, "color: yellow; border: 2px solid red;");
	        js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
	                element, "");
	    }
	}
	
	public void enterText(WebElement element, String value) {
		checkElementAvailable(element);
		highlightElement(element);
		element.sendKeys(value);
	}

	public void clickElement(WebElement element) {
		checkElementAvailable(element);
		highlightElement(element);
		element.click();
	}
	
	public String getElementText(WebElement element)
	{
		checkElementAvailable(element);
		highlightElement(element);
		return element.getText();
	}

	public void verifyTitle(String title)
	{
		Assert.assertEquals(driver.getTitle(), title);
	}
	
	public void verifyUrl(String url)
	{
		Assert.assertEquals(driver.getCurrentUrl(), url);
	}
	
	public void verifyAttribute(WebElement element, String attribute, String expectedAttributeValue)
	{
		checkElementAvailable(element);
		String actualAttributeValue = element.getAttribute(attribute);
		Assert.assertEquals(actualAttributeValue, expectedAttributeValue);
	}
	
	public void checkElementAvailable(WebElement element)
	{
		waitUntilElementVisible(element);
		waitUntilElementClickable(element);
	}
}
