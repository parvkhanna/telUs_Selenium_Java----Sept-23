package com.base;


import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest extends Base  {

//	public String browserName = prop.getProperty("browser");
	public String url = prop.getProperty("url");
//	
	//String url = "https://telustvplus.com/#/";
	
	
	public BaseTest() throws IOException {
		super();
	}
	
	@BeforeTest
	public void launchBrowser()
	{
		driver = setup(url);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
