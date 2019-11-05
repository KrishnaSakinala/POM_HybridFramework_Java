package testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AddCustomersPage;
import pages.CustomersPage;
import pages.MenuPage;

public class CustomersTest extends BaseTest {

	MenuPage menu;
	
	@BeforeMethod
	public void handleMenu()
	{
		menu = new MenuPage(driver);
	}
	
	@Test
	public void addCustomerTest() throws InterruptedException {
		//MenuPage menu = new MenuPage(driver);
		AddCustomersPage addCustomersPage = menu.expandCustomersTree().navigateToCustomersPage()
				.navigateToAddCustomerPage();
		addCustomersPage.addCustomer();
	}

	@Test
	public void searchCustomerTest() {
		//MenuPage menu = new MenuPage(driver);
		CustomersPage customersPage = menu.expandCustomersTree().navigateToCustomersPage();
		customersPage.searchCustomerByEmail();
	}
}