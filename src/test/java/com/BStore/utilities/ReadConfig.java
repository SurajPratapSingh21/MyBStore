package com.BStore.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
		//Properties class reference variable
		Properties properties;
		//Properties file path
		String configPath = "C:\\Users\\Fleek\\eclipse-workspace\\B-Store\\Configuration\\Config.properties";
		
		//Contructor
		public ReadConfig() 
		{
			try 
			{
				properties = new Properties();
				FileInputStream fis = new FileInputStream(configPath);
				properties.load(fis);	
			} 
			catch (Exception e) 
			{
				System.out.println("Issue detected in ReadConfig Constructor" +e);
			}
		}
		
		//Method for read URL
		public String getBaseUrl()
		{
			String value = properties.getProperty("baseUrl"); //Passing key
			
			if(value!=null)
				return value;
			else
				throw new RuntimeException("url not specified in config.properties file.");
		}
		
		//Method for read browser
		public String getBrowser()
		{
			String value = properties.getProperty("browser"); //Passing key
			
			if(value!=null)
				return value;
			else
				throw new RuntimeException("browser not specified in config.properties file.");
		}
		
		
		
		
		
		
		
		
		
}
