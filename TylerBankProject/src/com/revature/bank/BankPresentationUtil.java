package com.revature.bank;

import java.util.Scanner;

public class BankPresentationUtil {
	
	
//	public static void userLogin() {
//		System.out.println("1 to Enter Username");
//		System.out.println("2 to Enter Password");
//		System.out.println("3 to Register");
//		System.out.println("4 to return to Main Menu");
//	}
//	
	public static String loginSwitch() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter Username: ");
		String userName = scan.nextLine();
		System.out.println("Enter Password");
		String userPass = scan.nextLine();
		
//		scan.close();
		
		return userName + userPass;
	}
	
//	public static void userAndPassword() {
//		sysoutSystem.out.println(userName + userPass);
//	}
	
	public static void mainMenu() {
		System.out.println("Enter 1 to Logout");
		System.out.println("Enter 2 View Balance");
		System.out.println("Enter 3 Deposit");
		System.out.println("Enter 4 Withdraw");

	}
	
	public static

}
