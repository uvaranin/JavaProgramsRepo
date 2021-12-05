package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase  {

	@FindBy(xpath="//span[contains(text(),'uvarani n')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement taskslink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUsernameLabel() {
		return userNameLabel.isDisplayed();
		
	}
	public ContactsPage clickOnContacts() {
		contactslink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDeals() {
		contactslink.click();
		return new DealsPage();
	}
	

}
