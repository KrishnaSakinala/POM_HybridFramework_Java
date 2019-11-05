package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends BasePage {

	@FindBy(css = "a[href='/Admin/Product/Create']")
	private WebElement addNewProductButton;	
	
	@FindBy(id = "SearchProductName")
	private WebElement productNameTextbox;
	
	@FindBy(id = "search-products")
	private WebElement productSearchButton;
	
	@FindBy(css = "#products-grid >tbody >tr >td:nth-child(3)")
	private List<WebElement> productNamesLable;
	
	public ProductsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);	
	}
	
	public AddProductsPage navigateToAddProductPage() 
	{
		addNewProductButton.click();
		return new AddProductsPage(driver);
	}
	
	public void searchProduct()
	{
		productNameTextbox.sendKeys("computers");
		productSearchButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		assertTableColumnValues(productNamesLable,"computers");
	}
}
