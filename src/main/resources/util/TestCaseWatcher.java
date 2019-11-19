package util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import base.BrowserType;
import base.DriverFactory;

public class TestCaseWatcher extends TestListenerAdapter {

	public ExcelApiTest eat;

	@Override
	public void onTestSuccess(ITestResult tr) {
		// ExtentUtil.getTest().pass("Passed");
		ExtentUtil.getTest().pass(MarkupHelper.createLabel(tr.getName() + " Test Case PASSED", ExtentColor.GREEN));
		DriverFactory.closeDriver();
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		// ExtentUtil.getTest().fail("failed");
		String screenShotPath = capture("screenShotName");
		ExtentUtil.getTest().fail(
				MarkupHelper.createLabel(tr.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
		ExtentUtil.getTest().fail(tr.getThrowable());
		try {
			ExtentUtil.getTest().fail("Snapshot below: ",
					MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		} catch (IOException e) {
			e.printStackTrace();
		}

		// close driver
		DriverFactory.closeDriver();
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		// throw new SkipException("Test Skipped");
		ExtentUtil.getTest().log(Status.SKIP,
				MarkupHelper.createLabel(tr.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
		ExtentUtil.getTest().skip(tr.getThrowable());
		DriverFactory.closeDriver();
	}

	@Override
	public void onStart(ITestContext testContext) {
		ExtentUtil.createReport(System.getProperty("user.dir") + "/test-output/MyOwnReport.html");
		try {
			eat = new ExcelApiTest("./src/test/resources/TestData.xlsx");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext testContext) {
		ExtentUtil.flushReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testCaseName = result.getMethod().getMethodName();
		ExtentUtil.createTest(testCaseName);

		String[] categories = result.getMethod().getGroups();

		for (String category : categories) {
			ExtentUtil.getTest().assignCategory(category);
		}

		if (!DataUtil.isTestExecutable(eat, testCaseName)) {
			throw new SkipException("Skipping Testcase as the RUNMODE is N.");
		}
	}

	/**
	 * This method will create a screenshot and saves in the drive by appending the
	 * date time format and returns the destination location in the form of string.
	 * 
	 * @param screenShotName
	 * @return
	 */
	public String capture(String screenShotName) {

		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd:hhmmss");
		String strDate = dateFormat.format(date);
		System.out.println("Converted String: " + strDate);

		WebDriver driver = DriverFactory.getInstance().getDriver(BrowserType.CHROME);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "/screenshots/" + screenShotName + " " + strDate + ".png";
		File destination = new File(dest);
		try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dest;
	}
}
