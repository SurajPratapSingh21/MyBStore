package com.BStore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class phonesPage
{

	
	//create object of webdriver
		WebDriver ldriver; //local driver
		
		//Constructor
		public phonesPage(WebDriver rdriver) // remote driver
		{
			ldriver = rdriver;
			PageFactory.initElements(rdriver, this);
		}
	
		
		//identify the web elements
		
		@CacheLookup
		@FindBy(xpath = "(//a[normalize-space()='Iphone 6 32gb'])[1]")
		WebElement iphone6;
		
		
		//	Identify the actions on webelements
		
		public void clickOnIphone6()
		{
			iphone6.click();
		}
		
		public String getIPhoneName()
		{
			String text =iphone6.getText();
			return text;
		}
}
