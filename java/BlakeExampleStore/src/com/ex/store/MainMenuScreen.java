package com.ex.store;

import java.util.Scanner;

public class  MainMenuScreen implements Screen {
	//scanner is used to take user input
	private Scanner scan = new Scanner(System.in);
	
	@Override 
	public Screen start() {
		System.out.println("please choose the following options");
		System.out.println("1 to view your pet");
		System.out.println("to view pets available");
		System.out.println("3 to view pet toys");
		String input = scan.nextLine();
		
		
		switch (input) {
		case "1":
			return new InteractWithPetScreen();
		
			
		case "2":
			System.out.println("feature not yet available");
			break;
			
		case "3":
			System.out.println("feature not yet available");
			break;
		   
		}
		return this;
	}
 
 
}
