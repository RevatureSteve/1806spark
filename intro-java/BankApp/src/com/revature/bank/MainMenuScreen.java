package com.revature.bank;

import java.util.Scanner;

public class MainMenuScreen implements Screen {
	// scanner used to take user input
	private Scanner scan = new Scanner(System.in);

	@Override
	public Screen start() {
		System.out.println("How may I help you?:");
		System.out.println("1 to view balance");
		System.out.println("2 to make a deposite");
		System.out.println("3 to make a withdrawl");
		String input = scan.nextLine();

		switch (input) {
		case "1":
			System.out.println("feature not yet implemented");
			break;
		case "2":
			return new DepositeScreen();
		case "3":
			return new WithdrawlScreen();
		}

		return this;
	}

}