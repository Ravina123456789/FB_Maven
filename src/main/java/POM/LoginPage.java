package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.Util1;

public class LoginPage extends Util1 {

	
	WebDriver driver;
	
	@FindBy(xpath = "//input[@id='email'] ")
	private WebElement userName;
	
	
	 public LoginPage( WebDriver driver)
		{
		   PageFactory.initElements(driver, this);
			this.driver = driver;
		}
		public void enterUsername()
		{
			userName.sendKeys("abc");
			
		}
	
	
//	@FindBy(xpath = "(//a[@role='button'])[2] ")
//	private WebElement password;
}
