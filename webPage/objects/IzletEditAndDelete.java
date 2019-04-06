package webPage.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class IzletEditAndDelete {

	public static final String IMG2_PATH = "C:\\Users\\Coye\\coye.jpg";

	private static final String POSTS = "posts"; // class
	private static final String DOTS = "fa-ellipsis-v"; // class
	private static final String EDIT = "fa-edit"; // class
	private static final String DELETE = "fa-trash-alt"; // class
	
	private static final String EDIT_TITLE = "//input[@id='title']"; 
	private static final String EDIT_LOCATION = "//input[@id='location']"; 
	public static final String CHANGE_IMG = "editImage"; // id
	private static final String EDIT_TRANSPORT = "//select[@id='transport']"; 
	private static final String EDIT_DESCRIPTION = "//textarea[@id='description']";
	private static final String EDIT_POST = "//div[@class='popupEdit']//input[@value='Post']"; 

	// Method to find Post to Edit/Delete
	// 'n' stands for the Post no. on the list
	public static WebElement getPostToEdit(WebDriver wd, int n) {
		List<WebElement> list = wd.findElements(By.className(POSTS));
		WebElement driver = list.get(n);
		return driver;
	}

	// Method to click on Post to Edit/Delete
	// 'n' stands for the Post no. on the list
	public static void clickPostToEdit(WebDriver wd, int n) {
		getPostToEdit(wd, n).click();
	}

	// Method to find 3 dots (more options) Button
	// 'n' stands for the post no.on the list
	public static WebElement getDots(WebDriver wd, int n) {
		clickPostToEdit(wd, n);
		List<WebElement> list = wd.findElements(By.className(DOTS));
		WebElement driver = list.get(n);
		return driver;
	}

	// Method to click 3 dots (more options) Button
	// 'n' stands for the post no.on the list
	public static void clickDots(WebDriver wd, int n) {
		getDots(wd, n).click();
	}

	// Method to find Edit element
	// 'n' stands for the post no.on the list
	public static WebElement getEdit(WebDriver wd, int n) {
		clickDots(wd, n);
		List<WebElement> list = wd.findElements(By.className(EDIT));
		WebElement driver = list.get(n);
		return driver;
	}

	// Method to click Edit
	// 'i' stands for the post no.on the list
	public static void clickEdit(WebDriver wd, int n) throws Exception {
		getEdit(wd, n).click();
		Thread.sleep(3000);
	}

	// Method to find Delete element
	// 'n' stands for the post no.on the list
	public static WebElement getDelete(WebDriver wd, int n) {
		clickDots(wd, n);
		List<WebElement> list = wd.findElements(By.className(DELETE));
		WebElement driver = list.get(n);
		return driver;
	}

	// Method to click Delete
	// 'n' stands for the post no.on the list
	public static void clickDelete(WebDriver wd, int n) {
		getDelete(wd, n).click();
	}

	// Method to find Post title field to edit
		public static WebElement getEPostTitle(WebDriver wd) {
			WebElement driver = wd.findElement(By.xpath(EDIT_TITLE));
			return driver;
		}

		// Method to click on Post title field to edit
		public static void clickEPostTitle(WebDriver wd) {
			getEPostTitle(wd).click();
		}

		// Method to set edited Post title
		public static void sendKeysEPostTitle(WebDriver wd, String str) {
			getEPostTitle(wd).clear();
			getEPostTitle(wd).sendKeys(str);
		}

		// Method to find Location field to edit
		public static WebElement getELocation(WebDriver wd) {
			WebElement driver = wd.findElement(By.xpath(EDIT_LOCATION));
			return driver;
		}

		// Method to click on Location field to edit
		public static void clickELocation(WebDriver wd) {
			getELocation(wd).click();
		}

		// Method to set edited Location
		public static void sendKeysELocation(WebDriver wd, String str) throws Exception {
			getELocation(wd).clear();
			getELocation(wd).sendKeys(str);
			Thread.sleep(3000);
		}

	// Method to find Change Image Button
	public static WebElement getChangeImgButton(WebDriver wd) {
		WebElement driver = wd.findElement(By.id(CHANGE_IMG));
		return driver;
	}

	// Method to set new image
	public static void sendKeysEImage(WebDriver wd) throws Exception {
		getChangeImgButton(wd).sendKeys(IMG2_PATH);
		Thread.sleep(3000);
	}
	
	// Method to select and choose Transport to edit
		// from dropdown menu
		public static void selectETransport(WebDriver wd, String str) {
			Select transport = new Select(wd.findElement(By.xpath(EDIT_TRANSPORT)));
			transport.selectByVisibleText(str);
		}

		// Method to find Description field to edit
		public static WebElement getEDescription(WebDriver wd) {
			WebElement driver = wd.findElement(By.xpath(EDIT_DESCRIPTION));
			return driver;
		}

		// Method to click Description field to edit
		public static void clickEDescription(WebDriver wd) {
			getEDescription(wd).click();
		}

		// Method to set edited Description
		public static void sendKeysEDescription(WebDriver wd, String str) {
			getEDescription(wd).clear();
			getEDescription(wd).sendKeys(str);
		}

		// Method to find Edited Post Button
		public static WebElement getEPostButton(WebDriver wd) {
			WebElement driver = wd.findElement(By.xpath(EDIT_POST));
			return driver;
		}

		// Method to click Edited Post Button
		public static void clickEPostButton(WebDriver wd) {
			getEPostButton(wd).click();
		}

		
}
