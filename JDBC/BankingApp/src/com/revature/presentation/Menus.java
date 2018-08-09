package com.revature.presentation;

import java.util.Scanner;

import com.revature.dao.BankingAppDao;
import com.revature.dao.BankingAppDaoImpl;
import com.revature.pojo.User;


public class Menus {

	public static void welcome() {
		System.out.println("**************************************************************************************************************************************************************************************************************************************************************");
		System.out.println("*Welcome to Southern Tosino Bank*");
		System.out.println("**************************************************************************************************************************************************************************************************************************************************************");
		System.out.println("\n");
	}
	
	
	public static void createBankingAppMenu() {
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("--Login your account--");
		System.out.println("Username: ");
		String username = scan.nextLine();
		System.out.println("Password: ");
		String password = scan.nextLine();
		
		BankingAppDao ba = new BankingAppDaoImpl();
		User user = ba.getUserByUsername(username);
		while (!(user.getPassword().equals(password))) {
			System.out.println("Invalid Password! Try Again.");
			System.out.println("--Login your account--");
			System.out.println("Username: ");
			username = scan.nextLine();
			System.out.println("Password: ");
			password = scan.nextLine();
			BankingAppDao ba1 = new BankingAppDaoImpl();
			User user1 = ba1.getUserByUsername(username);
			
			
		} Options.showOptions(user);
		
		
//		return ba;
		
	}
	
}
