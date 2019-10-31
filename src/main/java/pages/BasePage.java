package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {//extends GenericPage{
	
	//WebDriverWait wait = new WebDriverWait(this.driver, 60);
	public WebDriver driver;
	
	public BasePage(WebDriver driver) {
		//super(driver);
		this.driver = driver;
	}

}
