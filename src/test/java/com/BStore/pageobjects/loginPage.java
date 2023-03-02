package com.BStore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BStore.testcases.BaseClass;


public class loginPage extends BaseClass
{
	//create object of webdriver
	WebDriver ldriver; //local driver

	//Constructor
	public loginPage(WebDriver rdriver) // remote driver
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	//Identify the web elements

	@FindBy(xpath = "//*[@id=\"loginusername\"]") 
	WebElement login_UsernameInput;

	@FindBy(xpath = "//*[@id=\"loginpassword\"]") 
	WebElement login_PasswordInput;

	@FindBy(xpath = "//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")
	WebElement login_LoginButton;

	@FindBy(xpath = "(//button[@type='button'][normalize-space()='Close'])[3]")
	WebElement login_CloseButton;

	//Identify the actions on webelements

	public void enterLoginUsername(String username)
	{
		login_UsernameInput.clear();
		moveToElementAndClick(login_UsernameInput);
		login_UsernameInput.sendKeys(username);
	}

	public void enterLoginPassword(String password) 
	{
		login_PasswordInput.clear();
		moveToElementAndClick(login_PasswordInput);
		login_PasswordInput.sendKeys(password);
	}	

	public void clickOnLoginButton()
	{
		login_LoginButton.click();
	}

	public void clickOnCloseButton()
	{
		login_CloseButton.click()	;
	}



}
