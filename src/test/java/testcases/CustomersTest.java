package testcases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AddCustomersPage;
import pages.CustomersPage;
import util.DataUtil;

public class CustomersTest extends BaseTest {

	/*
	 * MenuPage menu;
	 * 
	 * @BeforeMethod public void handleMenu() { menu = new MenuPage(driver); }
	 */

	@Test(groups = "functional")
	public void addCustomerTest() throws InterruptedException {

		String nameofCurrMethod = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println("Current Method name is: " + nameofCurrMethod);

		if (!DataUtil.isTestExecutable(eat, nameofCurrMethod)) {
			throw new SkipException("Skipping Testcase as the RUNMODE is N.");
		}

		// MenuPage menu = new MenuPage(driver);
		AddCustomersPage addCustomersPage = menu.expandCustomersTree().navigateToCustomersPage()
				.navigateToAddCustomerPage();
		addCustomersPage.addCustomer();
	}

	@Test(groups = "smoke")
	public void searchCustomerTest() {

		if (!DataUtil.isTestExecutable(eat, Thread.currentThread().getStackTrace()[1].getMethodName())) {
			throw new SkipException("Skipping Testcase as the RUNMODE is N.");
		}

		// MenuPage menu = new MenuPage(driver);
		CustomersPage customersPage = menu.expandCustomersTree().navigateToCustomersPage();
		customersPage.searchCustomerByEmail();
	}
}