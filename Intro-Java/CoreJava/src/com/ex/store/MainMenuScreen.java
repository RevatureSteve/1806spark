package com.ex.store;

import java.util.Scanner;

public class MainMenuScreen implements Screen {
<<<<<<< HEAD
	private Scanner scan = new Scanner(System.in);

	public MainMenuScreen() {

	}

	@Override
	public Screen start() {
		System.out.println("Please choose from the following options");
=======
	// Scanner is used to take in user input
	private Scanner scan = new Scanner(System.in);

	@Override
	public Screen start() {
		System.out.println("Please choose from the following options:");
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
		System.out.println("1 to interact with your pets");
		System.out.println("2 to view available pets");
		System.out.println("3 to view pet toys");
		String input = scan.nextLine();

		switch (input) {
		case "1":
			return new InteractWithPetsScreen();
<<<<<<< HEAD

		case "2":
			return new ViewAvailablePetsScreen();
		case "3":
			System.out.println("Not yet ready");
			break;

		}
=======
		case "2":
			return new ViewAvailablePetsScreen();

		case "3":
			System.out.println("feature not yet implemented");
			break;
		}

>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
		return this;
	}

}
