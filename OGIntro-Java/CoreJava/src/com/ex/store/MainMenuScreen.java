<<<<<<< HEAD
package com.ex.store; // package name

import java.util.Scanner; // imports scanner 

public class MainMenuScreen implements Screen { // tells us that it uses the screen

	private Scanner scan = new Scanner(System.in); // Creating a new scanner 
	
	@Override
	public Screen start() { // once the screen starts
		System.out.println("Please choose from the following options:");// these things will print to the screen
		System.out.println(" 1 to view your pets");
=======
package com.ex.store;

import java.util.Scanner;

public class MainMenuScreen implements Screen {
	// Scanner is used to take in user input
	private Scanner scan = new Scanner(System.in);

	@Override
	public Screen start() {
		System.out.println("Please choose from the following options:");
		System.out.println("1 to interact with your pets");
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
		System.out.println("2 to view available pets");
		System.out.println("3 to view pet toys");
		String input = scan.nextLine();

<<<<<<< HEAD
		switch (input) { // 1 will take us to InteractWithPetsScreen
		case "1":
			return new InteractWithPetsScreen();
			

		default:
			break;

		case "2": // 2 will take us to ViewAvailablePetsScreen
			return new ViewAvailablePetsScreen();

		case "3": 

			break;

		}

		
		return this; // keeps us on the same page
=======
		switch (input) {
		case "1":
			return new InteractWithPetsScreen();
		case "2":
			return new ViewAvailablePetsScreen();

		case "3":
			System.out.println("feature not yet implemented");
			break;
		}

		return this;
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
	}

}
