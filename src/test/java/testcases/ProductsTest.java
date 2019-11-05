package testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AddProductsPage;
import pages.MenuPage;
import pages.ProductsPage;

public class ProductsTest extends BaseTest {

	MenuPage menu;

	@BeforeMethod
	public void handleMenu() {
		menu = new MenuPage(driver);
	}

	@Test
	public void addProductTest() {
		AddProductsPage addProductsPage = menu.expandCatalogTree().navigateToProductsPage().navigateToAddProductPage();
		addProductsPage.addProduct();
	}
	
	@Test
	public void searchProductTest()
	{
		ProductsPage productsPage = menu.expandCatalogTree().navigateToProductsPage();
		productsPage.searchProduct();
	}

}
