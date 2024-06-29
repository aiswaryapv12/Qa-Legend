package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constants.Constants;
import constants.Messages;
import page_object.HomePage;
import page_object.LoginPage;
import page_object.UserManagementPage;
import page_object.UsersPage;
import utilities.Excel_Utility;

public class UsersPageTest extends Base {

	@Test

	public void verifySearchForUser() {
		String username_value = Excel_Utility.readStringData(0, 0, Constants.LOGINPAGE);
		String password_value = Excel_Utility.readIntegerData(0, 1, Constants.LOGINPAGE);
		String emailid = Excel_Utility.readStringData(0, 1, Constants.USERSPAGE);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(username_value);
		login.enterPassword(password_value);
		HomePage home = login.clickOnLoginButton();
		home.clickOnEndTour();
		UserManagementPage usermanagement = home.clickUserManagement();
		UsersPage userspage = usermanagement.clickUsersOption();
		userspage.searchOnSearchField(emailid);
		String actual_usertext = emailid;
		String expected_usertext = userspage.getSearchUser();
		Assert.assertEquals(actual_usertext, expected_usertext, Messages.USERS_INVALIDUSER);
	}
}
