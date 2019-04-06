package webPage.tests;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import utility.IzletDataExcel;
import utility.IzletExcelUtils;
import webPage.objects.IzletEditAndDelete;
import webPage.objects.IzletPost;

public class IzletEditAndDeleteTest {

	// Method to edit post through console (via Scanner) by user
	// 'n' stands for the post no.on the list
	public static void userEditedPost(WebDriver wd, Scanner sc, int n) throws Exception {

		// Edit Post Button
		IzletEditAndDelete.clickEdit(wd, n);
		Thread.sleep(6000);

		// Title
		System.out.println("Enter new Post Title:");
		IzletEditAndDelete.clickEPostTitle(wd);
		IzletEditAndDelete.sendKeysEPostTitle(wd, sc.nextLine());

		// Location
		System.out.println("Enter new Location:");
		IzletEditAndDelete.clickELocation(wd);
		IzletEditAndDelete.sendKeysELocation(wd, sc.nextLine());

		// Image

		IzletEditAndDelete.sendKeysEImage(wd);

		// Transport
		System.out.println("Choose transport by typing one:");
		System.out.println("Walk, Car, Motorbike, Bicycle or Bus");
		IzletEditAndDelete.selectETransport(wd, sc.nextLine());

		// Description
		System.out.println("Enter new Post Description:");
		IzletEditAndDelete.clickEDescription(wd);
		IzletEditAndDelete.sendKeysEDescription(wd, sc.nextLine());

		// Submit
		IzletEditAndDelete.clickEPostButton(wd);

		if (wd.getCurrentUrl().equals(IzletPost.POST_URL)) {
			System.out.println("Post editing was successful.");
		} else
			System.out.println("Post editing was not successful.");
	}

	// Method to edit post using data from Excel file
	// 'n' stands for the post no. on the list
	public static void editedPost(WebDriver wd, int i, String str, int n) throws Exception {

		String data;

		// Setting Excel file
		IzletExcelUtils.setExcelFile(IzletDataExcel.PATH + IzletDataExcel.FILE_NAME, IzletDataExcel.SHEET_NAME_2);

		// Edit Post Button
		IzletEditAndDelete.clickEdit(wd, n);

		// Title
		IzletEditAndDelete.clickEPostTitle(wd);
		data = IzletExcelUtils.getCellData(i, 1);
		IzletEditAndDelete.sendKeysEPostTitle(wd, data);

		// Location
		IzletEditAndDelete.clickELocation(wd);
		data = IzletExcelUtils.getCellData(i, 2);
		IzletEditAndDelete.sendKeysELocation(wd, data);

		// Image
		IzletEditAndDelete.sendKeysEImage(wd);

		// Transport
		IzletEditAndDelete.selectETransport(wd, str);

		// Description
		IzletEditAndDelete.clickEDescription(wd);
		data = IzletExcelUtils.getCellData(i, 0);
		IzletEditAndDelete.sendKeysEDescription(wd, data);

		// Submit
		IzletEditAndDelete.clickEPostButton(wd);
		if (wd.getCurrentUrl().equals(IzletPost.POST_URL)) {
			System.out.println("Post editing was successful.");
		} else
			System.out.println("Post editing was not successful.");
	}

	// Method to delete single post
	// 'n' stands for the post no.on the list
	public static void deletePost(WebDriver wd, int n) throws Exception {
		IzletEditAndDelete.clickDelete(wd, n);
		if (wd.getCurrentUrl().equals(IzletPost.POST_URL)) {
			System.out.println("Post is deleted.");
		} else
			System.out.println("Post is not deleted.");
	}

	// Method to delete multiple posts
	// 'n' stands for the no. of posts wanted to delete
	// deleting most recent posts
	public static void deleteMultiplePosts(WebDriver wd, int n) throws Exception {
		for (int i = 0, j = 0; j < n; j++) { // i stands for the first most (most recent)
												// when last post is deleted, next one becomes first one
			deletePost(wd, i + 1);
		}
		if (wd.getCurrentUrl().equals(IzletPost.POST_URL)) {
			System.out.println("Posts are deleted.");
		} else
			System.out.println("Posts are not deleted.");
	}

}
