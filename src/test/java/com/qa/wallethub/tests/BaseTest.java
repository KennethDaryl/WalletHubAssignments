package com.qa.wallethub.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.wallethub.factory.DriverFactory;
import com.qa.wallethub.pages.WhConfirmationPage;
import com.qa.wallethub.pages.WhHomePage;
import com.qa.wallethub.pages.WhLoginPage;
import com.qa.wallethub.pages.WhProfilePage;
import com.qa.wallethub.pages.WritingReviewPage;

public class BaseTest {
	DriverFactory df;
	Properties prop;
	WebDriver driver;
	WhHomePage homepage;
	WhLoginPage loginpage;
	WritingReviewPage writereview;
	WhConfirmationPage confirmpage;
	WhProfilePage profilepage;

	@BeforeTest
	public void SetUp() {
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		homepage = new WhHomePage(driver);
		loginpage = new WhLoginPage(driver);
		writereview = new WritingReviewPage(driver);
		confirmpage = new WhConfirmationPage(driver);
		profilepage = new WhProfilePage(driver);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
