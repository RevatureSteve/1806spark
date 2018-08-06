package com.revature.presentation;

import java.util.Scanner;

import com.revature.Screen;
import com.revature.bl.BusinessLogic;
import com.revature.dao.BankDao;
import com.revature.dao.BankDaoImpl;
import com.revature.pojo.BankAccount;
import com.revature.pojo.Users;

public class WithdrawScreen implements Screen{

	@Override
	public Screen start() {
		BankDao bd = new BankDaoImpl();
		BankAccount ba = bd.getBankAccountInfo(Users.getUser().getId());
		Scanner scan = new Scanner(System.in);
		System.out.println("How much would you like to withdraw?");
		try {
		double amount = scan.nextDouble();
		if(BusinessLogic.withdrawFromAccount(amount, ba.getAccount_number())) {
			System.out.println("Withdraw successful!");
			System.out.println("You withdrew: $" + amount);
			System.out.println();
			return new UserMenuScreen();
		} else {
			return this;
		}
		} catch(Exception e) {
			System.out.println("You did not input a number.  Please input a number.");
			return this;
		}
	}

}
