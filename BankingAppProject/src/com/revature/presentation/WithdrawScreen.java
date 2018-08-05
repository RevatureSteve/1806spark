package com.revature.presentation;

import java.util.Scanner;

import com.revature.Screen;

public class WithdrawScreen implements Screen{

	@Override
	public Screen start() {
		Scanner scan = new Scanner(System.in);
		System.out.println("How much would you like to withdraw?");
		int amount = scan.nextInt();
		System.out.println(amount);
		// code to talk to the bus logic to check if they're over drafting
		// or if the amount is valid
		System.out.println("withdraw successful!"); // This would be printed out in the business logic
		
		System.out.println("\n\nWhat would you like to do?");
		System.out.println("Enter 1 to view balance");
		System.out.println("Enter 2 to make a deposit");
		System.out.println("Enter 3 to withdraw");
		System.out.println("Enter 4 to view transaction history");
		System.out.println("Enter 5 to exit");
		String choice = scan.nextLine();
		
		switch (choice) {
		case "1":
			System.out.println("Viewing balance");
			return new ViewBalanceScreen();
		case "2":
			System.out.println("Makes a deposit");
			return new DepositScreen();
		case "3":
			System.out.println("Make a withdraw");
			return new WithdrawScreen();
		case "4":
			System.out.println("Viewing transaction history");
			System.out.println("This function does not work yet... returning you to the main menu");
			return new UserMenuScreen();			
		case "5":
			System.out.println("Thank you! Have a nice day!");
			System.exit(1);
		}
		
		
		return this;
	}

}
