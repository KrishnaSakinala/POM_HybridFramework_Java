package base;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import pages.GenericPage;
import pages.LoginPage;
import pages.MenuPage;
import util.ExcelApiTest;

public class BaseTest {

	//public WebDriver driver;
	public GenericPage gPage;
	
	public ExcelApiTest eat;
	public MenuPage menu;
	
	public BaseTest() {
		try {
			eat = new ExcelApiTest("./src/test/resources/TestData.xlsx");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*@BeforeSuite
	public void setUp()
	{
		
	}*/
	//EventFiringWebDriver
	//WebDriver getDriver(BrowserType type) {
	EventFiringWebDriver getDriver(BrowserType type) {
		//WebDriver driver = DriverFactory.getInstance().getDriver(type);
		EventFiringWebDriver driver = DriverFactory.getInstance().getDriver(type);
		driver.manage().window().maximize();
		driver.get("https://admin-demo.nopcommerce.com/login");
		//ExtentUtil.logTest("Navigated to the application.");
		return driver;
	}

	/**
	 * This method will be useful to initialize browser and log into the
	 * application.
	 * 
	 * @param method
	 */
	@BeforeMethod
	public void beforeMethod() {
		//WebDriver driver = getDriver(BrowserType.CHROME);
		EventFiringWebDriver driver = getDriver(BrowserType.CHROME);
		new LoginPage(driver).applicationLogin();
		menu = new MenuPage(driver);
	}

	/**
	 * This method is used to close the driver session if the driver is null.
	 * 
	 * @param method
	 */
	@AfterMethod
	public void getResult(ITestResult result) {
		//String methodName = method.getName();
		
		/*if (result.getStatus() == ITestResult.FAILURE) {
			ExtentUtil.getTest().log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:",
					ExtentColor.RED));
			ExtentUtil.getTest().fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			ExtentUtil.getTest().log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		} else {
			ExtentUtil.getTest().log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
			ExtentUtil.getTest().skip(result.getThrowable());
		}*/
		
		//DriverFactory.closeDriver();
		
		/*if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:",
					ExtentColor.RED));
			test.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		} else {
			test.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}*/
	}
	
	@AfterSuite
	public void tearDown()
	{
		//extent.flush();
		//ExtentUtil.flushReport();
	}
}
