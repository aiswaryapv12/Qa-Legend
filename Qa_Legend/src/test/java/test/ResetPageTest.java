package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constants.Constants;
import constants.Messages;
import page_object.LoginPage;
import page_object.ResetPage;
import utilities.Excel_Utility;

public class ResetPageTest extends Base {

	@Test(groups = "Sanity")
	public void verifyErrorMessageWithInvalidEmail() {

		String email_value = Excel_Utility.readStringData(0, 0, Constants.RESETPAGE);
		LoginPage login = new LoginPage(driver);
		ResetPage reset = login.clickOnForgotPassword();
		reset.enterEmailAddress(email_value);
		reset.clickOnSendPasswordResetLink();
		String actual_errormessage = reset.getErrorMessage();
		String expected_errormessage = Excel_Utility.readStringData(0, 1, Constants.RESETPAGE);
		Assert.assertEquals(actual_errormessage, expected_errormessage, Messages.RESET_EMAILMISMATCH);

	}

	@Test(groups = "Smoke")
	public void verifyResetPassword() {

		String email_value = Excel_Utility.readStringData(2, 0, "Reset_Page");
		LoginPage login = new LoginPage(driver);
		ResetPage reset = login.clickOnForgotPassword();
		reset.enterEmailAddress(email_value);
		reset.clickOnSendPasswordResetLink();
		String actual_message = reset.getConfirmationMessage();
		String expected_message = Excel_Utility.readStringData(2, 1, Constants.RESETPAGE);
		Assert.assertEquals(actual_message, expected_message, Messages.RESET_FAILURE);

	}

}
