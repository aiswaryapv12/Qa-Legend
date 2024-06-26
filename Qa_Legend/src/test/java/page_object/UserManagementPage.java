package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WebElement_Utility;

public class UserManagementPage {
	
	WebDriver driver;
	
	public UserManagementPage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-user']//following-sibling::span")
	WebElement users;
	@FindBy(xpath="//i[@class='fa fa-briefcase']//following-sibling::span")
	WebElement roles;
	@FindBy(xpath="//i[@class='fa fa-handshake-o']//following-sibling::span")
	WebElement salescommission_agent;
	@FindBy(xpath="//span[@class='title' and contains(text(),'Users')]")
	WebElement users_option;
	
	
	public UsersPage clickUsersOption()
	{
		users_option.click();
		return new UsersPage(driver);
	}
	public boolean usersOptionInUserManagement()
	{
		 return WebElement_Utility.isElementDisplayed(users);
	}
	public boolean rolesOptionInUserMangement()
	{
		return WebElement_Utility.isElementEnabled(roles);
	}
	public boolean agentsOptionInUserManagement()
	{
		return WebElement_Utility.isElementEnabled(salescommission_agent);
	}
	
	
	

}
