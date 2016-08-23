package com.santhi.QADdemo.onlineRegistration;

import org.openqa.selenium.By;

public class Locators
{
	
By registrationLink = By.linkText("Registration");	
By firstNameField = By.id("name_3_firstname");
By lastNameField = By.id("name_3_lastname");

By maritalStatusRadio = By.xpath("//input[@type='radio']");
By hobbyCheckBox = By.xpath("//input[@type='checkbox']");
By countryDropDown = By.tagName("select");
By DOBMonthDropDown = By.id("mm_date_8");
By DOBDayDropDown = By.id("dd_date_8");
By DOBYearDropDown = By.id("yy_date_8");




By phoneNumField = By.id("phone_9");
By userNameField = By.id("username");
By emailField = By.id("email_1");
By profilePicField = By.id("profile_pic_10");
By textArea = By.id("description");
By passwordField = By.id("password_2");
By confirmPasswordField = By.id("confirm_password_password_2");
By submitButton = By.xpath("//input[@value='Submit']");// //button[@type, 'submit' and text()='Submit']

By registrationSucess = By.className("piereg_message");
By registrationFailure = By.className("piereg_login_error");

By DragLink = By.cssSelector("li#menu-item-140>a");
By DropLink = By.cssSelector("li#menu-item-141>a");
By ResizeLink = By.cssSelector("li#menu-item-143>a");
By SelectLink = By.cssSelector("li#menu-item-142>a");
By SortLink = By.cssSelector("li#menu-item-151>a");

By tabOne = By.id("ui-id-1");
By tabTwo = By.id("ui-id-2");
By tabThree = By.id("ui-id-3"); 
By tabFour = By.cssSelector("div#tabs-1>p");
By tabFive = By.cssSelector("div#tabs-2>p");
By tabSix = By.cssSelector("div#tabs-3>p:nth-child(1)");
By tabSeven = By.cssSelector("div#tabs-3>p:nth-child(2)");

By framesLinkText = By.linkText("Frames and windows");
By openNewWindowText = By.linkText("Open Seprate New Window");
By openNewWindowLink = By.linkText("Open New Seprate Window");

By logoXpath = By.xpath("//img[@src='http://demoqa.com/wp-content/uploads/2014/08/Tools-QA-213.png']");




}
