package com.crm.qa.base;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public TestBase()  {
		try {
			 prop = new Properties();
			 FileInputStream fis = new FileInputStream(new File("C:\\Users\\uvana\\Downloads\\FreeCRMTest-20211030T160420Z-001\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties"));
			 prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void initilization() {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\uvana\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		EventFiringWebDriver firingWebDriver = new  EventFiringWebDriver(driver);
		WebEventListener eventListener = new WebEventListener();
		firingWebDriver.register(eventListener);
		driver = firingWebDriver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.6, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		driver.switchTo().frame(0)
	}
}
