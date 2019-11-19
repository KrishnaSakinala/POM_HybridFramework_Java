package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import util.ExtentUtil;

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

	public void addDiscount() { 
	  discountNameTextbox.sendKeys("selenium");
	  ExtentUtil.logTest("addDiscount: " +"Entered discount name in discount name textbox as selenium."); 
	  //Select  discountDropdown = new Select(discountTypeDropdown);
	  //discountDropdown.selectByIndex(2); 
	  selectValue(discountTypeDropdown,"index", "2"); 
	  ExtentUtil.logTest("addDiscount: "
	  +"Selected value from the discount type dropdown.");
	  usePercentageCheckbox.click();
	  ExtentUtil.logTest("addDiscount: "+"Clicked on user percenteage checkbox.");
	  discountPercentageTextbox.clear();
	  ExtentUtil.logTest("addDiscount: "+"Cleared discount percentage textbox.");
	  discountPercentageTextbox.sendKeys("10");
	  ExtentUtil.logTest("addDiscount: "+"Entered discount percentage as 10.");
	  startDateTextbox.sendKeys("11/4/2019 12:00 AM");
	  ExtentUtil.logTest("addDiscount: "+"Entered start date.");
	  endDateTextbox.sendKeys("11/5/2019 12:00 AM");
	  ExtentUtil.logTest("addDiscount: "+"Entered end date.");
	  discountSaveButton.click();
	  ExtentUtil.logTest("addDiscount: "+"Clicked on discount save button.");
	  waitUntilElementVisible(successMessageDiv); String actualText =
	  successMessageDiv.getText().replace("×", "").trim();
	  System.out.println("Actual Text: "+actualText);
	  Assert.assertEquals(actualText,
	  "The new discount has been added successfully."); }

	public void addDiscount(String discountName, String discountType, String discountPercentage, String startDate,
			String endDate) {
		discountNameTextbox.sendKeys(discountName);
		ExtentUtil.logTest("addDiscount: " + "Entered discount name in discount name textbox as selenium.");
		// Select discountDropdown = new Select(discountTypeDropdown);
		// discountDropdown.selectByIndex(2);
		selectValue(discountTypeDropdown, "index", discountType);
		ExtentUtil.logTest("addDiscount: " + "Selected value from the discount type dropdown.");
		usePercentageCheckbox.click();
		ExtentUtil.logTest("addDiscount: " + "Clicked on user percenteage checkbox.");
		discountPercentageTextbox.clear();
		ExtentUtil.logTest("addDiscount: " + "Cleared discount percentage textbox.");
		discountPercentageTextbox.sendKeys(discountPercentage);
		ExtentUtil.logTest("addDiscount: " + "Entered discount percentage as 10.");
		startDateTextbox.sendKeys(startDate);
		ExtentUtil.logTest("addDiscount: " + "Entered start date.");
		endDateTextbox.sendKeys(endDate);
		ExtentUtil.logTest("addDiscount: " + "Entered end date.");
		discountSaveButton.click();
		ExtentUtil.logTest("addDiscount: " + "Clicked on discount save button.");
		waitUntilElementVisible(successMessageDiv);
		String actualText = successMessageDiv.getText().replace("×", "").trim();
		System.out.println("Actual Text: " + actualText);
		Assert.assertEquals(actualText, "The new discount has been added successfully.");
	}
}