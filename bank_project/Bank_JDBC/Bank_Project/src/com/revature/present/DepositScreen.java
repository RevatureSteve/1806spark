package com.revature.present;

import java.util.Scanner;

import com.revature.buisnesslogic.BuisnessLogic;
import com.revature.interfaces.Screen;

public class DepositScreen implements Screen{

	@Override
	public Screen start() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Make a Deposit");
		System.out.println("Enter the amoount you want to deposit: ");
		Double amount = scan.nextDouble();
		BuisnessLogic.makeDeposit(amount);
		return new MainMenuScreen().start();
	}

}
