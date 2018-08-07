package com.ex.store;

import java.util.Scanner;

public class ViewAvailablePetScreen implements Screen{
	private Scanner scan = new Scanner(System.in);
	
	@Override
	public Screen start() {
		System.out.println("Please choose from the following options:");
		System.out.println("1 to interact with your pets");
		System.out.println("2 to view available pets");
		System.out.println("3 to view pet toys");
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
