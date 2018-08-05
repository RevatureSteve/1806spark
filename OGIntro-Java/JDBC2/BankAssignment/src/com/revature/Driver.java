package com.revature;

import com.revature.Pojos.User;
import com.revature.Screen.Screen;

public class Driver {
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Cookie Bank!");
		CookieBankDao cbd = new CookieBankDao();
		User you = Screen.login();
		System.out.println(you);
		User databaseUser = cbd.thatUser(you.getUsename());
		System.out.println(databaseUser);
		
	}

}
