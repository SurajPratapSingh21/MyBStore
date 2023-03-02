package com.BStore.testcases;

//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BStore.pageobjects.indexPage;
import com.BStore.pageobjects.signupPage;
import com.BStore.utilities.BstoreDataProviders;
//import com.BStore.utilities.ReadExcelFile;

public class TC_VerifySignupDataDriven extends BaseClass
{
	
	@Test(dataProvider = "SignupDataProvider", dataProviderClass = BstoreDataProviders.class, enabled = false)
	public void verifySignup_DataDriven(String username, String password) throws Exception
	{
		//1. Open URL(Using Baseclass Setup method)
		logger.info("\n\n************************TestCase verifySignup_DataDriven START***************************\n");

		indexPage Ipg = new indexPage(getDriver());
		
		//2. Click on Signup button on index page
		
		Ipg.clickOnIndexSignup();
		logger.info("Index Signup anchor button clicked");

		signupPage Spg = new signupPage(getDriver());
		
		//3. Enter the new username
		Spg.enterSignupUsername(username);
		logger.info("Username Entered");
		
		//4. Enter the valid password
		Spg.enterSignupPassword(password);
		logger.info("Password Entered");
		
		//5. Click on Signup 
		Spg.clickOnSignupbutton();
		logger.info("SignUp button clicked");

		//6. Click ok on alert
		alertIsPresent(5);
		getDriver().switchTo().alert().accept();
		
		Thread.sleep(2000);
		
		logger.info("\n\n************************TestCase verifySignup_DataDriven END***************************\n");
	}

	
	
//	//Data provider for signup
//	@DataProvider(name = "SignupDataProvider")
//	public String[][] SignupDataProvider()
//	{
//		String filename = System.getProperty("user.dir") + "\\TestData\\BStoreTestData.xlsx";
//		
//		int totalRow = ReadExcelFile.getRowCount(filename, "Signup");
//		int totalColumns = ReadExcelFile.getColCount(filename, "Signup");
//		
//		String data[][] = new String[totalRow-1][totalColumns];
//		
//		for(int i=1;i<totalRow;i++) //rows = 1,2...
//		{
//			for(int j=0;j<totalColumns;j++) //columns = 0,1,2
//			{
//				data[i-1][j] = ReadExcelFile.getCellValue(filename, "Signup", i, j);
//			}
//		}
//		return data;
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
