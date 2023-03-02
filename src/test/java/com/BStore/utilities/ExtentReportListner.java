package com.BStore.utilities;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListner implements ITestListener
{

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	
	public void configureReport()
	{
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "BStoreTestReport - " + timestamp + ".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//ExtentReports//" + reportName );
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		//Add System details/environment info to reports
		reports.setSystemInfo("Machine", "Lenevo 1");
		reports.setSystemInfo("Operating System", "Windows 11");
		reports.setSystemInfo("browser", "chrome");
		reports.setSystemInfo("Username", "Suraj");

		//Configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("BStore Testcases Automation Report");
		htmlReporter.config().setReportName("Status Report");
		htmlReporter.config().setTheme(Theme.STANDARD);

	}
	
	//-----------------------------------------------------------------------------------

	//This method called before the execution of class
	public void onStart(ITestContext Result)
	{
		configureReport();
		System.out.println("onStart method invoked");
	}

	//This method called after the execution of class
	public void onFinish(ITestContext Result) 
	{
		reports.flush(); // It is mandatory to call flush method to ensure information is written to report started reporter.
	}

	//-------------------------------------------------------------------------------

	//When Test case get started, this method is called.
	public void onTestStart(ITestResult Result)
	{
		System.out.println("Name of test method started:" +  Result.getName());
	}

	//When Test case get failed, this method is called
	public void onTestFailure(ITestResult Result)
	{
		System.out.println("Name of test method failed:" + Result.getName());

		test = reports.createTest(Result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the Failed test case: " + Result.getName(), ExtentColor.RED));
				


		//Screenshot: Defining the path and adding it to extent_report 
		String screenShotPath = System.getProperty("user.dir") + "//Screenshots//"+ Result.getName() + ".png";

		File screenShotFile = new File(screenShotPath);

		if(screenShotFile.exists())
		{
			test.fail("Captured Screenshot is below: " + test.addScreenCaptureFromPath(screenShotPath));
		}
		
		test.fail(Result.getThrowable());

	}

	//When Test case get skipped, this method is called
	public void onTestSkipped(ITestResult Result)
	{
		System.out.println("Name of test method skipped:" + Result.getName());

		test = reports.createTest(Result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the Skipped test case: " + Result.getName(), ExtentColor.YELLOW));
		
		test.skip(Result.getThrowable());
	}

	//When Test case get passed, this method is called
	public void onTestSuccess(ITestResult Result) 
	{
		System.out.println("Name of test method successfully executed: " + Result.getName());

		test = reports.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the Passed test case:" + Result.getName(), ExtentColor.GREEN));
	}

	//------------------------------------------------------------------------------------------- b

	public void onTestFailedButWithinSuccessPercentage(ITestResult Result)
	{

	}











}
