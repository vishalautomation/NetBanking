package com.NetBanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.NetBanking.PageObjects.LoginPage;
import com.NetBanking.Utilities.XLUtility;

public class TC_LoginDataDriven_002 extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void login_data_driven(String username,String pwd) throws InterruptedException, IOException{
		
		logger.info("url is opened");
		LoginPage login = new LoginPage(driver);
		
		login.setUsername(username);
		logger.info("Entered username");
		
		login.setPassword(pwd);
		logger.info("Entered password");
		
		login.clickonLoginbutton();
		
		Thread.sleep(3000);
		
		if(is_alert_present()==true)
		{
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			captureScreenshot(driver,"login_data_driven");
			Assert.assertTrue(false);
			logger.warn("login failed");
			
		
		}
		else
		{
			
			Assert.assertTrue(true);
			logger.info("login passed");
			login.logout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
		
	}

	public boolean is_alert_present()
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
		
	}
	
	
	
	@DataProvider(name="LoginData")
	 String[][] getData() throws IOException
	{
	
	String path = "C:/Users/l e n o v o/Guru99BankingProject/TestData/Login_Guru99.xlsx";
	
	int rowcount = XLUtility.getRowCount(path, "Sheet1");
	int colcount = XLUtility.getCellCount(path, "Sheet1", 1);
	
	String logindata[][] = new String[rowcount][colcount];
	
	for(int i=1;i<=rowcount;i++)
	{
		for(int j=0;j<colcount;j++)
		{
			
			
			 logindata[i-1][j] = XLUtility.getCellData(path, "Sheet1", i, j);
		}
	}
			
	return logindata;
	
	
	
	}

}
