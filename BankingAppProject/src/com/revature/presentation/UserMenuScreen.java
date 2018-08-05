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
		System.out.println("Enter 4 to logout");
		String choice = scan.nextLine();
		
		switch (choice) {
		case "1":
			System.out.println("This is for the viewing balance menu");
			return new ViewBalanceScreen();
		case "2":
			System.out.println("This is for making a deposit");
			return new DepositScreen();
		case "3":
			System.out.println("This is for widthdrawing");
			return new WithdrawScreen();
		case "4":
			System.out.println("Goodbye!");
			System.exit(1);
		}
		return this;
	}

}
