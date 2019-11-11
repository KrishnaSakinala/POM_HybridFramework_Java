package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
	
	@FindBy(id = "Email")
	private WebElement emailTextbox;
	
	@FindBy(id = "Password")
	private WebElement passwordTextbox;
	
	@FindBy(css = "input[value='Log in']")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void applicationLogin()
	{
		//emailTextbox.sendKeys("admin@yourstore.com");
		enterText(emailTextbox, "admin@yourstore.com");
		//ExtentUtil.logTest("Entered email in email textbox as admin@yourstore.com");
		//passwordTextbox.sendKeys("admin");
		enterText(passwordTextbox, "admin");
		//ExtentUtil.logTest("Entered password in password textbox as admin");
		//loginButton.click();
		clickElement(loginButton);
		//ExtentUtil.logTest("Clicked on login button.");
	}
	
	

}
