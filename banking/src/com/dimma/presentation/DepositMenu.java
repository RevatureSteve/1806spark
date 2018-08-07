package com.dimma.presentation;

import java.util.Scanner;

import com.dimma.logic.Logic;
import com.dimma.user.User;

public class DepositMenu implements Screen{

	@Override
	public Screen start() {
		Scanner scan = new Scanner(System.in);
		System.out.println("|-----------------------------------|");
		System.out.println("|Please enter desired deposit amount|");
		System.out.println("|-----------------------------------|");
		System.out.println();
		int amount = scan.nextInt();
		if(amount <= 0) {
			System.out.println("|-----------------------------------|");
			System.out.println("|   You must enter a valid amount.  |");
			System.out.println("|-----------------------------------|");
			return this;
		}
		Logic.depositFunk(amount,User.getUser().getUsers_id());

		return new AccountMenu();
	}

}
