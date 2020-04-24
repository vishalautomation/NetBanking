package com.NetBanking.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.NetBanking.Utilities.ReadConfig;
import com.NetBanking.Utilities.TestUtil;

public class BaseClass {
	
	
	ReadConfig readconfig = new ReadConfig();
	
	String url = readconfig.getApplicationURL();
	public String username = readconfig.getUserName();
	public String password = readconfig.getPassword();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public  void Initialization(String browsr) 
	{
		
		 logger = Logger.getLogger("NetBanking");
		 PropertyConfigurator.configure("Log4j.properties");
		// Logger.getRootLogger().setLevel(Level.OFF);
		
		
		 
		
		
		if(browsr.equals("chrome"))
		{		
		System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
		System.setProperty("webdriver.chrome.silentOutput", "true");
		 driver = new ChromeDriver();
		
		
		}
		
		else if(browsr.equals("firefox"))
		{		
		System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxpath());
		 driver = new FirefoxDriver();
		
		}
		
		else if(browsr.equals("ie"))
		{		
		System.setProperty("webdriver.chrome.driver", readconfig.getIEpath());
		 driver = new InternetExplorerDriver();
		
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
	
	}
	
	@AfterClass
	public void teardown()
	
	{
		
		driver.quit();
	
	}
	
	public void captureScreenshot(WebDriver driver, String testcasename) throws IOException 
	{
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + testcasename + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
	
	}
	
	public String random_string()
	{
		
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return generatedstring;
		
	}
	
	public String random_number()
	{
		
		String generatednumber = RandomStringUtils.randomNumeric(5);
		return generatednumber;
	}
	
	public void highlightElement(WebDriver driver,WebElement element,String testcasename) throws IOException
	{
	
	JavascriptExecutor js = ((JavascriptExecutor)driver);
	js.executeScript("arguments[0].setAttribute('style','background: red; border:4px solid red;');", element);
	
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir") + "/Screenshots/" + testcasename + ".png");
	FileUtils.copyFile(source, target);
	
}
}

