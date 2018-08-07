package com.revature.presentation;

/*
 * THIS IS THE USER SCREEN!
 * This is after you have logged in/ registered
 */
import java.util.Scanner;

import com.revature.Screen;
import com.revature.dao.BankAccountDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.pojo.BankAccount;
import com.revature.pojo.Users;

public class UsersMenuScreen implements Screen {
	
	private String username;
	
	public UsersMenuScreen() {
		super();
	}
	
	public UsersMenuScreen(String username) {
		super();
		this.username = username;
	}
	
	@SuppressWarnings("resource")
	public Screen Start() {
	
	Users currentUser = null;
	//BusinessLogic.getUserAccount(currentUser.getUserId());
	
	Scanner scan = new Scanner(System.in);
	
	System.out.println("Welcome user");
	System.out.println("enter 1 to view balance");
	System.out.println("enter 2 to make a deposit");
	System.out.println("enter 3 to make a withdrawl");
	System.out.println("enter 4 to view transaction history");
	System.out.println("enter 5 to return to the Main Menu");
	
	int input = scan.nextInt();
	
	
	switch (input) {
	case 1:
		
		UserDaoImpl account = new UserDaoImpl();//create userdaoimpl object to use the method
		currentUser = account.getUserByUserName(username);
		BankAccountDaoImpl balance = new BankAccountDaoImpl(); 
		BankAccount x = balance.getBankAccountByUserId(currentUser.getUserId());//we use the "method.get" to pull the users bankaccount
		System.out.println("balance is: " + x.getBalance());//display balance
		
		System.out.println("balance is blank");
		break;
	case 2:
		System.out.println("add money");
		break;
	case 3:
		System.out.println("take money");
		break;
	case 4:
		System.out.println("look at your mistakes");
		break;
	case 5:
		System.out.println("log out");
		return new MainMenuScreen().Start();
	default:
		break;
		
	}
	return this;
	}

	
	
}
