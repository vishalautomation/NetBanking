package com.NetBanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NetBanking.PageObjects.AddNewCustomer;
import com.NetBanking.PageObjects.LoginPage;

public class TC_AddNewCustomer_003 extends BaseClass {

	@Test(priority=3)
	public void login_test() throws InterruptedException
	{
		logger.info("User is going to login");
		LoginPage login = new LoginPage(driver);
		login.setUsername(username);
		login.setPassword(password);
		login.clickonLoginbutton();
		logger.info("User successfully loggedin");
		Thread.sleep(3000);

	}

	@Test(priority=4)
	public void add_new_customer_test() throws InterruptedException
	{
		AddNewCustomer customer = new AddNewCustomer(driver);
		logger.info("Adding customer details");
		
		customer.click_on_add_new_customer();
		customer.enter_customer_name("Arjun");
		customer.select_gender();
		Thread.sleep(3000);
		customer.select_DOB("15", "April", "1986");
		Thread.sleep(3000);
		customer.fill_address("India");
		customer.enter_city("Hyderabad");
		customer.enter_state("Telangana");
		customer.enter_pin("565656");
		customer.enter_mobnumber("8888888888");
		String emailid = random_string()+"@gmail.com";
		customer.enter_email(emailid);
		customer.enter_password("abcdef");
		customer.click_on_submit_button();

		Thread.sleep(3000);
	}

	@Test(priority=5)
	public void validation() throws IOException
	{
		logger.info("Validation started");
		boolean flag = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if(flag==true)
		{
			Assert.assertTrue(true);
			logger.info("Test case passed");
		}

		else
		{
			logger.info("Test case failed");
			captureScreenshot(driver,"validation");
			Assert.assertTrue(false);

		}

	}
}
