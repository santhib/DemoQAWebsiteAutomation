package com.santhi.QADdemo.onlineRegistration;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.santhi.QADdemo.onlineRegistration.Locators;
import com.santhi.QADdemo.testData.TestData;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tabs
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
	    //	driver = new FirefoxDriver(); //utils.getWebdriver(browserSelected);
		
		/* Invoke browser*/		
		driver.get(testData.baseURL);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				
	}
	
	@Test(priority = 1)
	public void CheckTextOnTabOne()
	{
		driver.findElement(objects.tabOne).click();
		String pageText = driver.getPageSource();
		Assert.assertTrue(pageText.contains(testData.tabOneText));
	}
	
	@Test(priority = 2)
	public void CheckTextOnTabTwo()
	{
		driver.findElement(objects.tabTwo).click();
		String pageText = driver.getPageSource();
		Assert.assertTrue(pageText.contains(testData.tabTwoText));
	}
	
	@Test(priority = 3)
	public void CheckTextOnTabThree()
	{
		driver.findElement(objects.tabThree).click();
		String pageText = driver.getPageSource();
		Assert.assertTrue(pageText.contains(testData.tabThreeText));
	}

	@Test(priority = 4)
	public void CheckTextOnTabFour()
	{
		driver.findElement(objects.tabFour).click();
		String pageText = driver.getPageSource();
		Assert.assertTrue(pageText.contains(testData.tabFourText));
	}

	@Test(priority = 5)
	public void CheckTextOnTabFive()
	{
		driver.findElement(objects.tabFive).click();
		String pageText = driver.getPageSource();
		Assert.assertTrue(pageText.contains(testData.tabFiveText));
	}

			
@AfterClass
public static void quitDriver()
{
	driver.quit();
}
}
