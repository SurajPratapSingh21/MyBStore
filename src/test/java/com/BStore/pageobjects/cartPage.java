package com.BStore.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cartPage
{

	//create object of webdriver
	WebDriver ldriver; //local driver

	//Constructor
	public cartPage(WebDriver rdriver) // remote driver
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}


	//identify the web elements
	
	@CacheLookup
	@FindBy(xpath = "//table/tbody/tr")
	List<WebElement> rowList; //Webtable 
	
	@CacheLookup
	@FindBy(xpath = "//table/tbody/tr[1]/td")
	List<WebElement> columnList;//Webtable
	
	@CacheLookup
	@FindBy(xpath = "//table/tbody/tr/td")
	List<WebElement> productList;//Webtable
	
	@CacheLookup
	@FindBy(css = "tbody tr:nth-child(1) td:nth-child(2)")
	WebElement productTitle;

	@CacheLookup
	@FindBy(css = "tbody tr:nth-child(1) td:nth-child(2)")
	WebElement producttPrice;

	@CacheLookup
	@FindBy(xpath = "//a[normalize-space()='Delete']")
	WebElement productDelete;
	
	@CacheLookup
	@FindBy(className = "panel-title")
	WebElement totalAmount;

	@CacheLookup
	@FindBy(xpath = "//button[normalize-space()='Place Order']")
	WebElement placeOrder;

	//identify the actions on web elements

	//Webtable method 1
	public ArrayList<String> getProductList1()
	{
		ArrayList<String> actual = new ArrayList<>();
		for(int R=1; R<=rowList.size(); R++)
		{
			for(int C=1; C<=columnList.size(); C++)
			{
				String data = ldriver.findElement(By.xpath("//table/tbody/tr["+R+"]/td["+C+"]")).getText();
				actual.add(data);
			}
		}
		return actual;
	}
	
	public ArrayList<String> getProductList2()
	{
		ArrayList<String> actual = new ArrayList<>();
		for(int i=0; i<productList.size();i++)
		{
			actual.add(productList.get(i).getText());
		}
		return actual;
	}
	
	
	public String getProductTitleCart()
	{
		String text = productTitle.getText();
		return text;
	}

	public String getProductpriceCart()
	{
		String text = producttPrice.getText();
		return text;
	}

	public void clickOnDelete()
	{
		productDelete.click();
	}
	
	public String getTotalAmount()
	{
		String text = totalAmount.getText();
		return text;
	}

	public void clickOnPlaceOrder()
	{
		placeOrder.click();
	}







}
