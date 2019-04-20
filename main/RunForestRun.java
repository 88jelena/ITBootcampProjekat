package main;

import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import webPage.tests.IzletEditAndDeleteTest;
import webPage.tests.IzletHomePageTest;
import webPage.tests.IzletLogInTest;
import webPage.tests.IzletPostTest;
import webPage.tests.IzletRegisterTest;

public class RunForestRun {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();

		System.out.println("Welcome to testing website Izlet using Selenium WebDriver");

		try {

			IzletHomePageTest.openHomePage(wd);

			System.out.println("If you want to enter registration and log in information by yourself, type 1");
			System.out.println("If you want data to be loaded from the Excel file, type 2 ");

			int a = sc.nextInt();
			switch (a) {
			case 1:
				IzletRegisterTest.testUserRegister(wd, sc);
				IzletLogInTest.LogOut(wd);
				break;
			case 2:
				IzletHomePageTest.testWithAllData(wd);
				break;
			default:
				System.out.println("You entered the wrong number");
			}
			
			 IzletRegisterTest.testRegForm(wd, 3); // register and log in 3rd person from excel file 
			 Thread.sleep(3000);
			 
			 IzletPostTest.newPost(wd, 17, "Bus");
			 IzletPostTest.newPost(wd, 48, "Motorbike"); 
			 IzletPostTest.multiplePosts(wd, "Motorbike"); // set several posts 
			 IzletEditAndDeleteTest.deletePost(wd, 2); // delete second post
			 IzletEditAndDeleteTest.deleteMultiplePosts(wd, 6); // delete 6 most recent posts 
			 IzletEditAndDeleteTest.userEditedPost(wd, sc, 0); // edit most recent post 
			 Thread.sleep(3000);
			 IzletLogInTest.LogOut(wd); //log out 3rd person
			 
			 
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			wd.quit();
			System.out.println("Thank you for attention. Testing is over.");
			System.out.println("Have a nice day!");
		}

	}

}
