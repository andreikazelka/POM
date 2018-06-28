package com.andrei.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.andrei.test.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//*[@id=\"ps-chrome\"]/div/div[1]/div[2]/div[1]/div/div/div/a[2]/span[2]")
	@CacheLookup// to store element location in cache
	WebElement browseLink;
	
//	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
//	WebElement contactsLink;
//	
//	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
//	WebElement newContactLink;
	
	//Initializing the Page Objects:
	public HomePage(){
		System.out.println("Invoke " + this.getClass() + " constructor");
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		String title = driver.getTitle();
		System.out.println("Page title: " + title);
		return title;
	}
	
	public BrowsePage clickOnBrowseLink() {
		System.out.println("Clicking on Browse link");
		browseLink.click();
		return new BrowsePage();
	}
	
//	public void clickOnNewContactLink(){
//		Actions action = new Actions(driver);
//		action.moveToElement(contactsLink).build().perform();
//		newContactLink.click();
//		
//	}
//	
//	public void createNewContact(String title, String ftName, String ltName, String comp){
//		Select select = new Select(driver.findElement(By.name("title")));
//		select.selectByVisibleText(title);
//		
//		firstName.sendKeys(ftName);
//		lastName.sendKeys(ltName);
//		company.sendKeys(comp);
//		saveBtn.click();
//		
//	}
}
