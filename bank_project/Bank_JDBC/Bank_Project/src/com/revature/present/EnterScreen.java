package com.revature.present;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.interfaces.Screen;

public class EnterScreen implements Screen {

	@Override
	public Screen start() {

		Scanner scan = new Scanner(System.in);

		System.out.println("Already a user. Enter 1 to login:");
		System.out.println("New user. Enter 2 to create an account:");

		int userInput = 0;

		try {
			userInput = scan.nextInt();
			switch (userInput) {
			case 1:
				new LoginScreen().start();
			case 2:
				new RegisterScreen().start();
			}
		} catch (InputMismatchException e) {
			System.out.println("You have to enter a number!");
		}

		return this.start();
	}

}
