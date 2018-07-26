package com.project;

import java.util.Scanner;


public class MainMenu implements HomeScreen{

	private Scanner scan = new Scanner(System.in);//this takes in input
	
	@Override
	public HomeScreen Start() {
		

		System.out.println("Welcome to Cosmos Bank");
		System.out.println("Type 'bal' to check your balance.");
		
		String input = scan.nextLine();
		
		switch (input) {
		case "bal":
			System.out.println("Feature is not yet implemented");
			break;
		case "withdraw":
			System.out.println("Feature is not yet implemented");
			break;
		case "deposit":
			System.out.println("Feature is not yet implemented");
			break;
			
		}
		return this;// this returns current screen
	}

}
