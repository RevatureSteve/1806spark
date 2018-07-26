package com.screens.banking;

import java.util.Scanner;

import com.interfaces.banking.Screen;

public class LoginScreen implements Screen {

	private Scanner scan = new Scanner(System.in);
	public LoginScreen() {
		
	}

	@Override
	public Screen start() {
		System.out.println("Please provide login");
		String login = scan.nextLine();
		System.out.println("Please provide password");
		String password = scan.nextLine();
		
		if(login.equals("Marcin")&&password.equals("Salamon")) {
			return new MainMenuScreen();
		}
		return this;
	}

}
