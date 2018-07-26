package com.ex.store; // package name

import java.util.Scanner; // imports scanner 

public class MainMenuScreen implements Screen { // tells us that it uses the screen

	private Scanner scan = new Scanner(System.in); // Creating a new scanner 
	
	@Override
	public Screen start() { // once the screen starts
		System.out.println("Please choose from the following options:");// these things will print to the screen
		System.out.println(" 1 to view your pets");
		System.out.println("2 to view available pets");
		System.out.println("3 to view pet toys");
		String input = scan.nextLine();

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
	}

}
