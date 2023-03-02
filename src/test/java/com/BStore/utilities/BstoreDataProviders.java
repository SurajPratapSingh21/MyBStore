package com.BStore.utilities;

import org.testng.annotations.DataProvider;

public class BstoreDataProviders 
{
	//DataProvider for login
	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		String filename = System.getProperty("user.dir") + "\\TestData\\BStoreTestData.xlsx";
		
		int totalRowCount = ReadExcelFile.getRowCount(filename, "Login");
		int totalColumnCount = ReadExcelFile.getColCount(filename, "Login");
		
		String data[][] = new String[totalRowCount-1][totalColumnCount];
		
		for(int i=1;i<totalRowCount;i++)
		{
			for(int j=0;j<totalColumnCount;j++)
			{
				data[i-1][j] = ReadExcelFile.getCellValue(filename, "Login", i, j);
			}
		}
		return data;
	}
	
	//Data provider for signup
		@DataProvider(name = "SignupDataProvider")
		public String[][] SignupDataProvider()
		{
			String filename = System.getProperty("user.dir") + "\\TestData\\BStoreTestData.xlsx";
			
			int totalRow = ReadExcelFile.getRowCount(filename, "Signup");
			int totalColumns = ReadExcelFile.getColCount(filename, "Signup");
			
			String data[][] = new String[totalRow-1][totalColumns];
			
			for(int i=1;i<totalRow;i++) //rows = 1,2...
			{
				for(int j=0;j<totalColumns;j++) //columns = 0,1,2
				{
					data[i-1][j] = ReadExcelFile.getCellValue(filename, "Signup", i, j);
				}
			}
			return data;
		}
}
