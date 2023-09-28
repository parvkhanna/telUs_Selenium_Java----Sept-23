package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	public Properties testdata;
	
	public Base() throws FileNotFoundException
	{
		File propFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\config.properties");

		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
//		testdata = new Properties();
//		File datapropFile = new File(
//				System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\testData.properties");
//		FileInputStream fis2 = new FileInputStream(datapropFile);
//		testdata.load(fis2);
	}
	public WebDriver setup(String url)
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get(url);
		return driver;
	}
	
	public void tearDown()
	{
		driver.quit();
	}
	
}
