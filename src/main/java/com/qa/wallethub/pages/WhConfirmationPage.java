package com.qa.wallethub.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.qa.wallethub.utils.ElementUtil;

public class WhConfirmationPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	private By confirmationPage = By.xpath("//div[@class='rvc-header']/h2");
	private By confirmPageContent = By.xpath("//div[@class='rvc-header']/h4");
	private By confirmPageWrittenContent = By.xpath("//div[@class='rvc-body-middle']/p");
	private By profileName = By.xpath("//div[@class='brgm-button brgm-user brgm-list-box']/span");
	private By profileLink = By
			.xpath("//div[@class='brgm-list brgm-user-list ng-enter-element']/a[contains(text(),'Profile')]");

	public WhConfirmationPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getConfirmationPageHeader() {
		eleUtil.waitForElementVisible(confirmationPage, 10);
		return driver.findElement(confirmationPage).getText().trim();
	}

	public String getConfirmationPageSubHeader() {
		return driver.findElement(confirmPageContent).getText().trim();
	}

	public String getConfirmationPageWrittenContent() {
		return driver.findElement(confirmPageWrittenContent).getText().trim();
	}

	public WhProfilePage goToProfile() {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(profileName)).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		act.click(driver.findElement(profileLink)).perform();
		return new WhProfilePage(driver);
	}

}
