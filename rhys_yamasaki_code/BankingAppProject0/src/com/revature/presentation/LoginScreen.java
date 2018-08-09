package com.revature.presentation;

import java.util.Scanner;

import com.revature.ConsoleColors;
import com.revature.Driver;
import com.revature.Screen;
import com.revature.pojo.Users;
import com.revature.bl.BusinessLogic;
import com.revature.exceptions.WrongInputException;;

public class LoginScreen implements Screen {

	@Override
	public Screen start() {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"Please login"+ ConsoleColors.RESET);
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"Please enter your username:"+ ConsoleColors.RESET);
		String username = "";
		try {
			username = scan.nextLine();
		} catch (WrongInputException e) {
			System.out.println("Invalid input, please try again");
			return this;
		}
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"Please enter your password:" + ConsoleColors.RESET);
		String password = "";
		try {
			password = scan.nextLine();
		} catch (Exception e) {
			System.out.println("Invalid input, please try again");
			return this;
		}
		if (new BusinessLogic().validateLogin(username, password)) {
			return new UserMenuScreen();
		} else {
			System.out.println("Sorry, your username and/or password were invalid");
			System.out.println("Please try again");
			System.out.println();
			return this;
		}
	}

}
