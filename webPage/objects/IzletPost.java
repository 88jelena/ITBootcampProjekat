package webPage.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class IzletPost {

	public static final String POST_URL = "http://localhost/izlet/dashboard.php";
	public static final String IMG1_PATH = "C:\\Users\\Coye\\coye_2.jpg";

	private static final String NEW_POST = "//a[contains(text(),'Make a post')]";
	private static final String TITLE = "//input[@placeholder='Naziv']";
	private static final String LOCATION = "//input[@placeholder='Lokacija']";
	private static final String BROWSE = "image"; // id
	private static final String TRANSPORT = "//div[@class='popupPost']//select[@name='transport']";
	private static final String DESCRIPTION = "//textarea[@placeholder='Opis']"; 
	private static final String POST = "//div[@class='popupPost']//input[@value='Post']";
	

	

	// Method to open Dashboard/Post page
	public static void openPostPage(WebDriver wd) {
		wd.get(POST_URL);
	}

	// Method to navigate to Dashboard/Post page
	// if other page is opened
	public static void navigateToPostPage(WebDriver wd) {
		wd.navigate().to(POST_URL);
	}

	// Method to find Make A Post Button
	public static WebElement getNewPost(WebDriver wd) {
		WebElement driver = wd.findElement(By.xpath(NEW_POST));
		return driver;
	}

	// Method to click on Make A Post Button
	public static void clickNewPost(WebDriver wd) {
		getNewPost(wd).click();
	}

	// Method to find Post title field
	public static WebElement getPostTitle(WebDriver wd) {
		WebElement driver = wd.findElement(By.xpath(TITLE));
		return driver;
	}

	// Method to click on Post title field
	public static void clickPostTitle(WebDriver wd) {
		getPostTitle(wd).click();
	}

	// Method to set Post title
	public static void sendKeysPostTitle(WebDriver wd, String str) {
		getPostTitle(wd).sendKeys(str);
	}

	// Method to find Location field
	public static WebElement getLocation(WebDriver wd) {
		WebElement driver = wd.findElement(By.xpath(LOCATION));
		return driver;
	}

	// Method to click on Location field
	public static void clickLocation(WebDriver wd) {
		getLocation(wd).click();
	}

	// Method to set Location
	public static void sendKeysLocation(WebDriver wd, String str) throws Exception {
		getLocation(wd).sendKeys(str);
		Thread.sleep(3000);
	}

	// Method to find Browse Image Button
	public static WebElement getBrowseButton(WebDriver wd) {
		WebElement driver = wd.findElement(By.id(BROWSE));
		return driver;
	}

	// Method to set image
	public static void sendKeysImage(WebDriver wd) throws Exception {
		getBrowseButton(wd).sendKeys(IMG1_PATH);
		Thread.sleep(3000);
	}

	// Method to select and choose Transport
	// from dropdown menu
	public static void selectTransport(WebDriver wd, String str) {
		Select transport = new Select(wd.findElement(By.xpath(TRANSPORT)));
		transport.selectByVisibleText(str);
	}

	// Method to find Description field
	public static WebElement getDescription(WebDriver wd) {
		WebElement driver = wd.findElement(By.xpath(DESCRIPTION));
		return driver;
	}

	// Method to click Description field
	public static void clickDescription(WebDriver wd) {
		getDescription(wd).click();
	}

	// Method to set Description
	public static void sendKeysDescription(WebDriver wd, String str) {
		getDescription(wd).sendKeys(str);
	}

	// Method to find Post Button
	public static WebElement getPostButton(WebDriver wd) {
		WebElement driver = wd.findElement(By.xpath(POST));
		return driver;
	}

	// Method to click Post Button
	public static void clickPostButton(WebDriver wd) {
		getPostButton(wd).click();
	}

	
}
