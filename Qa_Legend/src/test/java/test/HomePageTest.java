package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constants.Constants;
import constants.Messages;
import listener.RetryAnalyzer;
import page_object.HomePage;
import page_object.LoginPage;
import utilities.Excel_Utility;
import utilities.RandomData_Utility;

public class HomePageTest extends Base {

	@Test
	public void verifyHomePageTitle() {
		String username_value = Excel_Utility.readStringData(0, 0, Constants.LOGINPAGE);
		String password_value = Excel_Utility.readIntegerData(0, 1, Constants.LOGINPAGE);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(username_value);
		login.enterPassword(password_value);
		HomePage home = login.clickOnLoginButton();
		String actualtitle = home.getHomePageTitle();
		String expectedtitle = Excel_Utility.readStringData(0, 0, Constants.HOMEPAGE);
		Assert.assertEquals(actualtitle, expectedtitle, Messages.HOME_TITLEMISMATCH);

	}

	@Test
	public void verifyUserLoginDate() {

		String username_value = Excel_Utility.readStringData(0, 0, Constants.LOGINPAGE);
		String password_value = Excel_Utility.readIntegerData(0, 1, Constants.LOGINPAGE);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(username_value);
		login.enterPassword(password_value);
		HomePage home = login.clickOnLoginButton();
		home.clickOnEndTour();
		String actual_logindate = home.getLoginDate();
		String expected_logindate = home.getCurrentDate();
		Assert.assertEquals(actual_logindate, expected_logindate, Messages.DATE_MISMATCH);

	}
}
