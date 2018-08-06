package com.revature.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.businesslogic.Service;
import com.revature.exceptions.OverdraftException;
import com.revature.interfaces.Screen;

public class Withdrawal implements Screen {

	@Override
	public Screen start() {
		Scanner scan = new Scanner(System.in);
		System.out.println("How much would you like to withdraw?");
		System.out.println("Amount: ");
		try {
			Double amount = scan.nextDouble();
			Service.withdrawl(amount);
		} catch (OverdraftException e) {
			System.out.println("Not enough balance!");
			return this.start();
		} catch (InputMismatchException e) {
			System.out.println("Please enter numeric amount");
			return this.start();
		}

		return new MainMenu().start();
	}

}
