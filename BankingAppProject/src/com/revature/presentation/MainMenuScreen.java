package com.revature.presentation;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.revature.ConsoleColors;
import com.revature.Screen;
import com.revature.exceptions.WrongInputException;

public class MainMenuScreen implements Screen{

	@Override
	public Screen start() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println(ConsoleColors.CYAN + "Enter 1 to Login" + ConsoleColors.RESET);
		System.out.println(ConsoleColors.CYAN + "Enter 2 to Register" + ConsoleColors.RESET);
		String choice = "";
		try {
				choice = scan.nextLine();
		} catch (RuntimeException e) {
			System.out.println("Invalid input, please try again!");
			throw new WrongInputException("Please don't break my code");
		}
		
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
