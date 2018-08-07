package com.revature.presentation;

import java.util.Scanner;

import com.revature.Screen;

public class MainMenuScreen implements Screen {

	@SuppressWarnings("resource")
	@Override
	public Screen Start() {
		Scanner scan = new Scanner(System.in); 
	System.out.println("Welcome to the Bank");
	System.out.println("Main Menu");
	System.out.println("enter 1 to Login");
	System.out.println("enter 2 to Register");
	System.out.println("enter 3 to Exit");
	
	int input = scan.nextInt();
	
	
	switch (input) {
	case 1:
		return new LoginScreen();
	case 2:
		//return new RegisterScreen();
	case 3:
		System.out.println("goodbye");
		System.exit(1);
		break;

	default:
		break;
	}
	return this;
	}
}
