package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//section[@class='content-header']")
	WebElement login_messagefield;
	@FindBy(xpath="//button[@class='btn btn-default btn-sm']")
	WebElement endtour_field;
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	WebElement userlogout_dashboard;
	@FindBy(xpath="//a[text()='Sign Out']")
	WebElement signout_field;
	@FindBy(xpath="//a[text()='Profile']")
	WebElement profiletext_field;
	@FindBy(xpath ="//input[@id='last_name']")
	WebElement newlastname_field;
	@FindBy(xpath="//button[text()='Update']")
	WebElement update_button;
	@FindBy(xpath ="//span[text()='User Management']")
	WebElement user_managementfield;
	@FindBy(xpath="//span[@class='title' and contains(text(),'Users')]")
	WebElement users_option;
	
	public String getLoginText()
	{
		String user_message =login_messagefield.getText();
		return user_message;
	}
	public String getHomePageTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	public void clickOnEndTour()
	{
		endtour_field.click();
	}
	public void clickUserLogoutDashboard()
	{
		userlogout_dashboard.click();
	}
	public LoginPage clickSignOutButton()
	{
		signout_field.click();
		return new LoginPage(driver);
	}
	public void clickOnProfileButton()
	{
		profiletext_field.click();
	}
	public void editLastName(String newlastname_value)
	{
		newlastname_field.clear();
		newlastname_field.sendKeys(newlastname_value);
	}
	public void clickOnUpdateButton()
	{
		 update_button.click();
	}
	public String getUserProfileText()
	{
		String profile_text =userlogout_dashboard.getText();
		return profile_text;
	}
	public void clickUserManagement()
	{
		user_managementfield.click();
	}
	public AddUserPage clickUsersOption()
	{
		users_option.click();
		return new AddUserPage(driver);
	}
	
}
