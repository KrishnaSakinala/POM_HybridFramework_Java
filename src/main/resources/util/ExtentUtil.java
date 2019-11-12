package util;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentUtil {

	static ExtentReports extentReports = null;
	static ExtentTest extentTest;
	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();

	public static ExtentReports createReport(String fileName) {
		ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(fileName);

		extentHtmlReporter.config().setDocumentTitle("AutomationTesting.in Demo Report");
		extentHtmlReporter.config().setReportName("My Own Report");
		extentHtmlReporter.config().setTheme(Theme.DARK);

		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);

		try {
			extentReports.setSystemInfo("HostName", InetAddress.getLocalHost().getHostName());
			extentReports.setSystemInfo("IP Address", InetAddress.getLocalHost().getHostAddress());
			extentReports.setSystemInfo("OS", System.getProperty("os.name"));
			extentReports.setSystemInfo("User Name", System.getProperty("user.name"));
			extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return extentReports;
	}

	public static ExtentReports getExtentReports() {
		return extentReports;
	}

	public static void flushReport() {
		if (extentReports != null)
			extentReports.flush();
	}

	public static synchronized ExtentTest createTest(String testName) {
		extentTest = extentReports.createTest(testName);
		extentTestMap.put((int) (Thread.currentThread().getId()), extentTest);
		return extentTest;
	}

	public static synchronized ExtentTest createTest(String testName, String description) {
		extentTest = extentReports.createTest(testName, description);
		extentTestMap.put((int) (Thread.currentThread().getId()), extentTest);
		return extentTest;
	}

	public static synchronized ExtentTest getTest() {
		return extentTestMap.get((int) (Thread.currentThread().getId()));
	}

	public static synchronized void logTest(String logInfo) {
		//extentTest.log(Status.INFO, logInfo);
		getTest().log(Status.INFO, logInfo);
		
	}
}
