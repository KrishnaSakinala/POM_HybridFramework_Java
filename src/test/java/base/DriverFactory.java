package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	// Singleton Design Pattern
	private static final DriverFactory instance = new DriverFactory();
	
	private DriverFactory() {

	}

	public static DriverFactory getInstance() {
		return instance;
	}

	private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();

	// Factory Design Pattern
	public WebDriver getDriver(BrowserType type) {
		if (threadLocal.get() == null) {
			switch (type) {
			case CHROME:
				WebDriverManager.chromedriver().setup();
				threadLocal.set(new ChromeDriver());
				break;
			case FIREFOX:
				WebDriverManager.firefoxdriver().setup();
				threadLocal.set(new FirefoxDriver());
				break;
			default:
				break;
			}
		}
		return threadLocal.get();
	}
	
	public static void closeDriver()
	{
		if(threadLocal.get() != null)
		{
			threadLocal.get().quit();
			threadLocal.remove();
		}
	}

}
