package com.apptest.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.apptest.qa.base.TestBase;
import com.apptest.qa.pages.HomePage;
import com.apptest.qa.pages.LoginPage;

public class LoginPageTestCases extends TestBase {
	
	LoginPage loginPage; 
	HomePage homePage;
	
	//Create LoginPageTestCases constructor and call testBase constructor
	public LoginPageTestCases() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		// Call LoginPage constructor to call LoginPage method from LoginPage Class 
		loginPage = new LoginPage(driver); // Create LoginPage login at class level 
	}
	// write the test cases here 
	@Test
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPage();
		Assert.assertEquals(title, "Facebook – log in or sign up"); // very important
	}
	
	@Test
	public void loginTest(){
	homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));  // returns home page ;	
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
