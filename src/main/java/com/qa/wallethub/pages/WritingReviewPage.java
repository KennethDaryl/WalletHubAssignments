package com.qa.wallethub.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.wallethub.utils.Constants;
import com.qa.wallethub.utils.ElementUtil;

public class WritingReviewPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	private By dropdown = By.xpath("//span[@class='dropdown-placeholder' and contains(text(),'Select')]");
	private By healthInsurance = By
			.xpath("(//ul[@class='dropdown-list ng-enter-element'])[position()=4]/li[contains(text(),'Health')]");
	private By textArea = By.xpath("//div[@class='android textarea-user']/textarea");
	private By submitButton = By.xpath("(//div[@class='sub-nav-ct']/div)[position()=1]");

	public WritingReviewPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public boolean isDropdownDisplayed() {
		WebElement dropdown1 = eleUtil.waitForElementVisible(dropdown, 5);
		return dropdown1.isDisplayed();
	}

	public void doClickDropDown() {
		if (isDropdownDisplayed()) {
			Actions act = new Actions(driver);
			act.click(driver.findElement(dropdown)).perform();
			WebElement healthInsurance1 = eleUtil.waitForElementVisible(healthInsurance, 5);
			act.click(healthInsurance1).perform();
		}
	}

	public WhConfirmationPage doWriteReviewAndSubmit() {
		driver.findElement(textArea).click();
		driver.findElement(textArea).sendKeys(Constants.CONFIRMATION_PAGE_WRITTEN_CONTENT);
		driver.findElement(submitButton).click();
		return new WhConfirmationPage(driver);
	}

}
