package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.Util1;

public class CreatNewAccount extends Util1 {

	
	WebDriver driver;

	@FindBy(xpath = "(//a[@role='button'])[2] ")
	private WebElement button;

	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement firstName;

	@FindBy(xpath="(//input[@type='text'])[3]")
	private WebElement lastName;

	@FindBy(xpath="(//input[@type='text'])[4]")
	private WebElement mobileNO;

	@FindBy(xpath="(//input[@type='password'])[2]")
	private WebElement password;

	   public CreatNewAccount( WebDriver driver)
		{
		   PageFactory.initElements(driver, this);
			this.driver = driver;
		}
		public void Button()
		{
			button.click();
			
		}
		public void FirstName()
		{
			firstName.sendKeys("abc");
			//driver.findElement(firstName).sendKeys("abc");
		}
		public void LastName()
		{
			lastName.sendKeys("xyz");
			//driver.findElement(lastName).sendKeys("xyz");
		}
		public void MobileNO()
		{
			mobileNO.sendKeys("9879879876");
			//driver.findElement(mobileNO).sendKeys("9865327435");
		}
		
		public void Password()
		{
			password.sendKeys("A@1234");
			//driver.findElement(password).sendKeys("a@1234");
		}
}
