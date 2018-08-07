package com.revature.presentation;

import java.util.Scanner;

import com.revature.Screen;

public class UsersMenuScreen implements Screen {
	
	public Screen Start() {
		
	Scanner scan = new Scanner(System.in);
	
	System.out.println("Welcome user");
	System.out.println("enter 1 to view balance");
	System.out.println("enter 2 to make a deposit");
	System.out.println("enter 3 to make a withdrawl");
	System.out.println("enter 4 to view transaction history");
	
	int input = scan.nextInt();
	
	
	switch (input) {
	case 1:
		System.out.println("balance is blank");
		break;
	case 2:
		System.out.println("add money");
		break;
	case 3:
		System.out.println("take money");
		break;
	case 4:
		System.out.println("look at your mistakes");
		break;
	case 5:
		System.out.println("log out");
		return new MainMenuScreen().Start();
	default:
		break;
		
	}
	return this;
	}
	
	
}
