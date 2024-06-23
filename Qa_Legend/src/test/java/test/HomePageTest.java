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
import page_object.HomePage;
import page_object.LoginPage;
import utilities.Excel_Utility;
import utilities.RandomData_Utility;
public class HomePageTest extends Base {
	
	@Test
	public void verifyHomePageTitle()
	{
		String username_value=Excel_Utility.readStringData(0, 0,Constants.LOGINPAGE);
		String password_value =Excel_Utility.readIntegerData(0, 1,Constants.LOGINPAGE);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(username_value);
		login.enterPassword(password_value);
		HomePage home=login.clickOnLoginButton();
		String actualtitle=home.getHomePageTitle();
		String expectedtitle=Excel_Utility.readStringData(0, 0,Constants.HOMEPAGE);
		Assert.assertEquals(actualtitle,expectedtitle,Messages.HOME_TITLEMISMATCH);
					
	}
	
	@Test
	public void verifyUserLoginDate()
	{
		
		String username_value=Excel_Utility.readStringData(0, 0,Constants.LOGINPAGE);
		String password_value =Excel_Utility.readIntegerData(0, 1,Constants.LOGINPAGE);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(username_value);
		login.enterPassword(password_value);
		HomePage home=login.clickOnLoginButton();
		home.clickOnEndTour();
	}
	
	@Test
	public void verifyEditProfile()
	{
		
		String username_value=Excel_Utility.readStringData(0, 0,Constants.LOGINPAGE);
		String password_value =Excel_Utility.readIntegerData(0, 1,Constants.LOGINPAGE);
		LoginPage login =new LoginPage(driver);
		login.enterUserName(username_value);
		login.enterPassword(password_value);
		HomePage home =login.clickOnLoginButton();
		home.clickOnEndTour();
		home.clickUserLogoutDashboard();
		home.clickOnProfileButton();
		String newlastname_value = RandomData_Utility.getLastName();
		home.editLastName(newlastname_value);
		home.clickOnUpdateButton();
		String actual_editname =home.getUserProfileText();
		String expected_profilename=Constants.PROFILENAME+newlastname_value;
		Assert.assertEquals(actual_editname, expected_profilename,Messages.HOME_PROFILEMISMATCH);
		
		
	}

}
