package com.ex.store;

import java.util.Scanner;

public class MainMenuScreen implements Screen {
<<<<<<< HEAD
	private Scanner scan = new Scanner(System.in);
	
	@Override
	public Screen start() {
		System.out.println("Please choose from the following options:");
		System.out.println("1 to view your pets");
		System.out.println("2 to view your available pets");
		System.out.println("3 to view your pet toys");
		String input = scan.nextLine();
		
=======
	// Scanner is used to take in user input
	private Scanner scan = new Scanner(System.in);

	@Override
	public Screen start() {
		System.out.println("Please choose from the following options:");
		System.out.println("1 to interact with your pets");
		System.out.println("2 to view available pets");
		System.out.println("3 to view pet toys");
		String input = scan.nextLine();

>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
		switch (input) {
		case "1":
			return new InteractWithPetsScreen();
		case "2":
<<<<<<< HEAD
			return new InteractWithPetsScreen();
=======
			return new ViewAvailablePetsScreen();

>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
		case "3":
			System.out.println("feature not yet implemented");
			break;
		}
<<<<<<< HEAD
		
=======

>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
		return this;
	}

}
