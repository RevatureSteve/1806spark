//package com.revature.part23;
//
//import java.io.IOException;
//import java.util.Scanner;
//
//public class Driver {
//	
//	public static void main(String[] args) {
//		
//		Scanner scan = new Scanner (System.in);
//		
//		
//		while(true) {
//			InventoryUtil.welcomeInventory(); //	we know welcomeMenu() is static because PresentationUtil is capital
//			int userInput = scan.nextInt();
//			System.out.println("User entered: " + userInput);
//			switch (userInput) {
//			case 1:
//				promptPlayerToUsePotionAndPersist();
//				break;
//			case 2:
//				getPotionUsageAndDisplay();
//				break;
//			case 3:
//				System.out.println("Exiting...");
//				System.exit(1);
//			}
//		}
//
//	}
//	
//	public static void promptPlayerToUsePotionAndPersist() {
//		//	1st prompt player and retrieve input
//		Potion stud = InventoryUtil.usingNewPotion();
//		
//		//	persist potion usage to file
//		try {
//			WeaponsDao.serializePotion(stud);
//		} catch (IOException e) {
//			InventoryUtil.errorView("File is corrupt");
//		}
//	}
//	
//	public static void getPotionUsageAndDisplay() {
//		//	retrieve student from StudentDAO (Data access object)
//		Potion p = WeaponsDao.deserializePotion();
//			//	Probably should of ducked the exceptions in the StudentDAO and handled them here with try/catch
//		
//		InventoryUtil.potionUsage(p);
//	}
//
//}
