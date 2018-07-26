package com.ex.store;

import java.util.Scanner;

<<<<<<< HEAD
public class ViewAvailablePetsScreen implements Screen{

	private Scanner scan = new Scanner(System.in);
	
	@Override
	public Screen start() {
		// this list of pets would likely be pulled from a database and not hard coded
		System.out.println("Here are the available pets. sparky the dog, pebbles the fish");
=======
public class ViewAvailablePetsScreen implements Screen {
	private Scanner scan = new Scanner(System.in);

	@Override
	public Screen start() {
		// this list of pets would like be pulled from a database not be hard coded
		System.out.println("Here are the available pets, sparky the dog, pebbles the fish");
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
		System.out.println("Please choose from the following options:");
		System.out.println("1 to adopt one of the pets");
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
}
