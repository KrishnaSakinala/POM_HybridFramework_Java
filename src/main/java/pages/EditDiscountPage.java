package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import util.ExtentUtil;

public class EditDiscountPage extends BasePage {
	
	@FindBy(id = "DiscountPercentage")
	private WebElement discountPercentageTextbox;
	
	@FindBy(name = "save")
	private WebElement discountSaveButton;
	
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	private WebElement successMessageDiv;
	
	public EditDiscountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void editDiscount()
	{
		discountPercentageTextbox.clear();
		ExtentUtil.logTest("editDiscount: "+"Cleared discount percentage textbox.");
		discountPercentageTextbox.sendKeys("20");
		ExtentUtil.logTest("editDiscount: "+"Entered on discount percentage as 20.");
		discountSaveButton.click();
		ExtentUtil.logTest("editDiscount: "+"Clicked on discount save button.");
		waitUntilElementVisible(successMessageDiv);
		String actualText = successMessageDiv.getText().replace("×", "").trim();
		System.out.println("Actual Text: "+actualText);
		Assert.assertEquals(actualText, "The discount has been updated successfully.");
	}

}
