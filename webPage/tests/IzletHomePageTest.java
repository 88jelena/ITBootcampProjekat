package webPage.tests;

import org.openqa.selenium.WebDriver;

import utility.*;
import webPage.objects.IzletHomePage;
import webPage.objects.IzletLogIn;

public class IzletHomePageTest {

	// Method to open HomePage
	public static void openHomePage(WebDriver wd) {
		if (!wd.getCurrentUrl().equals(IzletHomePage.PAGE_URL)) {
			wd.navigate().to(IzletHomePage.PAGE_URL);
		}
	}

	// Method to test Registration and LogIn row by row, with all data from Excel
	// file
	// written in IHomePageTest class because
	// HomePage contains Registration and LogIn fields

	public static void testWithAllData(WebDriver wd) throws Exception {

		// Set Excel file
		IzletExcelUtils.setExcelFile(IzletDataExcel.PATH + IzletDataExcel.FILE_NAME, IzletDataExcel.SHEET_NAME_1);

		for (int i = 1; i < IzletExcelUtils.getRowCount(IzletDataExcel.SHEET_NAME_1); i++) {

			IzletRegisterTest.testRegForm(wd, i);

			if (wd.getCurrentUrl().equals(IzletLogIn.LOG_IN_URL)) {
				IzletLogInTest.LogOut(wd);
			} else {
				wd.navigate().to(IzletHomePage.PAGE_URL);

			}
		}
	}

}
