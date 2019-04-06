package webPage.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IzletLogIn {

	public static final String LOG_IN_URL = "http://localhost/izlet/dashboard.php";

	private static final String USER = "//input[@placeholder='username']";
	private static final String PASS = "//input[@placeholder='password']";
	private static final String LOG_IN = "//input[@value='Log in']";
	private static final String LOG_OUT = "//a[@id='logoutBtn']";

	// Method to open LogIn page
	public static void openLogInPage(WebDriver wd) {
		wd.get(LOG_IN_URL);
	}

	// Method to navigate to LogIn page
	// if other page is opened
	public static void navigateToLogInPage(WebDriver wd) {
		wd.navigate().to(LOG_IN_URL);
	}

	// Method to find LogIn Username field
	public static WebElement getUser(WebDriver wd) {
		WebElement driver = wd.findElement(By.xpath(USER));
		return driver;
	}

	// Method to click on LogIn Username field
	public static void clickUser(WebDriver wd) {
		getUser(wd).click();
	}

	// Method to set LogIn Username
	public static void sendKeysUser(WebDriver wd, String str) {
		getUser(wd).sendKeys(str);
	}

	// Method to find LogIn Password field
	public static WebElement getPass(WebDriver wd) {
		WebElement driver = wd.findElement(By.xpath(PASS));
		return driver;
	}

	// Method to click on LogIn Password field
	public static void clickPass(WebDriver wd) {
		getPass(wd).click();
	}

	// Method to set LogIn Password
	public static void sendKeysPass(WebDriver wd, String str) {
		getPass(wd).sendKeys(str);
	}

	// Method to find LogIn Button
	public static WebElement getLogInButton(WebDriver wd) {
		WebElement driver = wd.findElement(By.xpath(LOG_IN));
		return driver;
	}

	// Method to click on LogIn Button
	public static void clickLogInButton(WebDriver wd) {
		getLogInButton(wd).click();
	}

	// Method to find LogOut Button
	public static WebElement getLogOutButton(WebDriver wd) {
		WebElement driver = wd.findElement(By.xpath(LOG_OUT));
		return driver;
	}

	// Method to click on LogOut Button
	public static void clickLogOutButton(WebDriver wd) {
		getLogOutButton(wd).click();
	}

}
