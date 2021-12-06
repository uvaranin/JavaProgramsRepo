package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TestUtil testUtil;
	
	HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initilization();
		loginpage = new LoginPage();
		testUtil = new TestUtil();
		homepage = loginpage.clickLoginSubmit();
	}
	
	@Test(priority = 1)
	public void verifyHomePagetitle() {
		String homeTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homeTitle, "Cogmento CRM", "HomeTitle not matched.");
	}
	
	@Test(priority = 2)
	public void verifyUserLabel() {
		Assert.assertTrue(homepage.verifyUsernameLabel());
	}
	
	@Test(priority = 3)
	public void verifyContactsLink() {
		 contactsPage = homepage.clickOnContacts();
	}
	
	@Test(priority = 4)
	public void verifyDealsLink() {
		 dealsPage = homepage.clickOnDeals();
	}
	@Test(priority = 4)
	public void verifyDealsLink() {
		 dealsPage = homepage.clickOnDeals();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
