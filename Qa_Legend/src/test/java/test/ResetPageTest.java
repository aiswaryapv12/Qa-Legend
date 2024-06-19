package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import utilities.Excel_Utility;

public class ResetPageTest extends Base {
	
	@Test
	public void verifyErrorMessageWithInvalidEmail()
	{
		WebElement forgotpassword_field =driver.findElement(By.xpath("//a[@class='btn btn-link']"));
		forgotpassword_field.click();
		WebElement email_field= driver.findElement(By.xpath("//input[@id='email']"));
		String email_value=Excel_Utility.readStringData(0, 0,"Reset_Page");
		email_field.sendKeys(email_value);
		WebElement sendpassword_resetlink=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		sendpassword_resetlink.click();
		WebElement actual_messagefield= driver.findElement(By.xpath("//span[@class='help-block']"));
		String actualmessage =actual_messagefield.getText();
		String expected_message =Excel_Utility.readStringData(0, 1,"Reset_Page");
		Assert.assertEquals(actualmessage, expected_message,"Email address is valid");
		
	}
	
	@Test
	public void verifyResetPassword()
	{
		WebElement forgotpassword_field =driver.findElement(By.xpath("//a[@class='btn btn-link']"));
		forgotpassword_field.click();
		WebElement email_field= driver.findElement(By.xpath("//input[@id='email']"));
		String email_value=Excel_Utility.readStringData(2, 0,"Reset_Page");
		email_field.sendKeys(email_value);
		WebElement sendpassword_resetlink=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		sendpassword_resetlink.click();
		WebElement actualmessage_field= driver.findElement(By.xpath("//div[@class='alert alert-success']"));
		String actual_message =actualmessage_field.getText();
		String expected_message=Excel_Utility.readStringData(2, 1,"Reset_Page");
		Assert.assertEquals(actual_message, expected_message,"Invalid Email_id ");
		
		
	}

}
