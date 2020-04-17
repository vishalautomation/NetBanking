package com.NetBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	
	Properties prop;
	
	public ReadConfig(){
		
		File src = new File("./Configuration/config.properties");
		
		try {
			
			FileInputStream fis = new FileInputStream(src);
			 prop = new Properties();
			 
				prop.load(fis);
				
			} catch (Exception e) {
				System.out.println("Exception is:"+ e.getMessage());
			}
	}
				
		
		public String getApplicationURL()
		
		{	
			String url =prop.getProperty("ApplicationURL");
			return url;
			
		}
	
		public String getUserName()
		{
			
			String username = prop.getProperty("Username");
			return username;
	
	}

	public String getPassword()
	{
	
		String password = prop.getProperty("Password");
		return password;
	
	}
	
	public String getChromepath()
	{
		
		String chrome = prop.getProperty("chromepath");
		return  chrome;
		
	}
	public String getFirefoxpath()
	{
		
		String firefox = prop.getProperty("firefoxpath");
		return  firefox;
		
	}
	public String getIEpath()
	{
		
		String ie = prop.getProperty("iepath");
		return  ie;
		
	}


}
