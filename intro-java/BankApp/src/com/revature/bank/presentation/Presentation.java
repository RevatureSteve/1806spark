package com.revature.bank.presentation;

import java.util.Scanner;

import com.revature.bank.pojo.User;

public class Presentation {
	
	// scanner used to take user inpuSt
	private static Scanner scan = new Scanner(System.in);
	
	public static User login() {
		System.out.println("Username: ");
		String uname = scan.nextLine();
		System.out.println("Password: ");
		String pass = scan.nextLine();
		User u = new User(0, uname, pass);
		return u;
	}

	public static void UserMainMenu() {
		System.out.println("How may I help you?:");
		System.out.println("1 to view balance");
		System.out.println("2 to make a deposite");
		System.out.println("3 to make a withdrawl");
		String input = scan.nextLine();
	}

	public static void Deposit() {
		System.out.println("How much would you like to deposite (no $ symbol please):");
		System.out.println("x to cancle transaction.");
		String input = scan.nextLine();
		switch (input) {
		case "x":
			UserMainMenu();
		default:
			System.out.println("$" + input + " has been deposited.");
		}
	}
	/*
	public static void Withdrawl() {
		while (true) {
			System.out.println("How much would you like to withdraw (no $ symbol please):");
			System.out.println("You currently have: $" + balance);
			System.out.println("x to cancle transaction.");
			String input = scan.nextLine();
			switch (input) {
			case "x":
				UserMainMenu();
			default:
				if (Double.parseDouble(input) > balance) {
					System.out.println("Im sorry but you dont have that much. try again?");
					System.out.println("1 for yes");
					System.out.println("2 for no");
					String again = scan.nextLine();
					switch (again) {
					case "1":
						continue;
					case "2":
						UserMainMenu();
					}
				}
				final double newBalance = balance - Double.parseDouble(input);
				System.out.println("$" + input + " has been withdrawn.");
				System.out.println("Your new balance is: $" + newBalance);
				UserMainMenu();
			}
		}
	}
	public interface ViewBalanceScreen{
		public double balance = 785.50;
	}*/
}