package com.qa.wallethub.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.wallethub.utils.ElementUtil;

public class WhHomePage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	private By loginLink = By.xpath("//span[@class='brgm-button brgm-signup brgm-signup-login']");
	private By homePageHeader = By.xpath("//div[@class='info text-select']/h1");
	private By allStarRating = By.xpath("//div[@style='height: 35px;']//*[local-name()='svg']/*[name()='g']");
	private By fourthStar = By
			.xpath("(//div[@style='height: 35px;']//*[local-name()='svg']/*[name()='g'])[position()=4]");
	private By reviewUpdateUserId = By.xpath("(//span[@class='rvtab-ci-nickname regular-font'])[position()=1]");
	private By reviewUpdateContent = By
			.xpath("(//div[contains(@class,'rvtab-ci-content with-links text-select')])[position()=1]");

	public WhHomePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getPageTitle() {
		if (eleUtil.waitForPageActualTitle("test insurance company metatitle test", 10)) {
			return driver.getTitle();
		}
		return null;
	}

	public boolean iSLoginLinkExist() {
		return driver.findElement(loginLink).isDisplayed();
	}

	public WhLoginPage doClickLoginLink() {
		if (iSLoginLinkExist()) {
			driver.findElement(loginLink).click();
		}
		return new WhLoginPage(driver);
	}

	public boolean iSHomePageHeaderExist() {
		WebElement header = eleUtil.waitForElementVisible(homePageHeader, 10);
		return header.isDisplayed();
	}

	public String getHomePageHeader() {
		if (iSHomePageHeaderExist()) {
			return driver.findElement(homePageHeader).getText();
		}
		return null;
	}

	public WritingReviewPage doClickOnFourthStar() {
		WebElement fourthStar1 = driver.findElement(fourthStar);
		Actions act = new Actions(driver);
		List<WebElement> stars = driver.findElements(allStarRating);
		for (int i = 0; i < stars.size(); i++) {
			act.moveToElement(stars.get(i)).perform();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (stars.get(3).equals(fourthStar1)) {
				act.click(fourthStar1).perform();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
		}
		return new WritingReviewPage(driver);
	}

	public String getReviewUpdatedUserId() {
		eleUtil.waitForElementVisible(reviewUpdateUserId, 5);
		return driver.findElement(reviewUpdateUserId).getText();
	}

	public String getReviewUpdatedContent() {
		return driver.findElement(reviewUpdateContent).getText();
	}

}
