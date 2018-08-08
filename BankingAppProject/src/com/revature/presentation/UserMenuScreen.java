package com.revature.presentation;

import java.util.Scanner;

import com.revature.ConsoleColors;
import com.revature.Driver;
import com.revature.Screen;
import com.revature.bl.BusinessLogic;

public class UserMenuScreen implements Screen {

	@Override
	public Screen start() {
		BusinessLogic.getUserIdByUsername();
		Scanner scan = new Scanner(System.in);
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"What would you like to do?" + ConsoleColors.RESET);
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"Enter 1 to view your balance"+ ConsoleColors.RESET);
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"Enter 2 to make a deposit"+ ConsoleColors.RESET);
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"Enter 3 to withdraw"+ ConsoleColors.RESET);
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"Enter 4 to view transaction history"+ ConsoleColors.RESET);
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"Enter 5 to logout"+ ConsoleColors.RESET);
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"Enter 6 to logout and exit"+ ConsoleColors.RESET);
		String choice = "";
		try {
		choice = scan.nextLine();
		} catch (RuntimeException e) {
			System.err.println("Invalid input please try again");
			return this;
		}
		switch (choice) {
		case "1":
			return new ViewBalanceScreen();
		case "2":
			return new DepositScreen();
		case "3":
			return new WithdrawScreen();
		case "4":
			return new ViewTransactionHistory();
		case "5":
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"You have logged out successfully!"+ ConsoleColors.RESET);
			return new MainMenuScreen();
		case "6":
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"Thanks for stopping by! Live long and prosper!"+ ConsoleColors.RESET);
			System.exit(1);
		default:
			System.out.println("Invalid input.  Please try again.");
		}
		return this;
	}

}
