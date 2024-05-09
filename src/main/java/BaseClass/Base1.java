package BaseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Base1 {

	static ExtentHtmlReporter htmlReporter;
	
    static ExtentReports report;
		
  	 static ExtentTest test;
		
 	 static WebDriver driver;
 	 
	public static WebDriver getChromeDriver(String a) throws InterruptedException
 	{
 		
 		if(a.equals("chrome"))
 		{
 			System.setProperty("webdriver.chrome.driver",  "D:\\New Selenium\\chromedriver-win64\\chromedriver.exe");
 	 	WebDriver driver = new ChromeDriver();
 	 	 driver.get("https://www.facebook.com/");
 	 	driver.manage().window().maximize();
 	 	Thread.sleep(3000);
 	 	
 	 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 	 	return driver;
 			
 		}
 		else
 		{
 			 //System.setProperty("webdriver.chrome.driver",  "D:\\New Selenium\\chromedriver-win64\\chromedriver.exe");
 		 	WebDriver driver = new FirefoxDriver();
 		 	 driver.get("https://www.facebook.com/");
 		 	driver.manage().window().maximize();
 		 	Thread.sleep(3000);
 		 	
 		 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 		 	return driver;
 		}
 		
 		
	
}
	
	public static ExtentTest getTestForReporter(String useCase)
	{
		
		return test = report.createTest(useCase);
	}

	public static ExtentHtmlReporter getHtmlReporter()
	{
		if(htmlReporter == null)
		{
			htmlReporter = new ExtentHtmlReporter("ExtentReporter.html");
			
		}
		
		return htmlReporter;
	}

	public static ExtentReports getExtentReport()
	{
		if(report == null)
		{
			report = new ExtentReports();
			report.attachReporter(htmlReporter);
		}
		
		return report;
	}

}
