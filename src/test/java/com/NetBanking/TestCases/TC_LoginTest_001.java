package com.NetBanking.TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.NetBanking.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	LoginPage login;
	
	
	@Test(priority=1)
	public void logintest() throws IOException
	{
		
		
		 login = new LoginPage(driver);
		 
		 logger.info("User enters username and password");
		login.setUsername(username);
		
		login.setPassword(password);
		//highlightElement(driver, login.store_webelement_password(),"logintest");
		
		
		login.clickonLoginbutton();
		
	if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))	
	{
		logger.info("Title validation started");
		Assert.assertTrue(true);
	}
	else
	{
		captureScreenshot(driver,"logintest");
		Assert.assertTrue(false);
	}
		
	
	}
	@Test(priority=2)
	public void logout_test() 
	{
		logger.info("User logsout from application");
		login.logout();
		
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		
		
	}
	

}
