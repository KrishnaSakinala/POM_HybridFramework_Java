package testcases;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.AddProductsPage;
import pages.ProductsPage;

public class ProductsTest extends BaseTest {

	/*MenuPage menu;

	@BeforeMethod
	public void handleMenu() {
		menu = new MenuPage(driver);
	}*/

	@Test(groups="functional")
	public void addProductTest() {
		AddProductsPage addProductsPage = menu.expandCatalogTree().navigateToProductsPage().navigateToAddProductPage();
		addProductsPage.addProduct();
	}
	
	@Test(groups="smoke")
	public void searchProductTest()
	{
		ProductsPage productsPage = menu.expandCatalogTree().navigateToProductsPage();
		productsPage.searchProduct();
	}

}
