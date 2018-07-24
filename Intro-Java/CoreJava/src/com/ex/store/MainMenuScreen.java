package com.ex.store;

import java.util.Scanner;

public class MainMenuScreen implements Screen {
	private Scanner scan = new Scanner(System.in);

	@Override
	public Screen start() {
		// TODO Auto-generated method stub
		System.out.println("please chose from the following options");
		System.out.println("1 to interact w/ your pets");
		System.out.println("2 to view available pets");
		System.out.println("3 to view pet toys");
		String input = scan.nextLine();

		switch (input) {
		case "1":
			return new InteractWithPetScreen();
		case "2":
			return new ViewAvailablePetsScreen();
		case "3":
			System.out.println("feature not yet implemented");
			break;
		}

		return this;
	}

}
