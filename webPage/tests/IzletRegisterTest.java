package webPage.tests;

import java.util.Scanner; 

import org.openqa.selenium.WebDriver;

import utility.*;
import webPage.objects.IzletLogIn;
import webPage.objects.IzletRegister;

public class IzletRegisterTest {

	/// Method to fill in Registration form through console (via Scanner) by user
	public static void userRegister(WebDriver wd, Scanner sc) throws Exception {
		System.out.println("Sign up by entering your:");
		sc.nextLine();

		// First name
		System.out.println("First Name");
		IzletRegister.clickFirstName(wd);
		IzletRegister.sendKeysFirstName(wd, sc.nextLine());

		// Last name
		System.out.println("Last Name");
		IzletRegister.clickLastName(wd);
		IzletRegister.sendKeysLastName(wd, sc.nextLine());

		// Username
		System.out.println("Username");
		IzletRegister.clickUsername(wd);
		IzletRegister.sendKeysUsername(wd, sc.nextLine());

		// Email
		System.out.println("Email");
		IzletRegister.clickEmail(wd);
		IzletRegister.sendKeysEmail(wd, sc.nextLine());

		// Pass
		System.out.println("Password");
		IzletRegister.clickPassword(wd);
		IzletRegister.sendKeysPassword(wd, sc.nextLine());

		// Submit
		IzletRegister.clickRegisterButton(wd);
	}

	public static void testUserRegister(WebDriver wd, Scanner sc) throws Exception {
		userRegister(wd, sc);
		IzletLogInTest.userLogIn(wd, sc);

		if (wd.getCurrentUrl().equals(IzletLogIn.LOG_IN_URL)) {
			System.out.println("Registration was successful.");
		} else
			System.out.println("Registration was not successful.");

	}

	// Method to fill in Registration form using data from Excel file
	public static void fillRegForm(WebDriver wd, int i) throws Exception {

		String data;
		IzletExcelUtils.setExcelFile(IzletDataExcel.PATH + IzletDataExcel.FILE_NAME, IzletDataExcel.SHEET_NAME_1);

		// First name
		IzletRegister.clickFirstName(wd);
		data = IzletExcelUtils.getCellData(i, 0);
		IzletRegister.sendKeysFirstName(wd, data);

		// LastName
		IzletRegister.clickLastName(wd);
		data = IzletExcelUtils.getCellData(i, 1);
		IzletRegister.sendKeysLastName(wd, data);

		// Username
		IzletRegister.clickUsername(wd);
		data = IzletExcelUtils.getCellData(i, 2);
		IzletRegister.sendKeysUsername(wd, data);

		// Email
		IzletRegister.clickEmail(wd);
		data = IzletExcelUtils.getCellData(i, 3);
		IzletRegister.sendKeysEmail(wd, data);

		// Password
		IzletRegister.clickPassword(wd);
		data = IzletExcelUtils.getCellData(i, 4);
		IzletRegister.sendKeysPassword(wd, data);

		// Submit
		IzletRegister.clickRegisterButton(wd);

	}

	// Method to test Registration form row by row, with all data from Excel file
	public static void testRegForm(WebDriver wd, int i) throws Exception {

		fillRegForm(wd, i);
		IzletLogInTest.testLogInForm(wd, i);

		IzletExcelUtils.setCellData(IzletDataExcel.SHEET_NAME_1, "RegStatus", 0, 6); // naming column for reg test
		// results
		if (wd.getCurrentUrl().equals(IzletLogIn.LOG_IN_URL)) {
			System.out.println("Registration was successful.");
			IzletExcelUtils.setCellData(IzletDataExcel.SHEET_NAME_1, "Pass", i, 6); // test results written in Excel
		} else {
			System.out.println("Registration was not successful.");
			IzletExcelUtils.setCellData(IzletDataExcel.SHEET_NAME_1, "Fail", i, 6); // test results written in Excel
		}

	}

}
