package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {// extends GenericPage{

	// WebDriverWait wait = new WebDriverWait(this.driver, 60);
	public WebDriver driver;
	public WebDriverWait wait;

	public BasePage(WebDriver driver) {
		// super(driver);
		this.driver = driver;
	}

	public void waitUntilElementVisible(WebElement element) {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void assertTableColumnValues(List<WebElement> elements, String value) {
		for (WebElement element : elements) {
			Assert.assertEquals(element.getText().trim(), value);
		}
	}

	public void selectValue(WebElement element, String selectType, String value) {
		highLightElement(element);
		Select select = new Select(element);
		if (selectType.equalsIgnoreCase("index")) {
			select.selectByIndex(Integer.parseInt(value));
		} else if (selectType.equalsIgnoreCase("text")) {
			select.selectByVisibleText(value);
		} else {
			select.selectByValue(value);
		}

	}

	public void highLightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", element);
	}

	public void enterText(WebElement element, String value) {
		highLightElement(element);
		element.sendKeys(value);
	}

	public void clickElement(WebElement element) {
		highLightElement(element);
		element.click();
	}

}
