package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DiscountsPage extends BasePage {

	@FindBy(css = "a[href='/Admin/Discount/Create']")
	private WebElement addNewDiscountButton;
	
	@FindBy(id = "SearchDiscountName")
	private WebElement searchDiscountNameTextbox;
	
	@FindBy(id = "search-discounts")
	private WebElement searchDiscountsButton;
	
	@FindBy(xpath = "//table[@id='discounts-grid']/tbody/tr/td[3]")
	private WebElement searchedDiscountTd;
	
	@FindBy(xpath = "//table[@id='discounts-grid']/tbody/tr/td[7]/a")
	private WebElement searchedDiscountEditButton;
	
	public DiscountsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public AddDiscountsPage navigateToAddDiscountsPage()
	{
		addNewDiscountButton.click();
		return new AddDiscountsPage(driver);
	}
	
	public DiscountsPage searchDiscount()
	{
		searchDiscountNameTextbox.sendKeys("selenium");
		searchDiscountsButton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String discountValue = searchedDiscountTd.getText().trim();
		Assert.assertEquals("10%", discountValue);
		return this;
	}
	
	public EditDiscountPage editDiscountButton()
	{
		searchedDiscountEditButton.click();
		return new EditDiscountPage(driver);
	}
}
