package com.andrei.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.andrei.test.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - OR:
	@FindBy(name="Username")
	WebElement username;
	
	@FindBy(name="Password")
	WebElement password;
	
//	@FindBy(xpath="//input[@type='submit']")
	@FindBy(id = "login")
	WebElement loginBtn;
	
//	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
//	WebElement crmLogo;
	
	//Initializing the Page Objects:
	public LoginPage(){
		System.out.println("Invoke " + this.getClass() + " constructor");
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String verifyLoginPageTitle(){
		String title = driver.getTitle();
		System.out.println("Page title: " + title);
		return title;
	}
	
//	public boolean validateCRMImage(){
//		return crmLogo.isDisplayed();
//	}
	
	public HomePage login(String userName, String pwd){
		System.out.println("Login with email: " + userName + " and password: " + pwd);
		username.sendKeys(userName);
		password.sendKeys(pwd);
		loginBtn.click();
//		    	JavascriptExecutor js = (JavascriptExecutor)driver;
//		    	js.executeScript("arguments[0].click();", loginBtn);		
		return new HomePage();
	}
}
