package testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AddDiscountsPage;
import pages.MenuPage;

public class DiscountsTest extends BaseTest {

	MenuPage menu;

	@BeforeMethod
	public void handleMenu() {
		menu = new MenuPage(driver);
	}

	@Test
	public void addDiscountTest() {
		AddDiscountsPage addDiscountsPage = menu.expandPromotionsTree().navigateToDiscountsPage()
				.navigateToAddDiscountsPage();
		addDiscountsPage.addDiscount();
	}
	
	@Test
	public void editExistingDiscountTest()
	{
		
	}

}
