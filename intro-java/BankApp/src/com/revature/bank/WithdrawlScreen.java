package com.revature.bank;

import java.util.Scanner;

public class WithdrawlScreen implements Screen, ViewBalanceScreen {
	private Scanner scan = new Scanner(System.in);

	@Override
	public Screen start() {
		while (true) {
			System.out.println("How much would you like to withdraw (no $ symbol please):");
			System.out.println("You currently have: $" + balance);
			System.out.println("x to cancle transaction.");
			String input = scan.nextLine();
			switch (input) {
			case "x":
				return new MainMenuScreen();
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
						return new MainMenuScreen();
					}
				}
				final double newBalance = balance - Double.parseDouble(input);
				System.out.println("$" + input + " has been withdrawn.");
				System.out.println("Your new balance is: $" + newBalance);
				return new MainMenuScreen();
			}
		}
	}
}
