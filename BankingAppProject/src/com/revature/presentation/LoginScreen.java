package com.revature.presentation;

import java.util.Scanner;

import com.revature.Driver;
import com.revature.Screen;
import com.revature.pojo.Users;
import com.revature.bl.BL;;
public class LoginScreen implements Screen{

	@Override
	public Screen start() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please login to your account");
		System.out.println("Please enter your username:");
		String username = scan.nextLine();
		System.out.println("Please enter your password:");
		String password = scan.nextLine();
		
		
		if (BL.validateUser(username, password)) {
			return new UserMenuScreen();
		} else {
			System.out.println("Sorry, your username and/or password were invalid");
			System.out.println("Please try again");
			System.out.println();
			return this;
		}
		//System.out.println(password);
		//System.out.println(Driver.bd.getUsersByUsername(username).getPassword());
		//apply method from business logic class to check if user is valid
//		if (Driver.bd.getUsersByUsername(username).getPassword().equals(password)) {
//			System.out.println("Instantiating new User!");
//			Users u = new Users(0, username, password);
//			System.out.println(u);
//			return new UserMenu();
//		}
		//return this;
	}

}
