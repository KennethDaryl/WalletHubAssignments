package com.qa.wallethub.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.wallethub.utils.ElementUtil;

public class WhProfilePage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	private By profileReviewFeedHeader = By.xpath("//section[@class='pr-ct-box pr-rec']/h2");
	private By testInsuranceCompLink = By.xpath("//a[contains(text(),'Test Insurance Company')]");

	public WhProfilePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public boolean iSProfileReviewFeedHeaderExist() {
		WebElement profileReviewFeedHdr = eleUtil.waitForElementVisible(profileReviewFeedHeader, 10);
		return profileReviewFeedHdr.isDisplayed();
	}

	public boolean iSTestInsuranceCompLinkExist() {
		return driver.findElement(testInsuranceCompLink).isDisplayed();
	}

	public WhHomePage doClickTestInsuranceCompLink() {
		if (iSTestInsuranceCompLinkExist()) {
			driver.findElement(testInsuranceCompLink).click();
		}
		return new WhHomePage(driver);
	}
}
