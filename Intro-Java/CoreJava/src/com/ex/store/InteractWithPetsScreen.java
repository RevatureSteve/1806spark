package com.ex.store;

import java.util.Scanner; //command + shift + o to manage imports

public class InteractWithPetsScreen implements Screen {
	private Scanner scan = new Scanner(System.in);

	@Override
	public Screen start() {
		
		System.out.println("Please choose from the following options: ");
		System.out.println("1 to view all pet toys");
		System.out.println("2 to view available pets");
		System.out.println("3 to go back to the main menu");
		String input = scan.nextLine();

		switch (input) {
		case "1":
			System.out.println("Feature is not yet implemented");
			break;
		case "2":
			return new ViewAvaiablePetsScreen();
		case "3":
			return new MainMenuScreen();
			
		}
		return this;// this returns current screen
	}

}
