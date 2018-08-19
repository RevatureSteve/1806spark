package com.revature.presentation;

import java.util.Scanner;

import com.revature.Screen;
import com.revature.businessLogic.BusinessLogic;

public class WithdrawScreen implements Screen {

	@Override
	public Screen Start() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("HOW MUCH WOULD YOU LIKE TO WITHDRAW?");
		Double txAmount = scan.nextDouble();
		
		if (!BusinessLogic.validWithdraw(txAmount)) {
			return new UsersMenuScreen();
		} else {
			System.out.println("WITHDRAW INPUT EXCEEDS CURRENT BALANCE");
			return this;
		}
		
	}

}