package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddProductsPage extends BasePage {

	@FindBy(id = "Name")
	private WebElement productNameTextbox;
	
	@FindBy(name = "save")
	private WebElement saveProductButton;
	
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	private WebElement successMessageDiv;	
	
	public AddProductsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void addProduct()
	{
		productNameTextbox.sendKeys("computers");
		saveProductButton.click();
		waitUntilElementVisible(successMessageDiv);
		String actualText = successMessageDiv.getText().replace("×", "").trim();
		System.out.println("Actual Text: "+actualText);
		Assert.assertEquals(actualText, "The new product has been added successfully.");
	}
	
	
}
