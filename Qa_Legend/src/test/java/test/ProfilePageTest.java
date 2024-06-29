package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constants.Constants;
import constants.Messages;
import page_object.HomePage;
import page_object.LoginPage;
import page_object.ProfilePage;
import utilities.Excel_Utility;
import utilities.RandomData_Utility;

public class ProfilePageTest extends Base {

	@Test
	public void verifyEditProfile() {

		String username_value = Excel_Utility.readStringData(0, 0, Constants.LOGINPAGE);
		String password_value = Excel_Utility.readIntegerData(0, 1, Constants.LOGINPAGE);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(username_value);
		login.enterPassword(password_value);
		HomePage home = login.clickOnLoginButton();
		home.clickOnEndTour();
		home.clickUserLogoutDashboard();
		ProfilePage profile = home.clickOnProfileButton();
		String newlastname_value = RandomData_Utility.getLastName();
		profile.editLastName(newlastname_value);
		profile.clickOnUpdateButton();
		String actual_editname = home.getUserProfileText();
		String expected_profilename = Constants.PROFILENAME + newlastname_value;
		Assert.assertEquals(actual_editname, expected_profilename, Messages.PROFILE_MISMATCH);

	}

}
