package com.ex.store;

import java.util.Scanner;

public class MainMenuScreen implements Screen {
<<<<<<< HEAD

	private Scanner scan = new Scanner(System.in); // scanner is used to take in user input
=======
	// Scanner is used to take in user input
	private Scanner scan = new Scanner(System.in);
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e

	@Override
	public Screen start() {
		System.out.println("Please choose from the following options:");
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
			System.out.println("feature not yet implemented");
			break;


=======
		case "2":
			return new ViewAvailablePetsScreen();

		case "3":
			System.out.println("feature not yet implemented");
			break;
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
		}

		return this;
	}

}
