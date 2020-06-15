package com.apptest.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.apptest.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this) ; //instead of this we can write , LoginPage.class , pointing to the current class objects
	}


	//Page Factory : OR : Object Repository
	@FindBy(name ="email")
	WebElement username;
	
	@FindBy(name = "pass")
	WebElement password;
	
	@FindBy(xpath = "//input[@type = 'submit']")
	WebElement loginButton ;

	//Actions class : diff features 
	public String validateLoginPage(){
		return driver.getTitle();
	}
	// we can also define features like , image displayed or not 

	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		
		return new HomePage(driver);
	}
}
