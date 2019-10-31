package base;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	
	protected static ThreadLocal<WebDriver> seleniumDriver = new ThreadLocal<WebDriver>();
	
	public static WebDriver getDriver()
	{
		return seleniumDriver.get();
	}
	
	public static void setWebDriver(WebDriver driver)
	{
		seleniumDriver.set(driver);
	}
	
	public static void closeDriver()
	{
		if(seleniumDriver.get() != null)
		{
			getDriver().quit();
			seleniumDriver.remove();
		}
	}

}