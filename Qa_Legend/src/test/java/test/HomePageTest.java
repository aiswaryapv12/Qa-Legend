package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import utilities.Excel_Utility;
public class HomePageTest extends Base {
	
	@Test
	public void verifyHomePageTitle()
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
		String actualtitle=driver.getTitle();
		System.out.println(actualtitle);
		String expectedtitle=Excel_Utility.readStringData(0, 0,"Home_Page");
		System.out.println(expectedtitle);
		Assert.assertEquals(actualtitle,expectedtitle,"INVALID TITLE");
					
	}
	
	@Test
	public void verifyUserLoginDate()
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
	}
	
	@Test
	public void verifyTotalPurchaseInWeek()
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
		WebElement total_purchasefield=driver.findElement(By.xpath("//span[@class='info-box-number total_purchase']"));
		String total_purchase =total_purchasefield.getText();
		System.out.println(total_purchase);
		WebElement purchase_duefield=driver.findElement(By.xpath("//span[@class='info-box-number purchase_due']"));
		String purchase_due =purchase_duefield.getText();
		System.out.println(purchase_due);
		
	}

}
