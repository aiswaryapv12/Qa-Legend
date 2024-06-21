package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import data_provider.Data_Providers;
import page_object.HomePage;
import page_object.LoginPage;
import utilities.Excel_Utility;

//import automation_core.Base;


public class LoginPageTest extends Base
{
	
	
	@Test
	public void verifyUserLoginWithValidCredential()
	{
		
		String username_value=Excel_Utility.readStringData(0, 0,"Login_Page");
		String password_value =Excel_Utility.readIntegerData(0, 1,"Login_Page");
		LoginPage login =new LoginPage(driver);
		login.enterUserName(username_value);
		login.enterPassword(password_value);
		HomePage home =login.clickOnLoginButton();
		String actual_loginmessage= home.getLoginText();
		String expected_loginmessage=Excel_Utility.readStringData(0, 2,"Login_Page");
		Assert.assertEquals(actual_loginmessage, expected_loginmessage,"Invalid user");
		                                                                                                                   
		
	}
	
	
	@Test(dataProvider="invalidUserCredentials",dataProviderClass=Data_Providers.class)
	public void verifyErrorMessageLoginWithInvalidCredential(String username,String password)
	{
		
		LoginPage login = new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		login.clickOnLoginButton();
		String actual_errormessage =login.errorMessageInvalidLogin();
		String expected_errormessage =Excel_Utility.readStringData(0, 3,"Login_Page");
		Assert.assertEquals(actual_errormessage,expected_errormessage,"Login is successful");
				
		
	}

}
