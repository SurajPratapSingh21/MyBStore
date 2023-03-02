package com.BStore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class purchaseCompletePage
{
	
	//Web driver object
	WebDriver ldriver; //local driver
	
	//contructor
	public purchaseCompletePage(WebDriver rdriver)
	{
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	//identify the web elements
	
	@CacheLookup
	@FindBy(xpath = "(//button[normalize-space()='OK'])[1]")
	WebElement Ok;
	
	//identify the actions over web elements
	
	public void clickOnOk()
	{
		Ok.click();
	}
	
	
	
	
	
	
	
}
