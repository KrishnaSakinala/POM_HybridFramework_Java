package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.EventHandler;

public class DriverFactory {

	// Singleton Design Pattern
	private static final DriverFactory instance = new DriverFactory();
	
	//EventFiringWebDriver eventDriver;
	EventHandler eventHandler;
	
	private DriverFactory() {

	}

	public static DriverFactory getInstance() {
		return instance;
	}

	private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();
	//private static ThreadLocal<EventFiringWebDriver> threadLocal = new ThreadLocal<EventFiringWebDriver>();

	// Factory Design Pattern
	public WebDriver getDriver(BrowserType type) {
	//public EventFiringWebDriver getDriver(BrowserType type) {
		if (threadLocal.get() == null) {
			switch (type) {
			case CHROME:
				WebDriverManager.chromedriver().setup();
				//ChromeDriver driver = new ChromeDriver();
				//eventDriver = new EventFiringWebDriver(driver);
				//eventHandler = new EventHandler();
				//eventDriver.register(eventHandler);
				
				//threadLocal.set(new EventFiringWebDriver(driver).register(eventHandler));
				
				//eventHandler = new EventHandler();
				//threadLocal.get().register(eventHandler);
				//new EventFiringWebDriver(new ChromeDriver()).register(eventHandler);
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
		//return threadLocal.get().register(eventHandler);
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
