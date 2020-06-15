package com.apptest.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.apptest.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//verify title 
	// Click on Friend Request
	//Click on Messenger
	//Click on Notification
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this );
	}
	//Page Factory
	
	@FindBy(xpath = "//a[@class = '_2s25']")
	WebElement home;
	
	@FindBy(xpath = "//a[@class = '_2s25 _606w']")
	WebElement meghana;

	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public DetailsOfHomePage clickOnHome(){
		home.click();
		return new DetailsOfHomePage(); 
	}
	
	public MeghnaHomePage clickOnMeghna(){
		meghana.click();
		return new MeghnaHomePage(); 
	}
}
