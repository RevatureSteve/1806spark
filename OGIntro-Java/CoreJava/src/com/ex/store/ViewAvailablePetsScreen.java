package com.ex.store;

import java.util.Scanner;

<<<<<<< HEAD
public class ViewAvailablePetsScreen implements Screen{
	private Scanner scan = new Scanner(System.in);
	@Override
	public Screen start() {
		// TODO Auto-generated method stub
		System.out.println("Enter 3 to go back to main menu");
=======
public class ViewAvailablePetsScreen implements Screen {
	private Scanner scan = new Scanner(System.in);

	@Override
	public Screen start() {
		// this list of pets would like be pulled from a database not be hard coded
		System.out.println("Here are the available pets, sparky the dog, pebbles the fish");
		System.out.println("Please choose from the following options:");
		System.out.println("1 to adopt one of the pets");
		System.out.println("2 to play with pets");
		System.out.println("3 to go back to main menu");
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
		String input = scan.nextLine();

		switch (input) {
		case "1":
			System.out.println("feature not yet implemented");
			break;
<<<<<<< HEAD

		default:
			break;

		case "2":
			System.out.println("feature not yet implemented");

			break;

		case "3":
			return new MainMenuScreen();

		}

// TODO Auto-generated method stub
		return this;
	}

}


=======
		case "2":
			System.out.println("feature not yet implemented");
			break;
		case "3":
			return new MainMenuScreen();
		}

		return this;
	}
}
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
