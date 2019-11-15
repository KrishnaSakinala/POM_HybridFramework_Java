package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import util.ExtentUtil;

public class AddCustomersPage extends BasePage {

	@FindBy(id = "Email")
	private WebElement emailTextbox;
	
	@FindBy(name = "save")
	private WebElement saveButton;
	
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	private WebElement successMessageDiv;
	
	/*@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	private AjaxElementLocator successMessageDiv1;*/
	
	public AddCustomersPage(WebDriver driver) {
		super(driver);
		//PageFactory.initElements(driver, this);
		//AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 100), this);
	}
	
	public void addCustomer()
	{
		//emailTextbox.sendKeys("abcd2@gmail.com");
		enterText(emailTextbox, "abcd3@gmail.com");
		ExtentUtil.logTest("addCustomer :"+"Entered email in email textbox as abcd@gmail.com.");
		//logger.info("Entering email into the textbox.");
		//saveButton.click();
		clickElement(saveButton);
		ExtentUtil.logTest("addCustomer: "+"Clicked on Save Button.");
		//logger.info("Clicking on Save button.");
		waitUntilElementVisible(successMessageDiv);
		String actualText = successMessageDiv.getText().replace("×", "").trim();
		System.out.println("Actual Text: "+actualText);
		Assert.assertEquals(actualText, "The new customer has been added successfully.");
	}
	
	
}
