package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	public boolean usersOptionInUserManagement()
	{
		boolean usersoption =users.isDisplayed();
		return usersoption;
	}
	public boolean rolesOptionInUserMangement()
	{
		boolean rolesoption = roles.isDisplayed();
		return rolesoption;
	}
	public boolean agentsOptionInUserManagement()
	{
		boolean agentsoption =salescommission_agent.isDisplayed();
		return agentsoption;
	}
	
	
	

}
