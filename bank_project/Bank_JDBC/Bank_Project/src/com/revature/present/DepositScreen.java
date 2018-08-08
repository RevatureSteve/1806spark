package com.revature.present;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.buisnesslogic.BuisnessLogic;
import com.revature.exceptions.NoNegativeNumber;
import com.revature.interfaces.Screen;

public class DepositScreen implements Screen{

	@Override
	public Screen start() {
		Scanner scan = new Scanner(System.in);
		System.out.println("******Make a Deposit******");
		System.out.println("Enter the amoount you want to deposit: ");
		
		try {
			Double amount = scan.nextDouble();
		BuisnessLogic.makeDeposit(amount);
		} catch (InputMismatchException e) {
			System.out.println("You have to enter a number!");
			return this.start();
		} catch (NoNegativeNumber e) {
			System.out.println("You cannont enter a neagtive number");
			return this.start();
		}
		return new MainMenuScreen().start();
	}

}
