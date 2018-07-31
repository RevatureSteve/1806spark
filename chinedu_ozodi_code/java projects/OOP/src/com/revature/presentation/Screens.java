package com.revature.presentation;

import java.io.IOException;
import java.util.Scanner;

import com.revature.dao.LabelDao;
import com.revature.labels.LabelA;
import com.revature.labels.LabelC;
import com.revature.threads.SaveFilesThread;

public class Screens {

	public static void mainMenu() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Hello, please select from the list below:");
		System.out.println("1. Create new Label");
		System.out.println("2. Read current Label");
		System.out.println("3. Exit");
		int userInput = scan.nextInt();

		switch (userInput) {
		case 1:
			promptUserForNewLabelAndPersist();
//			scan.close();
			break;
		case 2:
			getLabelAndDisplay();
//			scan.close();
			break;
		case 3:
			System.out.println("Exiting...");
			scan.close();
			System.exit(1);
			break;
		}
	}

	private static void getLabelAndDisplay() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Your Label Options:");
		System.out.println("1. Display object");
		System.out.println("2. Display object string");
		System.out.println("3. Main Menu");
		int userInput = scan.nextInt();
		
		switch (userInput) {
		case 1:
			LabelA label;
			try {
				label = LabelDao.loadLabel();
				System.out.println(label);
			} catch (ClassNotFoundException | IOException e1) {
				System.out.println("Could not load object");
				e1.printStackTrace();
			}
			mainMenu();
			break;
		case 2:
			try {
				System.out.println(LabelDao.loadLabelBuffer());
			} catch (IOException e) {
				System.out.println("Could not read file");
				e.printStackTrace();
			}
			mainMenu();
			break;
		case 3:
			System.out.println("Back to Main Menu");
			mainMenu();
			break;
		}
		
		
	}

	private static void promptUserForNewLabelAndPersist() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Create New Label");
		System.out.println("Enter label string:");
		String labelString = scan.nextLine();
		System.out.println("Enter label int:");
		int labelInt = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter another label int:");
		int labelInt2 = scan.nextInt();
		scan.nextLine();
		System.out.println("Almost there, enter another string:");
		String labelString2 = scan.nextLine();
//		int extraInt = scan.nextInt();
		System.out.println("Great! Saving...");

		LabelC label = new LabelC(labelInt, labelString, labelInt2, labelString2);
		
		SaveFilesThread saveThread = new SaveFilesThread(label);
		
		(new Thread(saveThread)).start();
		
		mainMenu();

	}
}
