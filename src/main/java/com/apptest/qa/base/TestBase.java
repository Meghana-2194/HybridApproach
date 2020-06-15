package com.apptest.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.apptest.qa.testutil.TestUtil;

public class TestBase {

	// intialize all the properties
	// all the page classes(child class) based on TestBase class (parent classs)
	// create a test base class constructor

	public static WebDriver driver;
	public static Properties prop;

	public TestBase()  {
		prop = new Properties();
		FileInputStream ip = null;
		try {
			ip = new FileInputStream(
					"C:\\Java Selenium\\PageObjectModel\\HybridApproachPom\\src\\main\\java\\com\\apptest\\qa\\config\\config.properites");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void initialization(){
		prop.getProperty("browser");
		// we can put some condition as well for which browser that we gonna use 
		System.setProperty("webdriver.chrome.driver","C:\\Users\\MMeghana\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
	    String URL = prop.getProperty("url") ;
	    System.out.println(URL);
		
		driver.get(URL);
	}
}
