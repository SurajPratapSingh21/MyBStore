package com.BStore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BStore.testcases.BaseClass;


public class indexPage extends BaseClass
{
	//create object of webdriver
	WebDriver ldriver; //local driver

	//Constructor
	public indexPage(WebDriver rdriver) // remote driver
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	//Identify the web elements

	@CacheLookup
	@FindBy(xpath = "//a[@data-target='#signInModal']") 
	WebElement index_Signup;

	//		@CacheLookup
	//		@FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li[5]")
	//		WebElement indexLocatedLogin;

	@CacheLookup
	@FindBy(xpath = "//a[text()='Log in']") 
	WebElement index_Login;

	//Identify the actions on webelements

	public void clickOnIndexSignup()
	{
		index_Signup.click();
	}

	public void clickOnIndexLogin() 
	{	
		elementToBeClickable(index_Login, 10);
		moveToElementAndClick(index_Login);
	}













}
