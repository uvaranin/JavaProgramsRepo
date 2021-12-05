package com.crm.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initilization();
		loginpage = new LoginPage();
		
	}
	
	@Test(priority = 1, enabled = false)
	public void loginPageTitleTest() {
		String title = loginpage.verifyLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority = 2, enabled=true)
	public void enterCredentials() throws InterruptedException {
		homepage =  loginpage.clickLoginSubmit();
		String hometitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(hometitle, "Cogmento CRM");
	}
	
	@Test(priority = 3, enabled=true)
	public void clickLoginButton() {
		
		homepage =  loginpage.clickLoginSubmit();
		String hometitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(hometitle, "Cogmento CRM");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
