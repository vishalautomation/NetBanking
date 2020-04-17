package com.NetBanking.TestCases;

import org.testng.annotations.Test;

import com.NetBanking.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	LoginPage login;
	
	@Test(priority=1)
	public void logintest()
	{
		
		driver.get(url);
		 login = new LoginPage(driver);
		login.setUsername(username);
		login.setPassword(password);
		login.clickonLoginbutton();
	
	}
	@Test(priority=2)
	public void logout_test()
	{
		login.logout();
		
	}
	

}
