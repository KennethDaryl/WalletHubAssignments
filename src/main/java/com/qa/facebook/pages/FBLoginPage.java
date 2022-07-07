package com.qa.facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FBLoginPage {

	private WebDriver driver;
	private By FBLogo = By.xpath("//img[@class='fb_logo _8ilh img']");
	private By email = By.cssSelector("input#email");
	private By pwd = By.xpath("//input[@id='pass']");
	private By loginButton = By.xpath("//button[@name='login']");
	private By forgotPasswordLink = By.xpath("//a[text()='Forgotten password?']");

	public FBLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean iSFBLogoDisplayed() {
		return driver.findElement(FBLogo).isDisplayed();
	}

	public boolean iSForgotPasswordLinkExist() {
		return driver.findElement(forgotPasswordLink).isDisplayed();
	}

	public FBHomePage doLogin(String username, String password) {
		driver.findElement(email).sendKeys(username);
		driver.findElement(pwd).sendKeys(password);
		driver.findElement(loginButton).click();
		return new FBHomePage(driver);
	}
}
