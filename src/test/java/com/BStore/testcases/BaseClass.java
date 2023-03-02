package com.BStore.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.*;

import com.BStore.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass 
{
	//ReadConfig object creation
	ReadConfig readConfig = new ReadConfig();

	String url = readConfig.getBaseUrl();

	//	String browser = readConfig.getBrowser();

	//For thread-safe
	public static final ThreadLocal<WebDriver> threadLocalDriver = new InheritableThreadLocal<>();

	//Used to set drivers
	public void setDriver(WebDriver driver)
	{
		threadLocalDriver.set(driver);
	}

	//Used to get drivers
	public WebDriver getDriver()
	{
		return threadLocalDriver.get();
	}

	//WebDriver
	//	public static WebDriver driver;

	//Logger
	public static Logger logger;

	//Launch Browser method
	@BeforeClass
	@Parameters("browser")
	public void setup(String browser)
	{
		switch (browser.toLowerCase()) 
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			//			ChromeOptions chromeOptions = new ChromeOptions();
			////			chromeOptions.addArguments("--headless");
			////			chromeOptions.addArguments("--window-size=1400,600");
			setDriver(new ChromeDriver()); //driver setted
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			//			EdgeOptions edgeOptions = new EdgeOptions();
			////			edgeOptions.addArguments("--headless");
			////			edgeOptions.addArguments("--window-size=1400,600");
			setDriver(new EdgeDriver()); 
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--headless");
			firefoxOptions.addArguments("start-maximized");
			setDriver(new FirefoxDriver()); 
			break;

		default:
			setDriver(null);
			break;
		}

		//for logging 
		logger = LogManager.getLogger("B-Store");

		//implicit wait of 10 seconds
		logger.info("Before Test Thread ID: "+Thread.currentThread().getId());
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().navigate().to(url);
		logger.info("url is Opened");

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();

	}


	@AfterClass
	public void tearDown()
	{
		getDriver().close();
		getDriver().quit();
		logger.info("After Test Thread ID: "+Thread.currentThread().getId());
		//		threadLocalDriver.remove();
	}



	public void captureScreenShot(WebDriver driver, String testName) 
	{
		try 
		{
			//step 1: Convert WebDriver object to TakesScreenshot interface
			TakesScreenshot screenshot =((TakesScreenshot)driver);

			//step 2: Call getScreenshots method to create image file

			File src = screenshot.getScreenshotAs(OutputType.FILE);

			File path = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");

			// step 3: Copy image file to destination

			FileUtils.copyFile(src, path);

		} 
		catch (IOException e) 
		{
			System.out.println("Issue in captureScreenShot method" +e);
		}
	}


	//	public void takeScreenshots(String foldername, String filename) 
	//	{
	//		String loc = System.getProperty("user.dir");
	//		String path =loc+"//Screenshots//"+"//"+foldername+"//"+filename+".png"; 		
	//		try 
	//		{
	//			EventFiringWebDriver efw = new EventFiringWebDriver(driver);
	//			File src =	efw.getScreenshotAs(OutputType.FILE);
	//			FileUtils.copyFile(src, new File(path) );
	//		} 
	//		catch (Exception e) 
	//		{
	//			System.out.println("Issue in getScreenshots"+e);
	//		}
	//	}
	//	
	//	public void getResultAnalysis(ITestResult result) 
	//	{
	//		String name	= result.getMethod().getMethodName();
	//			if (result.getStatus()==ITestResult.SUCCESS) 
	//			{
	//				takeScreenshots("Passed", name);
	//			}
	//			else if (result.getStatus()==ITestResult.FAILURE)
	//			{
	//				takeScreenshots("Failed", name);
	//			}
	//	}

	//For find out alert is present or not and also for unexpected alert
	public void alertIsPresent(int time)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(time));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void elementToBeClickable(WebElement ele, int time) 
	{
		WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public void elementToBeVisible(WebElement ele, int time)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void visibilityOfElementLocated(WebElement ele, int time)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) ele));
	}

	public void moveToElementAndClick(WebElement ele)
	{
		Actions actions = new Actions(getDriver());
		actions.moveToElement(ele).click().build().perform();
	}


















}
