package com.NetBanking.PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.NetBanking.TestCases.BaseClass;

public class AddNewCustomer extends BaseClass {
	
	
	public AddNewCustomer(WebDriver driver)
	{
		
		PageFactory.initElements(driver,this);
	}
	
	
	
	@FindBy(how = How.XPATH,using = "//a[contains(text(),'New Customer')]")
	WebElement newcustomerlink;
	
	
	@FindBy(how = How.NAME,using = "name")
	WebElement txtcustomername;
	
	@FindBy(how = How.XPATH,using = "//input[@value='m']")
	WebElement gender_radiobutton_male;
	
	@FindBy(how = How.XPATH,using = "//input[@value='f']")
	WebElement gender_radiobutton_female;
	
	@FindBy(how = How.XPATH,using = "//input[contains(@type,'date')]")
	WebElement dateofbirth;
	
	@FindBy(how = How.NAME,using = "addr")
	WebElement address;
	
	@FindBy(how = How.NAME,using = "city")
	WebElement city;
	
	@FindBy(how = How.NAME,using = "state")
	WebElement state;
	
	@FindBy(how = How.NAME,using = "pinno")
	WebElement pincode;
	
	@FindBy(how = How.NAME,using = "telephoneno")
	WebElement mobilenumber;
	
	@FindBy(how = How.NAME,using = "emailid")
	WebElement email;
	
	@FindBy(how = How.NAME,using = "password")
	WebElement passwrd;
	
	@FindBy(how = How.NAME,using = "sub")
	WebElement submitbutton;
	
	
	
	
	public void click_on_add_new_customer()
	{
		
		newcustomerlink.click();
	}
	
	public void enter_customer_name(String cname)
	{
		txtcustomername.sendKeys(cname);
		
	}
	
	public void select_gender()
	{
		gender_radiobutton_male.click();
		
		
	}
	
	
	public void select_DOB(String date,String month,String year)
	{
		dateofbirth.sendKeys(date);
		dateofbirth.sendKeys(month);
		dateofbirth.sendKeys(Keys.ARROW_RIGHT);
		dateofbirth.sendKeys(year);
		
	
	}
	
	public void fill_address(String cadress)
	{
		address.sendKeys(cadress);
		
	}
	
	public void enter_city(String ccity)
	{
		city.sendKeys(ccity);
	}
	
	public void enter_state(String cstate)
	{
		state.sendKeys(cstate);
	}

	public void enter_pin(String cpin)
	{
		pincode.sendKeys(cpin);
	}

	public void enter_mobnumber(String cmobnum)
	{
		mobilenumber.sendKeys(cmobnum);
	}
	
	public void enter_email(String cemail)
	{
		email.sendKeys(cemail);
	}
	
	
	public void enter_password(String cpwd)
	{
		passwrd.sendKeys(cpwd);
	}
	
	
	public void click_on_submit_button()
	{
		submitbutton.click();
	}
	
}
	
	
