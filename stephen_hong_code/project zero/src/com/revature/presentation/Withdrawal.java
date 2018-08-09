package com.revature.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.businesslogic.Service;
import com.revature.exceptions.Negative;
import com.revature.exceptions.Overdraft;
import com.revature.interfaces.Screen;

public class Withdrawal implements Screen {

	@Override
	public Screen start() {
		Scanner scan = new Scanner(System.in);
		System.out.println("How much would you like to withdraw?");
		System.out.println("Amount: ");
		try {
			int amount = scan.nextInt();
			Service.withdrawal(amount);
		} catch (Overdraft e) {
			System.err.println("Not enough balance!");
			return this.start();
		} catch (InputMismatchException e) {
			System.err.println("Please enter a whole number");
			return this.start();
		} catch (Negative e) {
			System.err.println("Please enter a positive number");
			return this.start();
		}

		return new MainMenu().start();
	}

}
