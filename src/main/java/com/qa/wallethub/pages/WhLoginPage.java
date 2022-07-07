package com.qa.wallethub.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WhLoginPage {

	private WebDriver driver;
	private By loginHeader = By.xpath("//h1[@class='h1-heading']");
	private By email = By.cssSelector("input#email");
	private By password = By.cssSelector("input#password");
	private By loginButton = By.xpath("//span[contains(text(),'Login')]");

	public WhLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean iSLoginHeaderExist() {
		return driver.findElement(loginHeader).isDisplayed();
	}

	public WhHomePage doLogin(String emailId, String pwd) {
		if (iSLoginHeaderExist()) {
			driver.findElement(email).sendKeys(emailId);
			driver.findElement(password).sendKeys(pwd);
			driver.findElement(loginButton).click();
		}
		return new WhHomePage(driver);
	}

}
