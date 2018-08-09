package com.revature.presentation;

import java.util.Scanner;

import com.revature.dao.BankDao;
import com.revature.dao.RegisterDaoImpl;

public class RegisterScreen implements Screen {

	
	private Scanner scan = new Scanner(System.in);
	
	
	
	@Override
	public Screen start() {
		System.out.println("Please fill out the sign up information.");
		System.out.println("What is your first name?");
		String fname = scan.nextLine();
		System.out.println("What is your last name?");
		String lname = scan.nextLine();
		System.out.println("Choose a username");
		String username = scan.nextLine();
		System.out.println("Choose a password");
		String password = scan.nextLine();
		
		BankDao registerDao = new RegisterDaoImpl();
		registerDao.createUser(username, password, fname, lname);
		
		
		return new LoginScreen();
	}

}
