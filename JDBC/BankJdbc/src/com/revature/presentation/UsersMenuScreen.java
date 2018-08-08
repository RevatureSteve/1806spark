package com.revature.presentation;

/*
 * THIS IS THE USER SCREEN!
 * This is after you have logged in/ registered
 */
import java.util.Scanner;

import com.revature.Screen;
import com.revature.dao.BankAccountDaoImpl;
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
	@Override
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
	BankAccountDaoImpl account = new BankAccountDaoImpl();//create BankAccountDaoImpl object to use the method
	
	switch (input) {
	case 1:
		
		currentUser = account.getUserByUserName(username);
		BankAccountDaoImpl balance = new BankAccountDaoImpl(); 
		BankAccount x = BankAccount.getCurrentAccount();//we use the "method.get" to pull the users bankaccount
		System.out.println("balance is: " + x.getBalance());//display balance
		
		return this;
	case 2:
		
		return new DepositScreen().Start();
		
	case 3:
		
		return new WithdrawScreen().Start();

	case 4:
		System.out.println("look at your mistakes");
		break;
	case 5:
		System.out.println("log out");
		System.exit(1);
	default:
		break;
		
	}
	return this;
	}



	
	
}
