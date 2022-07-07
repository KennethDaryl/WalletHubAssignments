package com.qa.facebook.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FBHomePage {

	private WebDriver driver;
	private By welcomeMsg = By.xpath("//div[@class='bcvklqu9 nzypyw8j']/span");
	private By profile = By.xpath("//span[@class='a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7' and contains(text(),'John')]");
	private By statusField = By.xpath("//div[@class='m9osqain a5q79mjw gy2v8mqq jm1wdb64 k4urcfbm qv66sw1b']/span");
	private By textBox = By.xpath("//p[@class='i1ao9s8h hcukyx3x oygrvhab cxmmr5t8 kvgmc6g5']");
	private By postButton = By.xpath(
			"//span[@class='a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7 ltmttdrg g0qnabr5' and contains(text(),'Post')]");
	private By postConfirmation = By.xpath("//div[@dir='auto']/div/div/div[contains(text(),'Hello')]");

	public FBHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean iSWelcomeMsgDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMsg));
		return driver.findElement(welcomeMsg).isDisplayed();
	}

	public boolean doPostMessage(String statusMessage) {
		driver.findElement(profile).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOfElementLocated(statusField));
		if (driver.findElement(statusField).isDisplayed()) {
			driver.findElement(statusField).click();
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(4));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(textBox));
			driver.findElement(textBox).sendKeys(statusMessage);
			driver.findElement(postButton).click();
		}
		return true;
	}

	public boolean iSPostConfirmationExist() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOfElementLocated(postConfirmation));
		return driver.findElement(postConfirmation).isDisplayed();
	}
}
