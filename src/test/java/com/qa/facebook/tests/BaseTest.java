package com.qa.facebook.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.facebook.factory.DriverFactory;
import com.qa.facebook.pages.FBHomePage;
import com.qa.facebook.pages.FBLoginPage;

public class BaseTest {
	DriverFactory df;
	Properties prop;
	WebDriver driver;
	FBLoginPage loginPage;
	FBHomePage homePage;

	@BeforeTest
	public void SetUp() {
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		loginPage = new FBLoginPage(driver);
		homePage = new FBHomePage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
