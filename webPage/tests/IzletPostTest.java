package webPage.tests;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import utility.*;
import webPage.objects.IzletPost;

public class IzletPostTest {

	// Method to post through console (via Scanner) by user
	public static void userNewPost(WebDriver wd, Scanner sc) throws Exception {

		// New Post Button
		IzletPost.clickNewPost(wd);

		// Title
		System.out.println("Post Title:");
		IzletPost.clickPostTitle(wd);
		IzletPost.sendKeysPostTitle(wd, sc.nextLine());

		// Location
		System.out.println("Location");
		IzletPost.clickLocation(wd);
		IzletPost.sendKeysLocation(wd, sc.nextLine());
		
		// Image

		IzletPost.sendKeysImage(wd);

		// Transport
		System.out.println("Choose transport by typing one:");
		System.out.println("Walk, Car, Motorbike, Bicycle or Bus");
		IzletPost.selectTransport(wd, sc.nextLine());

		// Description
		System.out.println("Post Description");
		IzletPost.clickDescription(wd);
		IzletPost.sendKeysDescription(wd, sc.nextLine());

		// Submit
		IzletPost.clickPostButton(wd);
	}

	// Method to post using data from Excel file
	public static void newPost(WebDriver wd, int i, String str) throws Exception {

		String data;
		
		//Setting Excel file
		IzletExcelUtils.setExcelFile(IzletDataExcel.PATH + IzletDataExcel.FILE_NAME, IzletDataExcel.SHEET_NAME_2);

		// New Post Button
		IzletPost.clickNewPost(wd);

		// Title
		IzletPost.clickPostTitle(wd);
		data = IzletExcelUtils.getCellData(i, 1);
		IzletPost.sendKeysPostTitle(wd, data);

		// Location
		IzletPost.clickLocation(wd);
		data = IzletExcelUtils.getCellData(i, 2);
		IzletPost.sendKeysLocation(wd, data);

		// Image
		IzletPost.sendKeysImage(wd);

		// Transport
		IzletPost.selectTransport(wd, str);

		// Description
		IzletPost.clickDescription(wd);
		data = IzletExcelUtils.getCellData(i, 0);
		IzletPost.sendKeysDescription(wd, data);

		// Submit
		IzletPost.clickPostButton(wd);
		if (wd.getCurrentUrl().equals(IzletPost.POST_URL)) {
			System.out.println("Posting was successful.");
		} else
			System.out.println("Posting was not successful.");
		}

	// Method to post more than one post using data from Excel file
	public static void multiplePosts(WebDriver wd, String str) throws Exception {

		// Setting Excel file
		IzletExcelUtils.setExcelFile(IzletDataExcel.PATH +IzletDataExcel.FILE_NAME, IzletDataExcel.SHEET_NAME_2);

		// for all data from file
		// for (int i = 1; i < ExcelUtils.getRowCount(DataExcelIzlet.SHEET_NAME_2); i++){

		for (int i = 1; i < 10; i++) {
			newPost(wd, i, str);
		}
		
		if (wd.getCurrentUrl().equals(IzletPost.POST_URL)) {
			System.out.println("Posts are successfully set.");
		} else
			System.out.println("Posts are not set.");
	}

}
