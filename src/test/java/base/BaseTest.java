package base;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.GenericPage;
import pages.LoginPage;
import util.MyLogger;

public class BaseTest {

	public WebDriver driver;
	public GenericPage gPage;
	//public MyProperties prop;
	public MyLogger logger;
		
	public BaseTest() {
		logger = new MyLogger();
	}

	/*
	 * @BeforeSuite public void init() {
	 * 
	 * if(driver == null) {
	 * 
	 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
	 * driver.manage().window().maximize();
	 * driver.get("https://admin-demo.nopcommerce.com/login"); LoginPage loginPage =
	 * new LoginPage(driver); loginPage.applicationLogin(); }
	 * 
	 * }
	 */

	@BeforeMethod
	public void beforeMethod(Method method) {
		
		//prop = ConfigFactory.create(MyProperties.class);
		
		String methodName = method.getName();
		logger.info("Test Case Name is: " + methodName);
		//driver = DriverManager.getDriver();

		DriverManager.setWebDriver(DriverFactory.getDriver("chrome"));
		driver = DriverManager.getDriver();
		driver.manage().window().maximize();
		// gPage = new GenericPage(driver);
		driver.get("https://admin-demo.nopcommerce.com/login");
		//driver.get(prop.url());
		// gPage.getPageObject(LoginPage.class).applicationLogin();
		new LoginPage(driver).applicationLogin();
		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	@AfterMethod
	public void afterMethod(Method method)
	{
		String methodName = method.getName();
		
		DriverManager.closeDriver();
	}

}
