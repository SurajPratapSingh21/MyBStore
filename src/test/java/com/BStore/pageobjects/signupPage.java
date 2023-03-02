package com.BStore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class signupPage 
{
		//create object of webdriver
		WebDriver ldriver; //local driver
		
		//Constructor
		public signupPage(WebDriver rdriver) // remote driver
		{
			ldriver = rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		//Identify the web elements
		
		@FindBy(id = "sign-username")
		 WebElement signup_UsernameInput;
		
		@FindBy(id = "sign-password")
		 WebElement signup_PasswordInput;
		
		@FindBy(xpath = "//button[normalize-space()='Sign up']")
		 WebElement signup_SignUpButton;
		
		@FindBy(xpath = "(//button[@type='button'][normalize-space()='Close'])[2]")
		 WebElement signup_CloseButton;
		
		//Identify the actions on webelements
		
		//Enter username & password
		public void enterSignupUsername(String username) 
		{
			signup_UsernameInput.clear();
			signup_UsernameInput.sendKeys(username);

		}
		
		public void enterSignupPassword(String password)
		{
			signup_PasswordInput.clear();
			signup_PasswordInput.sendKeys(password);
		}
		
		public void clickOnSignupbutton()
		{
			signup_SignUpButton.click();
		}
		
		public void clickOnSignUpCloseButton() 
		{
			signup_CloseButton.click();
		}
		
		
		
		
}
