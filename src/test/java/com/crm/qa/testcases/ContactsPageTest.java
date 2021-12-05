package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase  {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TestUtil testUtil;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initilization();
		loginpage = new LoginPage();
		testUtil = new TestUtil();
		homepage = loginpage.clickLoginSubmit();
		contactsPage = homepage.clickOnContacts();
	}
	
	@Test(priority = 1, enabled=false)
	public void verifyContactsLabelTest() {
		String actualContactLabel = contactsPage.verifyContactsLabel();
		Assert.assertEquals(actualContactLabel, "Contacts");
	}
	
	@Test(priority = 2, enabled = false)
	public void clickContact() throws InterruptedException {
		
		contactsPage.selectContact();
		Thread.sleep(1000);
	}
	
	@DataProvider(name="freeCRMTestData")
	public  Object[][]  getTestData() throws EncryptedDocumentException, IOException{
		Object data[][] = TestUtil.getTestData(TestUtil.testDataSheetPath);
		return data;
	}
	
	@Test(dataProvider = "freeCRMTestData")
	public void createNewContact(String fname, String lname) {
		contactsPage.clickCreateNewContact(fname,lname);
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
