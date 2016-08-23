package com.santhi.QADdemo.onlineRegistration;
import java.util.concurrent.TimeUnit;
import com.santhi.QADdemo.onlineRegistration.Locators;
import com.santhi.QADdemo.testData.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class DragNDrop
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
		System.setProperty("webdriver.chrome.driver", testData.chromeDriverPath);
		driver = new ChromeDriver();
		// driver = new FirefoxDriver();

		driver.get(testData.baseURL);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	@Test(priority = 1)
	public void clickAndValidateDragDropLink()
	{
		driver.findElement(objects.DragLink).click();
		WebElement From = driver.findElement(objects.DragLink);
		WebElement To = driver.findElement(objects.DropLink);
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(From).moveToElement(To)
				.release(To).build();
		dragAndDrop.perform();
	}
	
	@AfterClass
	public static void quitDriver()
	{
		driver.quit();
	}
}
