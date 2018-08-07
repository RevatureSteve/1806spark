package com.dimma.presentation;

import java.util.Scanner;

import com.dimma.logic.Logic;
import com.dimma.user.User;

public class WithdrawMenu implements Screen{

	@Override
	public Screen start() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter desired withdraw amount.");
		int amount = scan.nextInt();
		if(amount <= 0) {
			System.out.println("You must enter a valid amount.");
			return this;
		}
		Logic.withdrawFunk(amount,User.getUser().getUsers_id());

		return new AccountMenu();
	}

}
