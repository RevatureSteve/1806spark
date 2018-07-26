package com.screens.banking;

import java.util.Scanner;

import com.interfaces.banking.Screen;

public class BalanceOperationScreen implements Screen {

	private Scanner scan = new Scanner(System.in);
	@Override
	public Screen start() {
		System.out.println("Please select one of the choices");
		System.out.println("1 to deposit");
		System.out.println("2 to to withdraw");
		System.out.println("3 to main menu");
		String input = scan.nextLine();
		
		switch (input) {
		case "1":
			return new BalanceScreen();
		case "2":
			return new BalanceOperationScreen();
		case "3":
			return new MainMenuScreen();
		default:
			System.out.println("Not a recognized input");
		}
		return this;
	}

}
