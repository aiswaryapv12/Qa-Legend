package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPage {
	
	WebDriver driver;
	public ResetPage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//input[@id='email']")
	WebElement reset_emailfield;
	
	@FindBy(xpath ="//button[@class='btn btn-primary']")
	WebElement sendpassword_resetlink;
	
	@FindBy(xpath ="//span[@class='help-block']")
	WebElement error_messagefield;
	
	@FindBy(xpath ="//div[@class='alert alert-success']")
	WebElement confirmation_messagefield;
	
	public String enterEmailAddress(String email)
	{
		reset_emailfield.sendKeys(email);
		return email;
	}
	public void clickOnSendPasswordResetLink()
	{
		sendpassword_resetlink.click();
	}
	public String getErrorMessage()
	{
		String error_message= error_messagefield.getText();
		return error_message;
	}
	public String getConfirmationMessage()
	{
		String message = confirmation_messagefield.getText();
		return message;
	}
	
	

}
