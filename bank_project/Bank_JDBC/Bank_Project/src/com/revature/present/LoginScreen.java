package com.revature.present;

import java.nio.charset.MalformedInputException;
import java.util.Scanner;

import com.revature.interfaces.Screen;

public class LoginScreen implements Screen{

	@Override
	public Screen start() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("*******Please Login********");
		System.out.println("Enter username: ");
		String userName = scan.nextLine();
		System.out.println("Enter password: ");
		String password = scan.nextLine();
		
		return new MainMenuScreen().start();
	}

}
