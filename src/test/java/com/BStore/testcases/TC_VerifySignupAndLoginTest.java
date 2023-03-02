package com.BStore.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.BStore.pageobjects.indexPage;
import com.BStore.pageobjects.loginPage;
import com.BStore.pageobjects.signupPage;
import com.BStore.pageobjects.welcomePage;


public class TC_VerifySignupAndLoginTest extends BaseClass
{

	@Test(enabled = false)
	public void verifySignup() throws Exception
	{
		//1. Open URL(Using Baseclass Setup method)
		logger.info("\n\n************************TestCase verifySignup START***************************\n");

		indexPage Ipg = new indexPage(getDriver());

		//2. Click on Signup button on index page
		Ipg.clickOnIndexSignup();
		logger.info("Index Signup anchor button clicked");

		signupPage Spg = new signupPage(getDriver());

		//3. Enter the new username
		Spg.enterSignupUsername("admin9654905523");
		logger.info("Username Entered");

		//4. Enter the valid password
		Spg.enterSignupPassword("password");
		logger.info("Password Entered");

		//5. Click on Signup 
		Spg.clickOnSignupbutton();
		logger.info("SignUp button clicked");

		//6. Click ok on alert
		alertIsPresent(5);
		getDriver().switchTo().alert().accept();

		logger.info("\n\n************************TestCase verifySignup END***************************\n");
	}

	@Test
	public void Verifylogin() throws Exception
	{
		//1. Open URL(Using Baseclass Setup method)
		logger.info("\n\n************************TestCase Verifylogin START***************************\n");

		SoftAssert sf = new SoftAssert();

		indexPage Ipg = new indexPage(getDriver());

		//2. Click on Login 
		Ipg.clickOnIndexLogin();
		logger.info("Index Login anchor button clicked");

		loginPage lpg = new loginPage(getDriver());

		Thread.sleep(1000);
		
		String admin = "admin";
		
		//3. Enter registered username
		lpg.enterLoginUsername(admin);
		logger.info("Username entered");

		Thread.sleep(1000);

		//4. Enter valid password
		lpg.enterLoginPassword(admin);
		logger.info("Password entered");

		Thread.sleep(1000);
		//5. Click on Login button
		lpg.clickOnLoginButton();
		logger.info("Login button clicked");

		welcomePage wpg = new welcomePage(getDriver());

		Thread.sleep(5000);
		//6. Verify username in welcome page
		if(wpg.getUsername().equalsIgnoreCase("Welcome admin"))
		{	
			logger.info("Verified username matched");
			sf.assertTrue(true, "Assert Passed: Welcome admin");
		}
		else
		{
			logger.info("Verified username not matched: Test Failed");
			captureScreenShot(getDriver(), "verifyLogin");
			sf.assertTrue(false, "Assert Failed: Welcome admin");
		}
		sf.assertAll();

		logger.info("\n\n************************TestCase Verifylogin END***************************\n");
	}













}
