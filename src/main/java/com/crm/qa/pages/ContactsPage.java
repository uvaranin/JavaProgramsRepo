package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//*[@id=\"dashboard-toolbar\"]/div[1]")
	WebElement contactLabel;
	
	@FindBy(xpath="//*[@id=\"main-nav\"]/div[3]/a/span")
	WebElement contactIcon;
	
	@FindBy(xpath="//a[@href='/contacts/new']/button")
	WebElement createNewContact;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveNewContact;
	
	
	
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	public String verifyContactsLabel() {
		String label = contactLabel.getText();
		return label;
		
	}
	public void clickContactIcon() {
		contactIcon.click();
	}
	public void selectContact() {
		driver.findElement(By.xpath("//table/tbody/tr")).click();
		driver.manage().timeouts().implicitlyWait(0, null);
		driver.switchTo().window(null)
	}
	
	public void clickCreateNewContact(String fname, String lname) {
		createNewContact.click();
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		saveNewContact.click();
	}

}
