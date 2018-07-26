package com.ex.store;  // folder name (package name)

import java.util.Scanner; //Imports scanner which is being used to read user input

public class InteractWithPetsScreen implements Screen { 
	private Scanner scan = new Scanner(System.in); // making a new scanner (actually reads the input) 

	@Override
	public Screen start() { //Uses interface "Screen" 
		//Method found in the interface, must have method in this class
		
		System.out.println("Chose an option:"); // text that it will print out
		System.out.println("Enter 1 to play with pets");//text
		System.out.println("Enter 3 to return to main menu");//text
		String input = scan.nextLine();// taking the input and saving it to the variable "input"

		switch (input) { 
		case "1": // if you press 1 then this will happen 
			System.out.println("feature not yet implemented");
			break;



		case "2": // press 2 and get this text
			System.out.println("feature not yet implemented");

			break;

		case "3": // press 3 and get the MainMenuScreen
			return new MainMenuScreen();
		}


		return this; //keeps us on the same page
	}

}
