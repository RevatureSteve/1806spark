package com.revature.presentation;

import java.util.Scanner;

import com.revature.businesslogic.Service;
import com.revature.interfaces.Screen;

public class Login implements Screen {

	@Override
	public Screen start() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("=========================================================");
		System.out.println("Welcome to Bank of Korea!");
		System.out.println("=========================================================");
		System.out.println("Username:");
		String userName = scan.nextLine();
		System.out.println("Password:");
		String password = scan.nextLine();
		
		if (Service.validateUser(userName, password)) {
			return new MainMenu().start();
		} else {
		System.err.println("User info incorrect! Please try again.");
		return this.start();
		}
	}

}
