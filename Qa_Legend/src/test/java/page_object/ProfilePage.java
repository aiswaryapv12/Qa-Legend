package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
	
	WebDriver driver;
	public ProfilePage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//input[@id='last_name']")
	WebElement newlastname_field;
	@FindBy(xpath="//button[text()='Update']")
	WebElement update_button;
	
	public void editLastName(String newlastname_value)
	{
		newlastname_field.clear();
		newlastname_field.sendKeys(newlastname_value);
	}
	public void clickOnUpdateButton()
	{
		 update_button.click();
	}
	
	
}
