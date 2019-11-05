package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddDiscountsPage extends BasePage {
	
	@FindBy(id = "Name")
	private WebElement discountNameTextbox;
	
	@FindBy(id = "DiscountTypeId")
	private WebElement discountTypeDropdown;
	
	@FindBy(id = "UsePercentage")
	private WebElement usePercentageCheckbox;
	
	@FindBy(id = "DiscountPercentage")
	private WebElement discountPercentageTextbox;
	
	@FindBy(id = "StartDateUtc")
	private WebElement startDateTextbox;
	
	@FindBy(id = "EndDateUtc")
	private WebElement endDateTextbox;
	
	@FindBy(name = "save")
	private WebElement discountSaveButton;
	
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	private WebElement successMessageDiv;
	
	public AddDiscountsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	public void addDiscount()
	{
		discountNameTextbox.sendKeys("Selenium");
		//Select discountDropdown = new Select(discountTypeDropdown);
		//discountDropdown.selectByIndex(2);
		selectValue(discountTypeDropdown, "index", "2");
		usePercentageCheckbox.click();
		discountPercentageTextbox.sendKeys("10");
		startDateTextbox.sendKeys("11/4/2019 12:00 AM");
		endDateTextbox.sendKeys("11/5/2019 12:00 AM");
		discountSaveButton.click();
		waitUntilElementVisible(successMessageDiv);
		String actualText = successMessageDiv.getText().replace("×", "").trim();
		System.out.println("Actual Text: "+actualText);
		Assert.assertEquals(actualText, "The new discount has been added successfully.");
	}
	
	

}
