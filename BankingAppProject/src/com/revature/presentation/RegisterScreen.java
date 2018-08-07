package com.revature.presentation;

import java.util.Scanner;

import com.revature.Screen;
import com.revature.bl.BusinessLogic;
import com.revature.dao.BankDao;
import com.revature.dao.BankDaoImpl;

public class RegisterScreen  implements Screen{

	@Override
	public Screen start() {
		BankDao bd = new BankDaoImpl();
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.println("Register here!");		
		System.out.println("Please enter the username you want to use:");
		String username = scan.nextLine();
		if (!BusinessLogic.validateUsername(username)) {
			return this;
		}
		System.out.println("Please enter a password:");
		String password = scan.nextLine();
		System.out.println();
		System.out.println("Please enter your first name:");
		String fname = scan.nextLine();
		System.out.println();
		System.out.println("Please enter your last name:");
		String lname = scan.nextLine();
		
		try {
			bd.createNewUser(username, password, fname, lname);
		} catch (Exception e) {
			System.out.println("There was an issue creating your account.  Please try again.");
			return this;
		}
		System.out.println("User created!  Welcome!");
		return new UserMenuScreen();
	}

}
