package webPage.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IzletRegister {
	
	private static final String FIRST_NAME = "//input[@name='firstname']";
	private static final String LAST_NAME = "//input[@name='lastname']";
	private static final String USERNAME = "//form[@action='processregister.php']//input[@name='username']";
	private static final String EMAIL = "//input[@name='email']";
	private static final String PASSWORD = "//form[@action='processregister.php']//input[@name='password']";
	private static final String REGISTER = "//input[@id='blue_btn']";

	// Method to find First name field
	public static WebElement getFirstName(WebDriver wd) {
		WebElement driver = wd.findElement(By.xpath(FIRST_NAME));
		return driver;
	}

	// Method to click on First name field
	public static void clickFirstName(WebDriver wd) {
		getFirstName(wd).click();
	}

	// Method to set First name
	public static void sendKeysFirstName(WebDriver wd, String str) {
		getFirstName(wd).sendKeys(str);
	}

	// Method to find Last name field
	public static WebElement getLastName(WebDriver wd) {
		WebElement driver = wd.findElement(By.xpath(LAST_NAME));
		return driver;
	}

	// Method to click on Last name field
	public static void clickLastName(WebDriver wd) {
		getLastName(wd).click();
	}

	// Method to set Last name
	public static void sendKeysLastName(WebDriver wd, String str) {
		getLastName(wd).sendKeys(str);
	}

	// Method to find Username field
	public static WebElement getUsername(WebDriver wd) {
		WebElement driver = wd.findElement(By.xpath(USERNAME));
		return driver;
	}

	// Method to click on Username field
	public static void clickUsername(WebDriver wd) {
		getUsername(wd).click();
	}

	// Method to set Username
	public static void sendKeysUsername(WebDriver wd, String str) {
		getUsername(wd).sendKeys(str);
	}

	// Method to find Email field
	public static WebElement getEmail(WebDriver wd) {
		WebElement driver = wd.findElement(By.xpath(EMAIL));
		return driver;
	}

	// Method to click on Email field
	public static void clickEmail(WebDriver wd) {
		getEmail(wd).click();
	}

	// Method to set Email
	public static void sendKeysEmail(WebDriver wd, String str) {
		getEmail(wd).sendKeys(str);
	}

	// Method to find Password field
	public static WebElement getPassword(WebDriver wd) {
		WebElement driver = wd.findElement(By.xpath(PASSWORD));
		return driver;
	}

	// Method to click on Password field
	public static void clickPassword(WebDriver wd) {
		getPassword(wd).click();
	}

	// Method to set Password
	public static void sendKeysPassword(WebDriver wd, String str) {
		getPassword(wd).sendKeys(str);
	}

	// Method to find Registration Button
	public static WebElement getRegisterButton(WebDriver wd) {
		WebElement driver = wd.findElement(By.xpath(REGISTER));
		return driver;
	}

	// Method to click on Registration Button
	public static void clickRegisterButton(WebDriver wd) {
		getRegisterButton(wd).click();
	}

}
