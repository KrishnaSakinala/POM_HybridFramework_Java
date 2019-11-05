package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiscountsPage extends BasePage {

	@FindBy(css = "a[href='/Admin/Discount/Create']")
	private WebElement addNewDiscountButton;
	
	public DiscountsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public AddDiscountsPage navigateToAddDiscountsPage()
	{
		addNewDiscountButton.click();
		return new AddDiscountsPage(driver);
	}
}
