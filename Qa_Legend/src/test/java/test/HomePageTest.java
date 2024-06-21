package test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import page_object.HomePage;
import page_object.LoginPage;
import utilities.Excel_Utility;
public class HomePageTest extends Base {
	
	@Test
	public void verifyHomePageTitle()
	{
		String username_value=Excel_Utility.readStringData(0, 0,"Login_Page");
		String password_value =Excel_Utility.readIntegerData(0, 1,"Login_Page");
		LoginPage login = new LoginPage(driver);
		login.enterUserName(username_value);
		login.enterPassword(password_value);
		HomePage home=login.clickOnLoginButton();
		String actualtitle=home.getHomePageTitle();
		String expectedtitle=Excel_Utility.readStringData(0, 0,"Home_Page");
		Assert.assertEquals(actualtitle,expectedtitle,"INVALID TITLE");
					
	}
	
	@Test
	public void verifyUserLoginDate()
	{
		
		String username_value=Excel_Utility.readStringData(0, 0,"Login_Page");
		String password_value =Excel_Utility.readIntegerData(0, 1,"Login_Page");
		LoginPage login = new LoginPage(driver);
		login.enterUserName(username_value);
		login.enterPassword(password_value);
		HomePage home=login.clickOnLoginButton();
		home.clickOnEndTour();
	}
	
	@Test
	public void verifyEditProfile()
	{
		WebElement username_field =driver.findElement(By.xpath("//input[@id='username']"));
		String username_value=Excel_Utility.readStringData(0, 0,"Login_Page");
		username_field.sendKeys(username_value);
		WebElement password_field =driver.findElement(By.xpath("//input[@id='password']"));
		String password_value =Excel_Utility.readIntegerData(0, 1,"Login_Page");
		password_field.sendKeys(password_value);
		WebElement login_button = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		login_button.click();
		WebElement endtour_field=driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm']"));
		endtour_field.click();
		WebElement profile_field = driver.findElement(By.xpath("//a[@class='dropdown-toggle']"));
		profile_field.click();
		WebElement profiletext_field = driver.findElement(By.xpath("//a[text()='Profile']"));
		profiletext_field.click();
		WebElement lastname_field = driver.findElement(By.xpath("//input[@id='last_name']"));
		lastname_field.clear();
		lastname_field.sendKeys("abc");
		WebElement update_field = driver.findElement(By.xpath("//button[text()='Update']"));
		update_field.click();
		//String actual_message =actualmessage_field.getText();
		//String expected_message =Excel_Utility.readStringData(0, 3,"Login_Page");
		//Assert.assertEquals(actual_message,expected_message,"Login is successful");
		
		
	}

}
