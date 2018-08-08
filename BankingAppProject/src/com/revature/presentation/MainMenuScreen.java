package com.revature.presentation;

import java.util.Scanner;

import com.revature.ConsoleColors;
import com.revature.Driver;
import com.revature.Screen;
import com.revature.exceptions.WrongInputException;

public class MainMenuScreen implements Screen{

	@Override
	public Screen start() {
		Driver.displayOuterSpace();
		Scanner scan = new Scanner(System.in);
		
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "Enter 1 to Login" + ConsoleColors.RESET);
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "Enter 2 to Register" + ConsoleColors.RESET);
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "Enter 3 to Exit" + ConsoleColors.RESET);
		String choice = "";
		try {
				choice = scan.nextLine();
		} catch (RuntimeException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + "You entered an invalid input" + ConsoleColors.RESET);
			throw new WrongInputException("Please don't break my code");
		}
		
		switch (choice) {
		case "1": 
			return new LoginScreen();
		case "2":
			return new RegisterScreen();
		case "3":
			System.out.println("Thanks for stopping by!  May the force be with you!");
			System.exit(1);
		default:
			System.out.println(ConsoleColors.RED_BACKGROUND + "Invalid input.  Please try again." + ConsoleColors.RESET);
			return this;
		}
	}

}
