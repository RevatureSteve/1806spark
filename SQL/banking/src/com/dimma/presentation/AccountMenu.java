package com.dimma.presentation;

import java.util.Scanner;

import com.dimma.dao.Dao;
import com.dimma.logic.Logic;
import com.dimma.user.Account;
import com.dimma.user.User;

public class AccountMenu implements Screen{
	@Override
	public Screen start() {
		System.out.println("Hello " + User.getUser().getFname());
		System.out.println("Your Balance is $"+Account.acc.getBalance());
		Scanner scan = new Scanner(System.in);
		System.out.println("|-----------------------------------|");
		System.out.println("|                                   |");
		System.out.println("|        Welcome to your account    |");
		System.out.println("|        1. Transaction History     |");
		System.out.println("|        2. Deposit                 ]");
		System.out.println("|        3. Withdraw                |");
		System.out.println("|        4. Logout.                 |");
		System.out.println("|                                   |");
		System.out.println("|-----------------------------------|");
		
		int decision = scan.nextInt();
		switch (decision) {
		case 1:
			return new TransactionMenu();
		case 2: 
			return new DepositMenu();
		case 3:
			return new WithdrawMenu();
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
		case 5:
			System.out.println("|-----------------------------------|");
			System.out.println("|                                   |");
			System.out.println("|       YOUR CURRENT BALANCE IS:    |");
			System.out.println("|      $+       "+Account.acc.getBalance()+"    ");
			System.out.println("|                                   |");
			System.out.println("|-----------------------------------|");
		default:
			return this;
		}
	}

}
