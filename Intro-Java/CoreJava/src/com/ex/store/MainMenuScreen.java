package com.ex.store;

import java.util.Scanner;

public class MainMenuScreen implements Screen {
<<<<<<< HEAD
=======
	// Scanner is used to take in user input
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
	private Scanner scan = new Scanner(System.in);

	@Override
	public Screen start() {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		System.out.println("please chose from the following options");
		System.out.println("1 to interact w/ your pets");
=======
		System.out.println("Please choose from the following options:");
		System.out.println("1 to interact with your pets");
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
		System.out.println("2 to view available pets");
		System.out.println("3 to view pet toys");
		String input = scan.nextLine();

		switch (input) {
		case "1":
<<<<<<< HEAD
			return new InteractWithPetScreen();
		case "2":
			return new ViewAvailablePetsScreen();
=======
			return new InteractWithPetsScreen();
		case "2":
			return new ViewAvailablePetsScreen();

>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
		case "3":
			System.out.println("feature not yet implemented");
			break;
		}

		return this;
	}

}
