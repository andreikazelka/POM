package com.andrei.test.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.andrei.test.base.TestBase;
import com.andrei.test.pages.HomePage;
import com.andrei.test.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super(); //used to invoke immediate parent class constructor.
		System.out.println("Invoke " + this.getClass() + " constructor");
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		System.out.println("Getting page title...");
		String title = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(title, "Sign In - Pluralsight");
	}
	
//	@Test(priority=2)
//	public void crmLogoImageTest(){
//		boolean flag = loginPage.validateCRMImage();
//		Assert.assertTrue(flag);
//	}
//	
	@Test(priority=3)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(){
		System.out.println("Quitting driver...");
		driver.quit();
	}
}
