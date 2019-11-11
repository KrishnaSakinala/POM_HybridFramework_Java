package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import util.ExtentUtil;

public class CustomersPage extends BasePage {

	@FindBy(xpath = "//a[@href='/Admin/Customer/Create']")
	private WebElement addNewCustomerButton; 
	
	@FindBy(id = "SearchEmail")
	private WebElement searchEmailTextbox;
	
	@FindBy(id = "search-customers")
	private WebElement searchCustomersButton;
	
	@FindBy(id = "customers-grid_info")
	private WebElement searchResultInfo;
	
	public CustomersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public AddCustomersPage navigateToAddCustomerPage()
	{
		clickElement(addNewCustomerButton);
		ExtentUtil.logTest("navigateToAddCustomerPage: "+"Clicked on Add New Customer Button.");
		return new AddCustomersPage(driver);
	}
	
	public void searchCustomerByEmail()
	{
		//searchEmailTextbox.sendKeys("admin@yourstore.com");
		enterText(searchEmailTextbox, "admin@yourstore.com");
		ExtentUtil.logTest("searchCustomerByEmail: "+"Entered search term in search email text box as admin@yourstore.com.");
		//searchCustomersButton.click();
		clickElement(searchCustomersButton);
		ExtentUtil.logTest("searchCustomerByEmail: "+"Clicked on Search Customer Button.");
		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}*/
		String result = getElementText(searchResultInfo);
		Assert.assertTrue(result.contains("1"));
		
	}
}