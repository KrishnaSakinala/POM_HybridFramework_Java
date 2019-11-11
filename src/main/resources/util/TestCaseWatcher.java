package util;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import base.DriverFactory;

public class TestCaseWatcher extends TestListenerAdapter{

	@Override
	public void onTestSuccess(ITestResult tr)
	{
		//ExtentUtil.getTest().pass("Passed");
		ExtentUtil.getTest().pass(MarkupHelper.createLabel(tr.getName() + " Test Case PASSED", ExtentColor.GREEN));
		DriverFactory.closeDriver();
	}
	
	@Override
	public void onTestFailure(ITestResult tr)
	{
		//ExtentUtil.getTest().fail("failed");
		ExtentUtil.getTest().fail(MarkupHelper.createLabel(tr.getName() + " Test case FAILED due to below issues:",
					ExtentColor.RED));
		ExtentUtil.getTest().fail(tr.getThrowable());
		DriverFactory.closeDriver();
	}
	
	@Override
	public void onTestSkipped(ITestResult tr) {
		//throw new SkipException("Test Skipped");
		ExtentUtil.getTest().log(Status.SKIP,
				MarkupHelper.createLabel(tr.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
		ExtentUtil.getTest().skip(tr.getThrowable());
		DriverFactory.closeDriver();
	}
	
	@Override
	public void onStart(ITestContext testContext) {
		ExtentUtil.createReport(System.getProperty("user.dir") + "/test-output/MyOwnReport.html");
	}
	
	@Override
	public void onFinish(ITestContext testContext) {
		ExtentUtil.flushReport();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentUtil.createTest(result.getMethod().getMethodName());
		
		String[] categories = result.getMethod().getGroups();
		
		for (String category : categories) {
			ExtentUtil.getTest().assignCategory(category);
		}
	}
}
