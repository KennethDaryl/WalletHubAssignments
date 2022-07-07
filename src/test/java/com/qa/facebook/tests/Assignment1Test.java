package com.qa.facebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment1Test extends BaseTest {

	@Test(priority = 1)
	public void iSFBLogoExistTest() {
		Assert.assertTrue(loginPage.iSFBLogoDisplayed());
	}

	@Test(priority = 2)
	public void iSFBForgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.iSForgotPasswordLinkExist());
	}

	@Test(priority = 3)
	public void doLoginTest() {
		homePage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertTrue(homePage.iSWelcomeMsgDisplayed());
	}

	@Test(priority = 4)
	public void doPostMessageTest() {
		Assert.assertTrue(homePage.doPostMessage("Hello World"));
	}

	@Test(priority = 5)
	public void postConfirmationTest() {
		Assert.assertTrue(homePage.iSPostConfirmationExist());
	}

}
