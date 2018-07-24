package com.ex.store;

import java.util.Scanner;

public class ViewAvailablePetsScreen implements Screen {
	private Scanner scan = new Scanner(System.in);

	@Override
	public Screen start() {
		// TODO Auto-generated method stub
		//this list of pets is from a DB, not hard coded
		System.out.println("here are the available pets, sparky the dog, pebbles the fish");
		System.out.println("please chose from the following options");
		System.out.println("1 to adopt a pet");
		System.out.println("2 to play w/ your pets");
		System.out.println("3 to goto main menu");
		String input = scan.nextLine();

		switch (input) {
		case "1":
			System.out.println("feature not yet implemented");
			break;

		case "2":
			System.out.println("feature not yet implemented");
			break;

		case "3":
			return new MainMenuScreen();
		}
		
		return this;
	}

}
