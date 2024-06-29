package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DateUtility;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//section[@class='content-header']")
	WebElement login_messagefield;
	@FindBy(xpath = "//button[@class='btn btn-default btn-sm']")
	WebElement endtour_field;
	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	WebElement userlogout_dashboard;
	@FindBy(xpath = "//a[text()='Sign Out']")
	WebElement signout_field;
	@FindBy(xpath = "//a[text()='Profile']")
	WebElement profiletext_field;
	@FindBy(xpath = "//span[text()='User Management']")
	WebElement user_managementfield;
	@FindBy(xpath = "//div[@class='m-8 pull-left mt-15 hidden-xs']")
	WebElement login_datefield;

	public String getLoginText() {
		String user_message = login_messagefield.getText();
		return user_message;
	}

	public String getHomePageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public void clickOnEndTour() {
		endtour_field.click();
	}

	public void clickUserLogoutDashboard() {
		userlogout_dashboard.click();
	}

	public LoginPage clickSignOutButton() {
		signout_field.click();
		return new LoginPage(driver);
	}

	public ProfilePage clickOnProfileButton() {
		profiletext_field.click();
		return new ProfilePage(driver);
	}

	public String getUserProfileText() {
		String profile_text = userlogout_dashboard.getText();
		return profile_text;

	}

	public UserManagementPage clickUserManagement() {
		user_managementfield.click();
		return new UserManagementPage(driver);
	}

	public String getLoginDate() {
		String login_date = login_datefield.getText();
		return login_date;
	}

	public String getCurrentDate() {
		String current_date = DateUtility.getUserLoginDate("dd-MM-YYYY");
		return current_date;
	}

}
