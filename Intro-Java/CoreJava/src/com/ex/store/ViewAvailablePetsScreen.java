package com.ex.store;

import java.util.Scanner;

public class ViewAvailablePetsScreen implements Screen{
	private Scanner scan = new Scanner(System.in);
	@Override
	public Screen start() {
		// TODO Auto-generated method stub
		System.out.println("Enter 3 to go back to main menu");
		String input = scan.nextLine();

		switch (input) {
		case "1":
			System.out.println("feature not yet implemented");
			break;

		default:
			break;

		case "2":
			System.out.println("feature not yet implemented");

			break;

		case "3":
			return new MainMenuScreen();

		}

// TODO Auto-generated method stub
		return this;
	}

}


