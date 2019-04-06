package webPage.tests;

import org.openqa.selenium.WebDriver;

import utility.*;
import webPage.objects.IzletHomePage;


public class IzletHomePageTest {

	// Method to open HomePage
	public static void openHomePage(WebDriver wd) {
		if (!wd.getCurrentUrl().equals(IzletHomePage.PAGE_URL)) {
			wd.navigate().to(IzletHomePage.PAGE_URL);
		}
	}

	// Method to test Registration and LogIn row by row, with all data from Excel file
	// written in IHomePageTest class because
	// HomePage contains Registration and LogIn fields
	public static void testWithAllData(WebDriver wd) throws Exception {

		// Set Excel file
		IzletExcelUtils.setExcelFile(IzletDataExcel.PATH + IzletDataExcel.FILE_NAME, IzletDataExcel.SHEET_NAME_1);
		
		IzletExcelUtils.setCellData(IzletDataExcel.SHEET_NAME_1, "RegStatus", 0, 6); // naming column for reg test results
		IzletExcelUtils.setCellData(IzletDataExcel.SHEET_NAME_1, "LogStatus", 0, 7); // naming column for log test results
		for (int i = 1; i < IzletExcelUtils.getRowCount(IzletDataExcel.SHEET_NAME_1); i++) {

			IzletRegisterTest.fillRegForm(wd, i);
			IzletLogInTest.fillLogInForm(wd, i); 
			IzletLogInTest.LogOut(wd);
			
		}
	}

}
