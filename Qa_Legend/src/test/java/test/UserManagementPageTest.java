package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constants.Constants;
import constants.Messages;
import page_object.HomePage;
import page_object.LoginPage;
import page_object.UserManagementPage;
import utilities.Excel_Utility;

public class UserManagementPageTest extends Base {

	@Test

	public void verifyUsersInUserManagement() {
		String username_value = Excel_Utility.readStringData(0, 0, Constants.LOGINPAGE);
		String password_value = Excel_Utility.readIntegerData(0, 1, Constants.LOGINPAGE);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(username_value);
		login.enterPassword(password_value);
		HomePage home = login.clickOnLoginButton();
		home.clickOnEndTour();
		UserManagementPage usermanagement = home.clickUserManagement();
		boolean users_status = usermanagement.usersOptionInUserManagement();
		Assert.assertTrue(users_status, Messages.USERS_OPTION_NOTENABLED);

	}

	@Test
	public void verifyRolesInUserManagement() {
		String username_value = Excel_Utility.readStringData(0, 0, Constants.LOGINPAGE);
		String password_value = Excel_Utility.readIntegerData(0, 1, Constants.LOGINPAGE);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(username_value);
		login.enterPassword(password_value);
		HomePage home = login.clickOnLoginButton();
		home.clickOnEndTour();
		UserManagementPage usermanagement = home.clickUserManagement();
		boolean roles_status = usermanagement.rolesOptionInUserMangement();
		Assert.assertTrue(roles_status, Messages.ROLES_OPTION_NOTENABLED);

	}

	@Test
	public void verifyAgentsInUserManagement() {
		String username_value = Excel_Utility.readStringData(0, 0, Constants.LOGINPAGE);
		String password_value = Excel_Utility.readIntegerData(0, 1, Constants.LOGINPAGE);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(username_value);
		login.enterPassword(password_value);
		HomePage home = login.clickOnLoginButton();
		home.clickOnEndTour();
		UserManagementPage usermanagement = home.clickUserManagement();
		boolean agents_status = usermanagement.agentsOptionInUserManagement();
		Assert.assertTrue(agents_status, Messages.AGENTS_OPTION_NOTENABLED);

	}

}
