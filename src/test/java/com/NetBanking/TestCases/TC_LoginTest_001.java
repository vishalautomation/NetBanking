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
		login.setUsername(username);
		login.setPassword(password);
		login.clickonLoginbutton();
		
	if(driver.getTitle().equals("Guru99 Bank Manager HomePageee"))	
	{
		
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
		login.logout();
		
	}
	

}
