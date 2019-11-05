package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	// get the driver object
	public static WebDriver getDriver(String browser) {

		return createInstance(browser);
	}

	private static WebDriver createInstance(String browserName) {

		WebDriver driver = null;

		switch (browserName) {

		case "chrome":
			if (driver == null) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			break;
		case "firefox":
			if (driver == null) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		}
		return driver;
	}
}