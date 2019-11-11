package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.ExtentUtil;

public class MenuPage extends BasePage {
	
	@FindBy(xpath = "//i[contains(@class,'fa-user')]/../span[text()='Customers']")
	private WebElement customersTreeLink;
	
	@FindBy(xpath = "//i[contains(@class,'fa-user')]/../../../li[4]")
	private WebElement customersTree;
	
	@FindBy(xpath = "//i[contains(@class,'fa-book')]/../span[text()='Catalog']")
	private WebElement catalogTreeLink;
	
	@FindBy(xpath = "//i[contains(@class,'fa-book')]/../../../li[2]")
	private WebElement catalogTree;
	
	@FindBy(xpath = "//i[contains(@class,'fa-tags')]/../span[text()='Promotions']")
	private WebElement promotionsTreeLink;
	
	@FindBy(xpath = "//i[contains(@class,'fa-tags')]/../../../li[5]")
	private WebElement promotionsTree;
	
	@FindBy(xpath = "//a[@href='/Admin/Customer/List']//span")
	private WebElement customersLink;
	
	@FindBy(xpath = "//a[@href='/Admin/Product/List']//span")
	private WebElement productsLink;
	
	@FindBy(xpath = "//a[@href='/Admin/Discount/List']//span")
	private WebElement discountsLink;
	
	public MenuPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public MenuPage expandCustomersTree() 
	{
		if(!customersTree.getAttribute("class").contains("menu-open")) 
		{
			//customersTreeLink.click();
			clickElement(customersTreeLink);
			ExtentUtil.logTest("Clicked on customers tree link.");
		}
		return new MenuPage(driver);
		
	}
	
	public MenuPage expandCatalogTree()
	{
		if(!catalogTree.getAttribute("class").contains("menu-open"))
		{
			//catalogTreeLink.click();
			clickElement(catalogTreeLink);
			ExtentUtil.logTest("Clicked on catalog tree link.");
		}
		return new MenuPage(driver);
	}
	
	public MenuPage expandPromotionsTree()
	{
		if(!promotionsTree.getAttribute("class").contains("menu-open"))
		{
			//promotionsTreeLink.click();
			clickElement(promotionsTreeLink);
			ExtentUtil.logTest("Clicked on promotions tree link");
		}
		return new MenuPage(driver);
	}
	
	public CustomersPage navigateToCustomersPage()
	{
		//customersLink.click();
		clickElement(customersLink);
		ExtentUtil.logTest("Clicked on customers link.");
		return new CustomersPage(driver);
	}
	
	public ProductsPage navigateToProductsPage()
	{
		//productsLink.click();
		clickElement(productsLink);
		ExtentUtil.logTest("Clicked on products link.");
		return new ProductsPage(driver);
	}
	
	public DiscountsPage navigateToDiscountsPage()
	{
		//discountsLink.click();
		clickElement(discountsLink);
		ExtentUtil.logTest("Clicked on discounts link.");
		return new DiscountsPage(driver);
	}
}