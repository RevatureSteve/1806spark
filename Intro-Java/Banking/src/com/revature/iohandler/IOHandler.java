package com.revature.iohandler;

import java.util.Scanner;

import com.revature.information.LoggedUser;

public class IOHandler {
	public static void getLogin() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please provide login");
		LoggedUser.setUsername(scan.nextLine());
		
	}
	public static void getPassword() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please provide password");
		LoggedUser.setPassword(scan.nextLine());
	}
	
	public static void displayBalanceScreen(int balance) {
		System.out.println("Your current balance is: $" + balance);
		System.out.println("Please select one of the choices");
		System.out.println("1 to main menu");
		System.out.println("2 to deposit or withdraw money");
		System.out.println("3 to log out");
	}
	
	public static void displayMainMenuScreen() {
		System.out.println("Welcome");
		System.out.println("Please select one of the choices");
		System.out.println("1 to view balance");
		System.out.println("2 to deposit or withdraw money");
		System.out.println("3 to log out");
	}
	
	public static void displayBalanceOperationScreen() {
		System.out.println("Please select one of the choices");
		System.out.println("1 to deposit");
		System.out.println("2 to to withdraw");
		System.out.println("3 to main menu");

	}
}
