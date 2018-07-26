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
		System.out.println("Please choose from the following options:");
		System.out.println("1 to interact with your pets");
		System.out.println("2 to view available pets");
		System.out.println("3 to view pet toys");
		String input = scan.nextLine();

		switch (input) {
<<<<<<< HEAD

		case "1":
			return new interactWithPetsScreen();
			
		case "2":
			return new viewAvailablePets();

		case "3":
			System.out.println("Feature not yet implemented.");
			break;
		}

		// TODO Auto-generated method stub
=======
		case "1":
			return new InteractWithPetsScreen();
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
