package testcases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AddDiscountsPage;
import pages.EditDiscountPage;
import util.DataUtil;

public class DiscountsTest extends BaseTest {

	/*MenuPage menu;

	@BeforeMethod
	public void handleMenu() {
		menu = new MenuPage(driver);
	}*/

	@Test(groups="functional")
	public void addDiscountTest() {
		
		if (!DataUtil.isTestExecutable(eat, Thread.currentThread().getStackTrace()[1].getMethodName())) {
			throw new SkipException("Skipping Testcase as the RUNMODE is N.");
		}
		
		AddDiscountsPage addDiscountsPage = menu.expandPromotionsTree().navigateToDiscountsPage()
				.navigateToAddDiscountsPage();
		addDiscountsPage.addDiscount();
	}

	@Test(groups="smoke")
	public void searchDiscountTest() {
		
		if (!DataUtil.isTestExecutable(eat, Thread.currentThread().getStackTrace()[1].getMethodName())) {
			throw new SkipException("Skipping Testcase as the RUNMODE is N.");
		}
		
		menu.expandPromotionsTree().navigateToDiscountsPage().searchDiscount();
	}

	@Test(groups="functional")
	public void editExistingDiscountTest() {
		
		if (!DataUtil.isTestExecutable(eat, Thread.currentThread().getStackTrace()[1].getMethodName())) {
			throw new SkipException("Skipping Testcase as the RUNMODE is N.");
		}
		
		EditDiscountPage editDiscountPage = menu.expandPromotionsTree().navigateToDiscountsPage().searchDiscount()
				.editDiscountButton();
		editDiscountPage.editDiscount();
	}

}