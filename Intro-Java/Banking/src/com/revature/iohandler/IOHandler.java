package com.revature.iohandler;

import java.util.Scanner;

import com.revature.singletons.LoggedUser;

public class IOHandler {
	public static void getUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please provide login");
		String username = scan.nextLine();
		System.out.println("Please provide password");
		String password = scan.nextLine();
		int userId = 1; 							//Marcin pls remember to change this shitty code
		LoggedUser.createUser(username, password, userId);
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

	public static void displayDepositScreen() {
		System.out.println("Select the amount of money to deposit: ");
	}
	
	public static void displayWithdrawScreen() {
		System.out.println("Select the amount of money to withdraw: ");
	}
	
	public static int getAmountOfMoney() {
		Scanner scan = new Scanner(System.in);
		int money = scan.nextInt();
		return money;
	}
}
