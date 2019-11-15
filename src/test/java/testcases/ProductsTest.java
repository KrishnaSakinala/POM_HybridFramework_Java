package testcases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AddProductsPage;
import pages.ProductsPage;
import util.DataUtil;

public class ProductsTest extends BaseTest {

	/*
	 * MenuPage menu;
	 * 
	 * @BeforeMethod public void handleMenu() { menu = new MenuPage(driver); }
	 */

	@Test(groups = "functional")
	public void addProductTest() {

		if (!DataUtil.isTestExecutable(eat, Thread.currentThread().getStackTrace()[1].getMethodName())) {
			throw new SkipException("Skipping Testcase as the RUNMODE is N.");
		}

		AddProductsPage addProductsPage = menu.expandCatalogTree().navigateToProductsPage().navigateToAddProductPage();
		addProductsPage.addProduct();
	}

	@Test(groups = "smoke")
	public void searchProductTest() {
		
		if (!DataUtil.isTestExecutable(eat, Thread.currentThread().getStackTrace()[1].getMethodName())) {
			throw new SkipException("Skipping Testcase as the RUNMODE is N.");
		}

		ProductsPage productsPage = menu.expandCatalogTree().navigateToProductsPage();
		productsPage.searchProduct();
	}
}