package com.revature.presentation;

import java.util.Scanner;

import com.revature.logic.BusinessLogic;
import com.revature.pojo.Users;

public class LoginScreen implements Screen {
	
	

	private Scanner scan = new Scanner(System.in);
	
	public Screen start() {
		
		System.out.println("Please enter your username: ");
		String username = scan.nextLine();
		System.out.println("Please enter your password: ");
		String password = scan.nextLine();
		
		if(BusinessLogic.userValidation(username, password) == null) {
			System.out.println("Incorrect username and/or password");
			return this;
		} else {
			
			return new MainMenu();
		}
		
	
	
	}	

}

//
//if (BL.validateUser(username, password) == null) {
//	System.out.println("Sorry, your username and/or password were invalid");
//	System.out.println("Please try again");
//	System.out.println();
//	return this;
//} else {
//	return new UserMenuScreen();

//	public Screen start() {
//		System.out.println("Please choose from the following options:");
//		System.out.println("1 to interact with your pets");
//		System.out.println("2 to view available pets");
//		System.out.println("3 to view pet toys");
//		String input = scan.nextLine();
//
//		switch (input) {
//		case "1":
//			return new InteractWithPetsScreen();
//		case "2":
//			return new ViewAvailablePetsScreen();
//
//		case "3":
//			System.out.println("feature not yet implemented");
//			break;
//		}
//
//		return this;
//	}
//
//}