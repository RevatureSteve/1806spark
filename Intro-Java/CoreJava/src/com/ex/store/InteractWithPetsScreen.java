package com.ex.store;

import java.util.Scanner;

<<<<<<< HEAD
public class InteractWithPetsScreen implements Screen{

	private Scanner scan = new Scanner(System.in);
	
=======
public class InteractWithPetsScreen implements Screen {
	private Scanner scan = new Scanner(System.in);

>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
	@Override
	public Screen start() {
		System.out.println("Please choose from the following options:");
		System.out.println("1 to speak with your pets");
		System.out.println("2 to play with pets");
		System.out.println("3 to go back to main menu");
		String input = scan.nextLine();

		switch (input) {
		case "1":
			System.out.println("feature not yet implemented");
			break;
		case "2":
<<<<<<< HEAD
			System.out.println("feture not yet implemented");
			break;
		case "3":
			return new MainMenuScreen();
//		default:
//			break;
=======
			System.out.println("feature not yet implemented");
			break;

		case "3":
			return new MainMenuScreen();
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
		}

		return this;
	}
<<<<<<< HEAD
	
=======

>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
}
