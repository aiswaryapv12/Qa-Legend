package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class UsersPage {
	WebDriver driver;

	public UsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
	WebElement add_field;
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	WebElement search_field;
	@FindBy(className = "toast-success")
	WebElement success_message;
	@FindBy(xpath = "//table[@id='users_table']//tr//td[4]")
	WebElement search_result;

	public AddUserPage clickAddUserButton() {
		add_field.click();
		return new AddUserPage(driver);
	}

	public void searchOnSearchField(String value) {
		search_field.sendKeys(value);
	}

	public String waitForTextToBeInvisible() {
		String msg_text = success_message.getText();
		WaitUtility.waitForElementToBeInvisible(driver, success_message);
		return msg_text;
	}

	public String getSearchUser() {
		WaitUtility.waitForElementToBeVisible(driver, search_result);
		String user = search_result.getText();
		return user;
	}

}
