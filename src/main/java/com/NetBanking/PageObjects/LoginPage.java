package com.NetBanking.PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NetBanking.TestCases.BaseClass;


public class LoginPage extends BaseClass {
	
	
	
	public LoginPage(WebDriver driver)
	
	{
		
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(name="uid")
	WebElement username;
	
	@FindBy(name="password")
	WebElement pswrd;
	
	@FindBy(name="btnLogin")
	WebElement loginbtn;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	WebElement logout;
	
	
	
	
	
	public void setUsername(String uname)
	{
		username.sendKeys(uname);
		
	}
	
	public void setPassword(String pwd)
	{
		pswrd.sendKeys(pwd);
		
	}
	
	public void clickonLoginbutton()
	{
		loginbtn.click();
		
	}
	
	public void logout()
	{
		logout.click();
	}
	
	
	

}
