package com.BStore.testcases;

//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.BStore.pageobjects.indexPage;
import com.BStore.pageobjects.loginPage;
import com.BStore.pageobjects.welcomePage;
import com.BStore.utilities.BstoreDataProviders;
//import com.BStore.utilities.ReadExcelFile;

public class TC_VerifyLoginDataDriven extends BaseClass
{
	
	@Test(dataProvider = "LoginDataProvider", dataProviderClass = BstoreDataProviders.class)
	public void Verifylogin_DataDriven(String username, String password, String expectedusername) throws Exception
	{
		
		
		//1. Open URL(Using Baseclass Setup method)
		logger.info("\n\n************************TestCase Verify Login START***************************\n");
		
		SoftAssert sf = new SoftAssert();
		
		indexPage Ipg = new indexPage(getDriver());
		
		Thread.sleep(1000);
		//2. Click on Login 
		Ipg.clickOnIndexLogin();
		logger.info("Index Login anchor button clicked");

		loginPage lpg = new loginPage(getDriver());
		
		//3. Enter registered username
		lpg.enterLoginUsername(username);
		logger.info("Username entered");
		
//		alertIsPresent(5);
//		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		
		//4. Enter valid password
		lpg.enterLoginPassword(password);
		logger.info("Password entered");
		
		//5. Click on Login button
		lpg.clickOnLoginButton();
		logger.info("Login button clicked");

		Thread.sleep(2000);
		
		welcomePage wpg = new welcomePage(getDriver());
		
		
		Thread.sleep(5000);
		
		//6. Verify username in welcome page
		if(wpg.getUsername().equalsIgnoreCase(expectedusername))
		{	
			logger.info("Verified username matched: Test Passed");
			sf.assertTrue(true,"Assert Passed: Welcome admin");
		}
		else
		{
			logger.info("Verified username not matched: Test Failed");
			captureScreenShot(getDriver(), "verifyLogin");
			sf.assertTrue(false,"Assert Failed: Welcome admin");
		}
		sf.assertAll();
		
		//7. Click on logout
		wpg.clickOnLogout();
		
		Thread.sleep(3000);
		
		logger.info("\n\n************************TestCase Verify Login END***************************\n");
	}

//	@DataProvider(name = "LoginDataProvider")
//	public String[][] LoginDataProvider()
//	{
//		String filename = System.getProperty("user.dir") + "\\TestData\\BStoreTestData.xlsx";
//		
//		int totalRowCount = ReadExcelFile.getRowCount(filename, "Login");
//		int totalColumnCount = ReadExcelFile.getColCount(filename, "Login");
//		
//		String data[][] = new String[totalRowCount-1][totalColumnCount];
//		
//		for(int i=1;i<totalRowCount;i++)
//		{
//			for(int j=0;j<totalColumnCount;j++)
//			{
//				data[i-1][j] = ReadExcelFile.getCellValue(filename, "Login", i, j);
//			}
//		}
//		return data;
//	}
	

}
