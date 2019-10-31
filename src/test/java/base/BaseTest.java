package base;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import pages.GenericPage;
import pages.LoginPage;

public class BaseTest {
	
	public WebDriver driver;
	public GenericPage gPage;
	
	/*@BeforeSuite
	public void init() {
		
		if(driver == null) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://admin-demo.nopcommerce.com/login");
			LoginPage loginPage = new LoginPage(driver);
			loginPage.applicationLogin();
		}
		
	}*/
	
	@BeforeMethod
	public void beforeMethod(Method method)
	{
		String methodName = method.getName();
		
		driver = DriverManager.getDriver();
		
		if(driver == null)
		{
			DriverManager.setWebDriver(DriverFactory.getDriver("chrome"));
			driver = DriverManager.getDriver();
			driver.manage().window().maximize();
			//gPage = new GenericPage(driver);
			driver.get("https://admin-demo.nopcommerce.com/login");
			//gPage.getPageObject(LoginPage.class).applicationLogin();
			new LoginPage(driver).applicationLogin();
		}
	}

}
