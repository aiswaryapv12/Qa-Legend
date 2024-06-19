package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import data_provider.Data_Providers;
import utilities.Excel_Utility;

//import automation_core.Base;


public class LoginPageTest extends Base
{
	
	
	@Test
	public void verifyUserLoginWithValidCredential()
	{
		WebElement username_field =driver.findElement(By.xpath("//input[@id='username']"));
		String username_value=Excel_Utility.readStringData(0, 0,"Login_Page");
		username_field.sendKeys(username_value);
		WebElement password_field =driver.findElement(By.xpath("//input[@id='password']"));
		String password_value =Excel_Utility.readIntegerData(0, 1,"Login_Page");
		password_field.sendKeys(password_value);
		WebElement login_button = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		login_button.click();
		WebElement actualmessage_field=driver.findElement(By.xpath("//section[@class='content-header']"));
		String actual_message=actualmessage_field.getText();
		String expected_message=Excel_Utility.readStringData(0, 2,"Login_Page");
		Assert.assertEquals(actual_message, expected_message,"Invalid user");
		                                                                                                                   
		
	}
	
	
	@Test(dataProvider="invalidUserCredentials",dataProviderClass=Data_Providers.class)
	public void verifyErrorMessageLoginWithInvalidCredential(String username,String password)
	{
		WebElement username_field =driver.findElement(By.xpath("//input[@id='username']"));
		username_field.sendKeys(username);
		WebElement password_field =driver.findElement(By.xpath("//input[@id='password']"));
		password_field.sendKeys(password);
		WebElement login_button = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		login_button.click();
		WebElement actualmessage_field =driver.findElement(By.xpath("//strong[text()='These credentials do not match our records.']"));
		String actual_message =actualmessage_field.getText();
		String expected_message =Excel_Utility.readStringData(0, 3,"Login_Page");
		Assert.assertEquals(actual_message,expected_message,"Login is successful");
				
		
	}

}
