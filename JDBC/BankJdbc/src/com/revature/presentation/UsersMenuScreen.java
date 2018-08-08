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
	
	System.out.println("ROBOCO INDUSTRIES UNIFIED OPERATING BANKING SYSTEM");
	System.out.println("COPYRIGHT 2075 - 2077 ROBOCO INDUSTRIES");
	System.out.println("-SERVER 6-\n");
	System.out.println("ENTER 1 TO VIEW BALANCE");
	System.out.println("ENTER 2 TO MAKE A DEPOSIT");
	System.out.println("ENTER 3 TO MAKE A WITHDRAW ");
	//stem.out.println("enter 4 to view transaction history");
	System.out.println("ENTER 5 TO EXIT AND LOGOUT\n\n\n\n\n\n\n\n\n\n");
	
	int input = scan.nextInt();
	BankAccountDaoImpl account = new BankAccountDaoImpl();//create BankAccountDaoImpl object to use the method
	
	switch (input) {
	case 1:
		
		currentUser = account.getUserByUserName(username);
		BankAccountDaoImpl balance = new BankAccountDaoImpl(); 
		BankAccount x = BankAccount.getCurrentAccount();//we use the "method.get" to pull the users bankaccount
		System.out.println("CURRENT BALANCE IS: " + x.getBalance() + " CAPS");//display balance
		
		return this;
	case 2:
		
		return new DepositScreen().Start();
		
	case 3:
		
		return new WithdrawScreen().Start();

	case 4:
		System.out.println("look at your mistakes");
		break;
	case 5:
		System.out.println("YOU HAVE LOGGED OUT");
		System.exit(1);
	default:
		break;
		
	}
	return this;
	}



	
	
}
