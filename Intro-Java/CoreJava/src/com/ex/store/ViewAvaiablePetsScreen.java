package com.ex.store;

import java.util.Scanner;

public class ViewAvaiablePetsScreen implements Screen{
	private Scanner scan = new Scanner(System.in);

	@Override
	public Screen start() {
		//this list should be pulled from a list of pets and not hard coded
		System.out.println("Here are the avaiable pets:, sparky the dog, pebbles the fish, and Johnson the cat");
		System.out.println("Please choose from the following options: ");
		System.out.println("1 to adopt a pet");
		System.out.println("2 to play with the pets");
		System.out.println("3 to go back to the main menu");
		String input = scan.nextLine();

		switch (input) {
		case "1":
			System.out.println("Feature is not yet implemented");

		case "2":
			System.out.println("Feature is not yet implemented");
			break;
		case "3":
			return new MainMenuScreen();
			
		}
		return this;// this returns current screen
	}

}
