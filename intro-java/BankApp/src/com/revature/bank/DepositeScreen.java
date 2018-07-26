package com.revature.bank;

import java.util.Scanner;

public class DepositeScreen implements Screen {
	private Scanner scan = new Scanner(System.in);

	@Override
	public Screen start() {
		System.out.println("How much would you like to deposite (no $ symbol please):");
		System.out.println("x to cancle transaction.");
		String input = scan.nextLine();
		switch (input) {
		case "x":
			return new MainMenuScreen();
		default:
			System.out.println("$" + input + " has been deposited.");
			return new MainMenuScreen();
		}
	}
}
