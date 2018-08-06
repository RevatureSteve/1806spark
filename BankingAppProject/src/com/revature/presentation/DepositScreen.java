package com.revature.presentation;

import java.util.Scanner;

import com.revature.Screen;
import com.revature.bl.BusinessLogic;
import com.revature.dao.BankDao;
import com.revature.dao.BankDaoImpl;
import com.revature.pojo.BankAccount;
import com.revature.pojo.Users;

public class DepositScreen implements Screen{

	@Override
	public Screen start() {
		BankDao bd = new BankDaoImpl();
		BankAccount ba = bd.getBankAccountInfo(Users.getUser().getId());
		Scanner scan = new Scanner(System.in);
		System.out.println("How much would you like to deposit?");
		double amount = scan.nextDouble();
		if(BusinessLogic.depositToAccount(amount, ba.getAccount_number())) {
			System.out.println("Deposit successful!");
			System.out.println("You have deposited: $" + amount);
			return new UserMenuScreen();
		} else {
			return this;
		}
		// Some function to do business logic and calculate the deposit for the thing
		// if passes sysout deposit successful!
		// wrap in try/catch block for type input
	}
	
}
