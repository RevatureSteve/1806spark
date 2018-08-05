package com.revature;

import com.revature.dao.BankDao;
import com.revature.dao.BankDaoImpl;
import com.revature.pojo.Users;
import com.revature.presentation.LoginScreen;

public class Driver {
	
	
	public static void main(String[] args) {
		System.out.println("Welcome! To the banking app!");
		Screen currentScreen = new LoginScreen();
		while(true) {			
			currentScreen = currentScreen.start();
		}
	}
}
