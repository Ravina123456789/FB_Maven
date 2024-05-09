package UtilityClasses;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util1 {

	
	static WebDriver driver;
	public static WebElement explicitWait(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement newElement = wait.until(ExpectedConditions.visibilityOf(element));
		return newElement;
	}
	
	public static WebElement explicitWait(WebDriver driver, By xpath)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement newElement = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
		return newElement;
	}
	public static void dropDown(WebDriver driver) 
	{
		WebElement day = driver.findElement(By.xpath("//select[@aria-label='Day']"));
		day.click();
		Select s = new Select(day);
		s.selectByVisibleText("25");
		
		WebElement month = driver.findElement(By.xpath("//select[@aria-label='Month']"));
		month.click();
		Select s1 = new Select(month);
		s1.selectByVisibleText("Dec");
		
		WebElement year = driver.findElement(By.xpath("//select[@aria-label='Year']"));
		year.click();
		Select s2 = new Select(year);
		s2.selectByVisibleText("1998");
		
	}
	public static void radioButton(WebDriver driver)
	{
		WebElement button = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
		button.isSelected();
		button.click();
	}
	
	public static String getScreenShot(WebDriver driver, String testName) throws IOException
	{
		Date date = new Date();
		
		SimpleDateFormat f = new SimpleDateFormat("YYYY-MM-dd-hh-mm-ss");
		
		String currentDate = f.format(date);
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String path = testName+".png";
		
		File dest = new File(path);
		
		FileHandler.copy(source, dest);
		
		return path;
		}
}
