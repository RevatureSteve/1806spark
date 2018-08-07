package com.revature.presentation;

import java.util.Scanner;

import com.revature.Screen;

public class MainMenuScreen implements Screen{

	@Override
	public Screen start() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter 1 to Login");
		System.out.println("Enter 2 to Register");
		String choice = scan.nextLine();
		
		switch (choice) {
		case "1": 
			return new LoginScreen();
		case "2":
			return new RegisterScreen();
		default:
			System.out.println("Entered a bad input.  Please try again.");
			return this;
		}
	}

}
