package com.revature.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.dao.AccountInfoDaoImpl;
import com.revature.dao.BankDao;
import com.revature.pojo.BankAccount;
import com.revature.pojo.Users;

public class Balance implements Screen {
	
	private Scanner scan = new Scanner(System.in);
	BankDao dao = new AccountInfoDaoImpl();
	
	BankAccount acc = dao.getAccountInfo(Users.potentialUser().getUserId());
	double bal = acc.getBalance();
	
	public Screen start() {
		System.out.println("Your balance is:  $" + bal);
		
		//System.out.println(acc.getBalance());
		//BankDao dao = new BalanceDaoImpl();
		
		
		System.out.println("What next?");
		System.out.println("Enter 1 to go back to main menu. ");
		System.out.println("Enter 2 to log out.");
		
		
		try { int input = scan.nextInt();
		
		switch (input) {
		case 1:
			return new MainMenu();
		case 2:
			System.out.println("Have a nice day!");
			System.exit(1);
		}	
			
		} catch (InputMismatchException e) {
			System.out.println("please enter a number");
			return new Balance();
		}
		
		
		
		return this;
	}

}
