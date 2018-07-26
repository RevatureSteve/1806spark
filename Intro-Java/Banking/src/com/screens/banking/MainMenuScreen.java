package com.screens.banking;

import java.util.Scanner;

import com.interfaces.banking.Screen;

public class MainMenuScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	
	public MainMenuScreen() {
		
	}

	@Override
	public Screen start() {
		System.out.println("Welcome");
		
		System.out.println("Please select one of the choices");
		System.out.println("1 to view balance");
		System.out.println("2 to deposit or withdraw money");
		System.out.println("3 to log out");
		String input = scan.nextLine();
		
		switch (input) {
		case "1":
			return new BalanceScreen();
		case "2":
			return new BalanceOperationScreen();
		case "3":
			return new LoginScreen();
		default:
			System.out.println("Not a recognized input");
		}
		
		
		return this;
	}

}
