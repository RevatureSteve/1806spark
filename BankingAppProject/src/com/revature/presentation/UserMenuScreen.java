package com.revature.presentation;

import java.util.Scanner;

import com.revature.Driver;
import com.revature.Screen;

public class UserMenuScreen implements Screen {

	@Override
	public Screen start() {
		Scanner scan = new Scanner(System.in);
		System.out.println("What would you like to do?");
		System.out.println("Enter 1 to view your balance");
		System.out.println("Enter 2 to make a deposit");
		System.out.println("Enter 3 to withdraw");
		System.out.println("Enter 4 to view transaction history");
		System.out.println("Enter 5 to logout");
		String choice = scan.nextLine();
		
		switch (choice) {
		case "1":
			return new ViewBalanceScreen();
		case "2":
			return new DepositScreen();
		case "3":
			return new WithdrawScreen();
		case "4":
			System.out.println("View transaction history is not implemented yet");
			return this;
		case "5":
			System.out.println("Goodbye!");
			System.exit(1);
		default:
			System.out.println("Invalid input.  Please try again.");
		}
		return this;
	}

}
