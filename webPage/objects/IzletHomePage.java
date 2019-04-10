package webPage.objects;

import org.openqa.selenium.WebDriver;

public class IzletHomePage {

	public static final String PAGE_URL = "https://izlet.000webhostapp.com/izlet/";

	// Method to open HomePage
	public static void openPage(WebDriver wd) {
		wd.get(PAGE_URL);
	}

	// Method to navigate to HomePage
	// if other page is opened
	public static void navigateToPage(WebDriver wd) {
		wd.navigate().to(PAGE_URL);
	}

}
