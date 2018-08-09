package com.revature.presentation;

import java.util.Scanner;

import com.revature.Screen;
import com.revature.businessLogic.BusinessLogic;
import com.revature.pojo.BankAccount;

public class DepositScreen implements Screen{

	@Override
	public Screen Start() {
		Scanner scan = new Scanner(System.in);
		//System.out.println("add money");
		System.out.println("HOW MUCH WOULD YOU LIKE TO DEPOSIT?");
		Double txAmount = scan.nextDouble();
		
		if (BusinessLogic.validDeposit(txAmount)) {
			return new UsersMenuScreen();
		} else {
			System.out.println("INVALID INPUT, ENTER POSITIVE NUMBER");
			return this;
		}
	}
	
}
