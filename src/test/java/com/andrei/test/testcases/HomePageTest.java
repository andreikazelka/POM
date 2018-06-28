package com.andrei.test.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.andrei.test.base.TestBase;
import com.andrei.test.pages.BrowsePage;
import com.andrei.test.pages.HomePage;
import com.andrei.test.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	BrowsePage browsePage;
	
	public HomePageTest(){
		super(); //used to invoke immediate parent class constructor.
		System.out.println("Invoke " + this.getClass() + " constructor");
	}
	
	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
//	@Test(priority=1)
//	public void verifyHomePageTitleTest(){
//		String homePageTitle = homePage.verifyHomePageTitle();
//		Assert.assertEquals(homePageTitle, "Home | Pluralsight","Home page title not matched");
//	}
	
//	@Test(priority=2)
//	public void verifyUserNameTest(){
//		testUtil.switchToFrame();
//		Assert.assertTrue(homePage.verifyCorrectUserName());
//	}
	
	@Test(priority=3)
	public void verifyBrowseLinkTest(){
		browsePage = homePage.clickOnBrowseLink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
