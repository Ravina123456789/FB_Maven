package TestClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BaseClass.Base1;
import POM.CreatNewAccount;
import POM.LoginPage;
@Listeners(ListenerClasses.ListenerClass.class)

public class Test1 {

	
	 WebDriver driver;
		CreatNewAccount c;
		LoginPage p;
		
		ExtentHtmlReporter htmlReporter;
		ExtentReports report;
		ExtentTest test;
		
		@Parameters("browser")
		@BeforeClass
		public void beforeClass(String a) throws InterruptedException
		{
			htmlReporter = Base1.getHtmlReporter();
			report = Base1.getExtentReport();
			test = Base1.getTestForReporter("VerifyUserCanCreateNewAccount");
			
	

			driver = Base1.getChromeDriver(a);
		}
	    @BeforeMethod
		  public void beforeMethod()
		  {
	            c = new CreatNewAccount(driver);
	            p = new LoginPage(driver);
		  }
		  
	    @Test
		  public void VerifyUserCanLogin() throws InterruptedException
		  {
			  p.enterUsername();
			  
		  }
		  @Test(priority=1)
		  public void VerifyUserCanCreateNewAccount() throws InterruptedException
		  {
			  c.Button();
			  c.FirstName();
			  c.LastName();
			  c.MobileNO();
			  
		  }
		  
		  @AfterMethod
			public void afterMethod(ITestResult result) throws IOException
			{
				if(result.getStatus() == ITestResult.SUCCESS)
				{
					test.log(Status.PASS, "Test is passed " + result.getName());
				}
				else
				{
					String path = c.getScreenShot(driver, result.getName());
					test.log(Status.FAIL, "Test is failed " + result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
				}
			}
			
			
			
			@AfterClass
			public void afterClass()
			{
				report.flush();
				driver.quit();
			}
	}

