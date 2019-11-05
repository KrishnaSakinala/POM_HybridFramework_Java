package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddCustomersPage extends BasePage {

	@FindBy(id = "Email")
	private WebElement emailTextbox;
	
	@FindBy(name = "save")
	private WebElement saveButton;
	
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	private WebElement successMessageDiv;
	
	public AddCustomersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void addCustomer()
	{
		emailTextbox.sendKeys("abcd2@gmail.com");
		saveButton.click();
		waitUntilElementVisible(successMessageDiv);
		String actualText = successMessageDiv.getText().replace("×", "").trim();
		System.out.println("Actual Text: "+actualText);
		Assert.assertEquals(actualText, "The new customer has been added successfully.");
	}
	
	
}
