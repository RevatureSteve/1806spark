package com.ex.store;

import java.util.Scanner;

public class MainMenuScreen implements Screen {
	private Scanner scan = new Scanner(System.in);//this takes in input

	@Override
	public Screen start() {

		System.out.println("Please choose from the following options: ");
		System.out.println("1 to interact with your pets");
		System.out.println("2 to view available pets");
		System.out.println("3 to view pet toys");
		String input = scan.nextLine();

		switch (input) {
		case "1":
			return new InteractWithPetsScreen();
		case "2":
			return new ViewAvaiablePetsScreen();
		case "3":
			System.out.println("Feature is not yet implemented");
			break;
			
		}
		return this;// this returns current screen
	}

}
