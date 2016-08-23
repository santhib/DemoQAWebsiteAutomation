package com.santhi.QADdemo.onlineRegistration;

import java.util.concurrent.TimeUnit;
import com.santhi.QADdemo.onlineRegistration.Locators;
import com.santhi.QADdemo.testData.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Frames
{

	String browserSelected;
	static WebDriver driver;
	Locators objects = new Locators();
	TestData testData = new TestData(); 
	String baseURL;
	
	
	@BeforeTest
	public void setUp()
	{	
		/* Initializing Web driver */
		System.setProperty("webdriver.chrome.driver",
		testData.chromeDriverPath);
        driver = new ChromeDriver();
	    //	driver = new FirefoxDriver();
		
		/* Invoke browser*/		
		driver.get(testData.baseURL);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				
	}
	
	@Test(priority = 1)
	public void clickAndValidateFramesLink()
	{
		driver.findElement(objects.framesLinkText).click();
		String pageText = driver.getPageSource();
		Assert.assertTrue(pageText.contains(testData.frameWindowText));
	}
	
	@Test(priority = 2)
	public void newWindow()
	{
		driver.findElement(objects.openNewWindowText).click();
		driver.findElement(objects.openNewWindowLink).click();		
		driver.switchTo().window(testData.newWindow);
		String pageText = driver.getPageSource();
		Assert.assertTrue(pageText.contains(testData.frameWindowText));
		driver.switchTo().window(testData.baseURL);
		driver.findElement(objects.logoXpath).click();
	}
	
			
@AfterClass
public static void quitDriver()
{
	driver.quit();
}
}
