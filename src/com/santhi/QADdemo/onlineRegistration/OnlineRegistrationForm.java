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

public class OnlineRegistrationForm
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
		"C:\\Users\\santhi\\Desktop\\Courses\\QA\\Selenium\\jarss\\chromedriver.exe");
        driver = new ChromeDriver();
	    //	driver = new FirefoxDriver();
        
		driver.get(testData.baseURL);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				
	}
	
	@Test(priority = 1)
	public void openRegistrationForm()
	{
		driver.findElement(objects.registrationLink).click();
		String pagetitle = driver.getTitle();
		Assert.assertTrue(pagetitle.contains(testData.registrationTitle));
	}
	
	@Test(priority = 2)
	public void fillAndSubmitRegistrationForm()
	{
		driver.findElement(objects.firstNameField).sendKeys(testData.firstName);
		driver.findElement(objects.lastNameField).sendKeys(testData.lastName);
		List maritalStatusRadio = driver.findElements(objects.maritalStatusRadio);
		((WebElement) maritalStatusRadio.get(1)).click(); //Married
		
		List hobbyCheckBox = driver.findElements(objects.hobbyCheckBox);
		((WebElement) hobbyCheckBox.get(1)).click(); // Reading
		
		Select countrySelect = new Select(driver.findElement(objects.countryDropDown));
		countrySelect.selectByValue(testData.country);
		
		Select DOBMonthSelect = new Select(driver.findElement(objects.DOBMonthDropDown));
		DOBMonthSelect.selectByValue(testData.DOBMonth);
		
		Select DOBDaySelect = new Select(driver.findElement(objects.DOBDayDropDown));
		DOBDaySelect.selectByValue(testData.DOBDay);
		
		Select DOBYearSelect = new Select(driver.findElement(objects.DOBYearDropDown));
		DOBYearSelect.selectByValue(testData.DOBYear);
		
		driver.findElement(objects.phoneNumField).sendKeys(testData.phoneNumber);
		driver.findElement(objects.userNameField).sendKeys(testData.userName);
		driver.findElement(objects.emailField).sendKeys(testData.email);
		driver.findElement(objects.textArea).sendKeys(testData.aboutUrself);
		driver.findElement(objects.passwordField).sendKeys(testData.password);
		driver.findElement(objects.confirmPasswordField).sendKeys(testData.password);
		
		driver.findElement(objects.submitButton).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if(driver.getPageSource().contains(testData.successMessage))
		{
		System.out.println("Registration is successfull.");
		}
		else
		{
			System.out.println("Registration is unseccussfully because : "+ driver.findElement(objects.registrationFailure).getText());
		}
		
	}
		
	@AfterClass
	public static void quitDriver()
	{
		driver.quit();
	}
}
