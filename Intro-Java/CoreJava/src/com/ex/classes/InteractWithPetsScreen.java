package com.ex.classes;

import java.util.Scanner;

public class InteractWithPetsScreen implements Screen {

private Scanner scan = new Scanner(System.in);
	
	public Screen start() {
		System.out.println("Please choose from the following options: ");
		System.out.println("1 to speak with your pets");
		System.out.println("2 to play with your pets");
		System.out.println("3 go back to main menu");
		
		String input = scan.nextLine();
		
		switch (input) {
		case "1":
			
			return new ViewAvailablePetsScreen();
		case "2":
			
			System.out.println("Feature not yet implemented");
			break;
		case "3":
		
			return new MainMenuScreen();
		}
		
		return this;
	}
	
	

}