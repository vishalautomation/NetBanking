package com.NetBanking.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
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
	String username = readconfig.getUserName();
	String password = readconfig.getPassword();
	
	public static WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public  void Initialization(String browsr)
	{
		if(browsr.equals("chrome"))
		{		
		System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
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
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
	
	}
	
	@AfterClass
	public void teardown()
	
	{
		
		driver.quit();
	
	}

}

