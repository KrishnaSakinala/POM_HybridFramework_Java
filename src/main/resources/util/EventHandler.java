package util;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import com.aventstack.extentreports.Status;

//public class EventHandler implements WebDriverEventListener{
public class EventHandler extends AbstractWebDriverEventListener{
	
	@Override
	public void afterAlertAccept(WebDriver driver) {
		
		
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		
		
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		
		
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		
		ExtentUtil.getTest().log(Status.INFO, "Clicked on "+ element.toString());
		
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		
		
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		
		
	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		
		ExtentUtil.getTest().log(Status.INFO, "After getting the text: "+element.getText());
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		
		
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		
		
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		
		ExtentUtil.getTest().log(Status.INFO, "After Navigating to :" + url);
		ExtentUtil.getTest().log(Status.INFO, "Atter Navigating to :" + driver.getCurrentUrl());
		
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		
		
	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		
		
	}

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		
		
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		
		
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		
		ExtentUtil.getTest().log(Status.INFO, "About to Click on "+element.toString());
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		
		
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		
		
	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		
		ExtentUtil.getTest().log(Status.INFO, "Before getting the text: "+element.getText());
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		
		
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		
		
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		
		ExtentUtil.getTest().log(Status.INFO, "Before Navigating to :"+url);
		ExtentUtil.getTest().log(Status.INFO, "Before Navigating to :"+driver.getCurrentUrl());
		
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		
		
	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		
		
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		
		
	}

}
