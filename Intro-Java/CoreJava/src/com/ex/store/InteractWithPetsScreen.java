package com.ex.store;

import java.util.Scanner;

public class InteractWithPetsScreen implements Screen {
<<<<<<< HEAD
	
	private Scanner scan = new Scanner(System.in);
	
	@Override
	public Screen start() {
		
		System.out.println("Please choose from the following options:");
		System.out.println("1 to interact with your pets");
		System.out.println("2 to view available pets");
		System.out.println("3 to go back to main menu");
		String input = scan.nextLine();
		
=======
	private Scanner scan = new Scanner(System.in);

	@Override
	public Screen start() {
		System.out.println("Please choose from the following options:");
		System.out.println("1 to speak with your pets");
		System.out.println("2 to play with pets");
		System.out.println("3 to go back to main menu");
		String input = scan.nextLine();

>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
		switch (input) {
		case "1":
			System.out.println("feature not yet implemented");
			break;
		case "2":
			System.out.println("feature not yet implemented");
			break;
<<<<<<< HEAD
		case "3":
			return new MainMenuScreen();
		}
		
		return this;
		
=======

		case "3":
			return new MainMenuScreen();
		}

		return this;
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
	}

}
