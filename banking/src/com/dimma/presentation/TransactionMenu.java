package com.dimma.presentation;

import java.util.Scanner;

import com.dimma.dao.Dao;
import com.dimma.logic.Logic;
import com.dimma.user.Account;
import com.dimma.user.User;

public class TransactionMenu implements Screen{
	@Override
	public Screen start() {
		Dao dao = new Dao();
		System.out.println("Hello " + User.getUser().getFname());
		Scanner scan = new Scanner(System.in);
		System.out.println("What would you like to view?");
		System.out.println("1. Deposit History");
		System.out.println("2. Withdraw History");
		System.out.println("3. Return to Account Screen");
		System.out.println("4. Logout");
		
		int decision = scan.nextInt();
		switch (decision) {
		case 1:
			Logic.transactionFunk(Account.acc.getAccount_number(), 1);
			return this;
		case 2: 
			Logic.transactionFunk(Account.acc.getAccount_number(), 2);
			return this;
		case 3:
			return new AccountMenu();
		case 4:
			System.out.println("----EXIT PROGRAM----");
			System.exit(1);

		default:
			return this;
		}
	}

}