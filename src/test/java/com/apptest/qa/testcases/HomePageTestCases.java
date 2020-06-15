package com.apptest.qa.testcases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.apptest.qa.base.TestBase;
import com.apptest.qa.pages.DetailsOfHomePage;
import com.apptest.qa.pages.HomePage;
import com.apptest.qa.pages.LoginPage;
import com.apptest.qa.pages.MeghnaHomePage;
import com.apptest.qa.testutil.TestUtil;

public class HomePageTestCases extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	DetailsOfHomePage detailsOfHomePage;
	MeghnaHomePage meghnaHomePage;

	public HomePageTestCases() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		// Call LoginPage constructor to call LoginPage method from LoginPage
		// Class
		testUtil = new TestUtil();
		detailsOfHomePage = new DetailsOfHomePage();
		meghnaHomePage = new MeghnaHomePage();
		loginPage = new LoginPage(driver); // Create LoginPage login at class
											// level
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyTitle() throws InterruptedException {
		String homePageTitle = homePage.verifyHomePageTitle();
		System.out.println(homePageTitle);
		Assert.assertEquals(homePageTitle, "Facebook – log in or sign up", "Verified");

		Thread.sleep(7000);
	}

	@Test(priority = 2)
	public void verifyDetailsOfHomePage() throws InterruptedException {
		detailsOfHomePage = homePage.clickOnHome();

		Thread.sleep(7000);
	}

	@Test(priority = 3)
	public void verifyMeghnaHomePage() throws Exception  {
		meghnaHomePage = homePage.clickOnMeghna();

		Thread.sleep(7000);

		Alert alert = driver.switchTo().alert();
		alert.dismiss();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
