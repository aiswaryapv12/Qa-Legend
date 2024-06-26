package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constants.Constants;
import constants.Messages;
import page_object.AddUserPage;
import page_object.HomePage;
import page_object.LoginPage;
import page_object.UserManagementPage;
import page_object.UsersPage;
import utilities.Excel_Utility;
import utilities.RandomData_Utility;

public class AddUserPageTest extends Base {

	@Test
	public void verifyAddUser() {
		String username_value = Excel_Utility.readStringData(0, 0, Constants.LOGINPAGE);
		String password_value = Excel_Utility.readIntegerData(0, 1, Constants.LOGINPAGE);
		String first_name = RandomData_Utility.getFirtName();
		String last_name = RandomData_Utility.getLastName();
		String email = first_name + last_name + Constants.ID;
		String username = first_name + last_name;
		String password = first_name + Constants.NUMBER + last_name;

		LoginPage login = new LoginPage(driver);
		login.enterUserName(username_value);
		login.enterPassword(password_value);
		HomePage home = login.clickOnLoginButton();
		home.clickOnEndTour();
		UserManagementPage usermanagement = home.clickUserManagement();
		UsersPage userspage = usermanagement.clickUsersOption();
		AddUserPage adduser = userspage.clickAddUserButton();
		adduser.enterFirstName(first_name);
		adduser.enterLastName(last_name);
		adduser.enterEmail(email);
		adduser.selectFromRole();
		adduser.enterUserName(username);
		adduser.enterPassword(password);
		adduser.enterConfirmPassword(password);
		userspage = adduser.clickSaveButton();
		userspage.searchOnSearchField(email);
		String actual_usertext = userspage.getSearchUser();
		String expected_usertext = email;
		Assert.assertEquals(actual_usertext, expected_usertext, Messages.ADDUSER_USERMISMATCH);

	}

	@Test
	public void verifyUserLoginWithNewlyAddUser() {
		String username_value = Excel_Utility.readStringData(0, 0, Constants.LOGINPAGE);
		String password_value = Excel_Utility.readIntegerData(0, 1, Constants.LOGINPAGE);
		String first_name = RandomData_Utility.getFirtName();
		String last_name = RandomData_Utility.getLastName();
		String email = first_name + last_name + Constants.ID;
		String username = first_name + last_name;
		String password = first_name + Constants.NUMBER + last_name;
		LoginPage login = new LoginPage(driver);
		login.enterUserName(username_value);
		login.enterPassword(password_value);
		HomePage home = login.clickOnLoginButton();
		home.clickOnEndTour();
		UserManagementPage usermanagement = home.clickUserManagement();
		UsersPage userspage = usermanagement.clickUsersOption();
		AddUserPage adduser = userspage.clickAddUserButton();
		adduser.enterFirstName(first_name);
		adduser.enterLastName(last_name);
		adduser.enterEmail(email);
		adduser.selectFromRole();
		adduser.enterUserName(username);
		adduser.enterPassword(password);
		adduser.enterConfirmPassword(password);
		userspage = adduser.clickSaveButton();
		userspage.waitForTextToBeInvisible();
		home.clickUserLogoutDashboard();
		home.clickSignOutButton();
		login.enterUserName(username);
		login.enterPassword(password);
		login.clickOnLoginButton();
		String actual_message = home.getLoginText();
		String expected_message = Constants.WELCOME + " " + first_name + ",";
		Assert.assertEquals(actual_message, expected_message, Messages.ADDUSER_NEWINVALIDUSER);
	}
}
