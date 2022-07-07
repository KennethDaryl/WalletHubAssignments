package com.qa.wallethub.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.wallethub.utils.Constants;

public class Assignment2Test extends BaseTest {

	@Test(priority = 1)
	public void getHomePageTitleTest() {
		Assert.assertEquals(homepage.getPageTitle(), Constants.HOME_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void iSLoginLinkExistTest() {
		Assert.assertTrue(homepage.iSLoginLinkExist());
	}

	@Test(priority = 3)
	public void iSLoginHeaderExist() {
		loginpage = homepage.doClickLoginLink();
		Assert.assertTrue(loginpage.iSLoginHeaderExist());
	}

	@Test(priority = 4)
	public void iSHomePageHeaderExistAfterLoginTest() {
		homepage = loginpage.doLogin(prop.getProperty("WhUsername").trim(), prop.getProperty("WhPassword").trim());
		Assert.assertTrue(homepage.iSHomePageHeaderExist());
	}

	@Test(priority = 5)
	public void getHomePageHeaderTest() {
		Assert.assertEquals(homepage.getHomePageHeader(), Constants.HOME_PAGE_HEADER);
	}

	@Test(priority = 6)
	public void iSDropdownIconExist() {
		writereview = homepage.doClickOnFourthStar();
		Assert.assertTrue(writereview.isDropdownDisplayed());
	}

	@Test(priority = 7)
	public void getConfirmationPageHeaderTest() {
		writereview.doClickDropDown();
		confirmpage = writereview.doWriteReviewAndSubmit();
		Assert.assertEquals(confirmpage.getConfirmationPageHeader(), Constants.CONFIRMATION_PAGE_HEADER);
	}

	@Test(priority = 8)
	public void getConfirmationPageSubHeaderTest() {
		Assert.assertEquals(confirmpage.getConfirmationPageSubHeader(), Constants.CONFIRMATION_PAGE_SUB_HEADER);
	}

	@Test(priority = 9)
	public void getConfirmationPageWrittenContentTest() {
		Assert.assertEquals(confirmpage.getConfirmationPageWrittenContent(),
				Constants.CONFIRMATION_PAGE_WRITTEN_CONTENT);
	}

	@Test(priority = 10)
	public void iSProfileReviewFeedHeaderExistTest() {
		profilepage = confirmpage.goToProfile();
		Assert.assertTrue(profilepage.iSProfileReviewFeedHeaderExist());
	}

	@Test(priority = 11)
	public void iSTestInsuranceCompLinkExistTest() {
		Assert.assertTrue(profilepage.iSTestInsuranceCompLinkExist());
	}

	@Test(priority = 12)
	public void getReviewUpdatedUserIdTest() {
		homepage = profilepage.doClickTestInsuranceCompLink();
		Assert.assertTrue(homepage.getReviewUpdatedUserId().contains(Constants.REVIEW_UPDATED_USER_ID_FRACTION));
	}

	@Test(priority = 13)
	public void getReviewUpdatedContentTest() {
		Assert.assertTrue(
				homepage.getReviewUpdatedContent().contains(Constants.CONFIRMATION_PAGE_WRITTEN_CONTENT_FRACTION));
	}

}
