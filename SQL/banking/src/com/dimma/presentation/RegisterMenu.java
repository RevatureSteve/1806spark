package com.dimma.presentation;

import java.util.Scanner;

import com.dimma.dao.Dao;
import com.dimma.logic.Logic;
import com.dimma.user.Account;
import com.dimma.user.User;

public class RegisterMenu implements Screen{
	@Override
	public Screen start() {
		Dao dao = new Dao();
		System.out.println("Hello " + User.getUser().getFname());
		Scanner scan = new Scanner(System.in);
		System.out.println("|-----------------------------------|");
		System.out.println("|         [REGISTER ACCOUNT]        |");
		System.out.println("|                                   |");
		System.out.println("|-----------------------------------|");
		
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
			System.out.println("|-----------------------------------|");
			System.out.println("|-=-HAVE-A-GOOD-DAY-=-=-=-=-=-=-=-=-|");
			System.out.println("|=-=-=-HAVE A GOOD DAY-=-=-=-=-=-=-=|");
			System.out.println("|=-=-=-==-HAVE A GOOD DAY-=-=-=-=-=-|");
			System.out.println("|-=||=||-=-=-HAVE A GOOD DAY=-=-=-=-|");
			System.out.println("|=-||-||=-=-=-=-HAVE A GOOD DAY=-=-=|");
			System.out.println("|=T_____T=-=-=-=-=-HAVE A GOOD DAY=-|");
			System.out.println("|=-=-=-=-=--=-=-=-=-=HAVE A GOOD DAY|");
			System.out.println("|-----------------------------------|");
			System.out.println("|-----------------------------------|");
			System.out.println("|                                   |");
			System.out.println("|  THANKS FOR USING ACCOUNT-O-MATIC |");
			System.out.println("|                                   |");
			System.out.println("|          PRESS ( > ) RUN          |");
			System.out.println("|                                   |");
			System.out.println("|-----------------------------------|");
			System.exit(1);

		default:
			return this;
		}
	}

}