package com.revature.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WelcomeScreen implements Screen {

	private Scanner scan = new Scanner(System.in);
	
	
	public Screen start() {
		System.out.println("__________                __             _____  __________                __   .__                 \r\n" + 
				"\\______   \\_____    ____ |  | __   _____/ ____\\ \\______   \\_____    ____ |  | _|__| ____    ____   \r\n" + 
				" |    |  _/\\__  \\  /    \\|  |/ /  /  _ \\   __\\   |    |  _/\\__  \\  /    \\|  |/ /  |/    \\  / ___\\  \r\n" + 
				" |    |   \\ / __ \\|   |  \\    <  (  <_> )  |     |    |   \\ / __ \\|   |  \\    <|  |   |  \\/ /_/  > \r\n" + 
				" |______  /(____  /___|  /__|_ \\  \\____/|__|     |______  /(____  /___|  /__|_ \\__|___|  /\\___  /  \r\n" + 
				"        \\/      \\/     \\/     \\/                        \\/      \\/     \\/     \\/       \\//_____/   ");
		System.out.println("Bankable service from bankers you can bank on.");
		System.out.println("");
		System.out.println("Press 1 to login.");
		System.out.println("Press 2 to sign up.");
		
		try { int input = scan.nextInt();
		
		switch(input) {
		case 1:
			return new LoginScreen();
		case 2:
			return new RegisterScreen();
		}
		} catch (InputMismatchException e) {
			System.out.println("please enter a number");
			return new WelcomeScreen();
			
		}
		
		
		return this;
	}

}
