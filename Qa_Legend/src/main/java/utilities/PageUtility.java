package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	static int index = 3;

	public static void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public static void selectByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	public static void selectByRoleIndex(WebElement element) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public static void actionForDoubleClick(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}

	public static void actionForContextClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}

	public static void actionForDrapAndDrop(WebDriver driver, WebElement dragelement, WebElement dropelement) {
		Actions action = new Actions(driver);
		action.dragAndDrop(dragelement, dropelement).build().perform();
	}

	public static void actionForMouseHover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public static void simpleAlertWithAccept(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public static void forConformationAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public static void forPromptAlert(WebDriver driver, String value) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
		alert.accept();
	}

}
