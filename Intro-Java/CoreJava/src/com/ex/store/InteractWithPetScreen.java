package com.ex.store;

import java.util.Scanner;

public class InteractWithPetScreen implements Screen {
	private Scanner scan = new Scanner(System.in);

	@Override
	public Screen start() {
		// TODO Auto-generated method stub

		System.out.println("please chose from the following options");
		System.out.println("1 to interact w/ your pets");
		System.out.println("2 to palw w/ pets");
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
