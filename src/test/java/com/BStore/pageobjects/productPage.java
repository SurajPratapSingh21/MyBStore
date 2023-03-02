package com.BStore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BStore.testcases.BaseClass;

public class productPage extends BaseClass
{
	//create object of webdriver
	WebDriver ldriver; //local driver

	//Constructor
	public productPage(WebDriver rdriver) 
	{
		ldriver = rdriver;  

		PageFactory.initElements(rdriver, this);
	}

	//Identify the web elements

	@CacheLookup
	@FindBy(xpath = "(//a[normalize-space()='Add to cart'])[1]")
	WebElement addToCart;

	//Identify the action on web elements

	public void clickOnAddToCart()
	{
		addToCart.click();
	}







}
