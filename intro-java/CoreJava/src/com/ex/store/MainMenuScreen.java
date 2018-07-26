package com.ex.store;

import java.util.Scanner;

public class MainMenuScreen implements Screen {
	// Scanner is used to take in user input
	private Scanner scan = new Scanner(System.in);

	@Override
	public Screen start() {
		System.out.println("please choose from the following options: ");
		System.out.println("1 to interact with your pets");
		System.out.println("2 to view available pets");
		System.out.println("3 to view pet toys");
		String input = scan.nextLine();

		switch (input) {
		case "1":
			return new InteractWithpetsScreen();
		case "2":
		     return new ViewAvailablepetsScreen();
		case "3":
			System.out.println("feature not yet implemented");
			break;

		}

		return this;
	}

}
