package webPage.tests;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import utility.*;
import webPage.objects.IzletHomePage;
import webPage.objects.IzletLogIn;

public class IzletLogInTest {

	// Method to open LogIn page
	public static void openHomePage(WebDriver wd) {
		if (!wd.getCurrentUrl().equals(IzletLogIn.LOG_IN_URL)) {
			wd.navigate().to(IzletLogIn.LOG_IN_URL);
		}
	}

	// Method to fill in LogIn form through console (via Scanner) by user
	public static void userLogIn(WebDriver wd, Scanner sc) throws Exception {

		System.out.println("Log In by entering your: ");

		// User
		System.out.println("Username");
		IzletLogIn.clickUser(wd);
		IzletLogIn.sendKeysUser(wd, sc.nextLine());

		// Pass
		System.out.println("Password");
		IzletLogIn.clickPass(wd);
		IzletLogIn.sendKeysPass(wd, sc.nextLine());

		// Submit
		IzletLogIn.clickLogInButton(wd);
		if (wd.getCurrentUrl().equals(IzletLogIn.LOG_IN_URL)) {
			System.out.println("Log in successful.");
		} else
			System.out.println("Log in was not successful.");
	}

	// Method to fill in LogIn form using data from Excel file
	public static void fillLogInForm(WebDriver wd, int i) throws Exception {

		String data;

		// Setting Excel file
		IzletExcelUtils.setExcelFile(IzletDataExcel.PATH + IzletDataExcel.FILE_NAME, IzletDataExcel.SHEET_NAME_1);

		// User
		IzletLogIn.clickUser(wd);
		data = IzletExcelUtils.getCellData(i, 2);
		IzletLogIn.sendKeysUser(wd, data);

		// Pass
		IzletLogIn.clickPass(wd);
		data = IzletExcelUtils.getCellData(i, 4);
		IzletLogIn.sendKeysPass(wd, data);

		// Submit
		IzletLogIn.clickLogInButton(wd);
		if (wd.getCurrentUrl().equals(IzletLogIn.LOG_IN_URL)) {
			System.out.println("Log in was successful.");
		} else
			System.out.println("Log in was not successful.");
		}

	

	// Method to LogOut
	public static void LogOut(WebDriver wd) throws Exception {
		IzletLogIn.clickLogOutButton(wd);
		if (wd.getCurrentUrl().equals(IzletHomePage.PAGE_URL)) {
			System.out.println("Log out was not successful.");
		} else
			System.out.println("Log out was successful.");
		
	}

	// Method to test LogIn and LogOut row by row, with all data from Excel file
	public static void testWithAllLogData(WebDriver wd) throws Exception {
		IzletExcelUtils.setExcelFile(IzletDataExcel.PATH + IzletDataExcel.FILE_NAME, IzletDataExcel.SHEET_NAME_1);
		for (int i = 1; i < IzletExcelUtils.getRowCount(IzletDataExcel.SHEET_NAME_1); i++) {
			fillLogInForm(wd, i);
			if (wd.getCurrentUrl().equals(IzletLogIn.LOG_IN_URL)) {
				IzletExcelUtils.setCellData(IzletDataExcel.SHEET_NAME_1, "Pass", i, 7); // test results written in Excel
				LogOut(wd);
			} else
				IzletExcelUtils.setCellData(IzletDataExcel.SHEET_NAME_1, "Fail", i, 7); // test results written in Excel
			wd.navigate().to(IzletHomePage.PAGE_URL);

		}

	}

}
