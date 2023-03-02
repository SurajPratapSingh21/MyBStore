package com.BStore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BStore.testcases.BaseClass;


public class welcomePage extends BaseClass
{	
	//create object of webdriver
	WebDriver ldriver; //local driver
	
	//Constructor
	public welcomePage(WebDriver rdriver) // remote driver
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Identify the web elements
	
	@CacheLookup
	@FindBy(xpath  = "(//a[@href='index.html'])[2]")
	 WebElement welcome_Home;
	
	@CacheLookup
	@FindBy(xpath = "//a[normalize-space()='Contact']")
	 WebElement welcome_Contact;
	
	@CacheLookup
	@FindBy(xpath = "//a[normalize-space()='About us']")
	 WebElement welcome_Aboutus;
	
	@FindBy(xpath = "//a[normalize-space()='Cart']")
	 WebElement welcome_Cart;
	
	@CacheLookup
	@FindBy(xpath = "//a[normalize-space()='Log out']")
	 WebElement welcome_Logout;
	
	@CacheLookup
	@FindBy(id = "nameofuser")
	WebElement welcome_Username;
	
	@CacheLookup
	@FindBy(xpath = "//a[normalize-space()='CATEGORIES']")
	WebElement welcome_Categories;
	
	@CacheLookup
	@FindBy(xpath = "//a[normalize-space()='Phones']")
	WebElement welcome_Phones;
	
	@CacheLookup
	@FindBy(xpath = "//a[normalize-space()='Laptops']")
	WebElement welcome_Laptop;
	
	@CacheLookup
	@FindBy(xpath = "//a[normalize-space()='Monitors']")
	WebElement welcome_Monitor;
	
	//Identify the actions on webelements
		
	 public void clickOnHome()
	 {
		 welcome_Home.click();
	 }
		
	 public void clickOnContact()
	 {
		 welcome_Contact.click();
	 }	
		
	 public void clickOnAboutus()
	 {
		 welcome_Aboutus.click();
	 }
		
	 public void clickOnCart()
	 {
		 welcome_Cart.click();
	 }	
		
	 public void clickOnLogout()
	 {
		 welcome_Logout.click();
	 }
	 
	 public String getUsername()
	 { 
		String text =  welcome_Username.getText();
		return text;
	}
		
	 public void clickOnCategories()
	 {
		 elementToBeClickable(welcome_Categories, 5);
		 welcome_Categories.click();
	 }
		
	 public void clickOnPhones()
	 {
		 elementToBeClickable(welcome_Phones, 5);
		 welcome_Phones.click();
	 }
	 
	 public void clickOnLaptops()
	 {
		 elementToBeClickable(welcome_Laptop, 5);
		 welcome_Laptop.click();
	 }
	 
	 public void clickOnMonitor()
	 {
		 welcome_Monitor.click();
	 }
}
