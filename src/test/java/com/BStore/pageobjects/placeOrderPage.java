package com.BStore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BStore.testcases.BaseClass;

public class placeOrderPage extends BaseClass
{
	//create object of webdriver
	WebDriver ldriver;  //local driver
	
	//Constructor
	public placeOrderPage(WebDriver rdriver) 
	{
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	//identify the web elements
	
	@CacheLookup
	@FindBy(id = "name")
	WebElement name;
	
	@CacheLookup
	@FindBy(id = "country")
	WebElement  country;
	
	@CacheLookup
	@FindBy(id = "city")
	WebElement city;
	
	@CacheLookup
	@FindBy(id = "card")
	WebElement creditCard;
	
	@CacheLookup
	@FindBy(id = "month")
	WebElement month;
	
	@CacheLookup
	@FindBy(id = "year")
	WebElement year;
	
	@CacheLookup
	@FindBy(xpath = "//button[@onclick=\"purchaseOrder()\"]")
	WebElement purchase;
	
	@CacheLookup
	@FindBy(xpath = "(//button[@type='button'][normalize-space()='Close'])[3]")
	WebElement close;
	
	//identify the actions over the webelement
	
	public void enterName(String text)
	{
		name.clear();
		name.sendKeys(text);
	}
	
	public void enterCountry(String text)
	{
		moveToElementAndClick(country);
		country.clear();
		country.sendKeys(text);
	}
	
	public void enterCity(String text)
	{
		moveToElementAndClick(city);
		city.clear();
		city.sendKeys(text);
	}
	
	public void enterCreditCard(String text)
	{
		moveToElementAndClick(creditCard);
		creditCard.clear();
		creditCard.sendKeys(text);
	}
	
	public void enterMonth(String text)
	{
		moveToElementAndClick(month);
		month.clear();
		month.sendKeys(text);
	}
	
	public void enterYear(String text)
	{
		moveToElementAndClick(year);
		year.clear();
		year.sendKeys(text);
	}
	
	public void clickOnPurchase()
	{
		purchase.click();
	}
	
	public void clickOnClose()
	{
		close.click();
	}
}
