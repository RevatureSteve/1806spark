package com.revature.present;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.buisnesslogic.BuisnessLogic;
import com.revature.exceptions.NoNegativeNumber;
import com.revature.exceptions.NotEnoughMoneyException;
import com.revature.interfaces.Screen;


public class WithdrawlScreen implements Screen {

	@Override
	public Screen start() {
		System.out.println("*******Make a withdrawl*******");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the amount you wish to withdrawl: ");

		try {
			Double amount = scan.nextDouble();
			BuisnessLogic.makeWithdrawl(amount);
		} catch (NotEnoughMoneyException e) {
			System.out.println("You do not have enough money to make withdrawal!");

		} catch (InputMismatchException e) {
			System.out.println("You have to enter a number!");
			return this.start();
		} catch (NoNegativeNumber e) {
			System.out.println("You cannot enter a negative number!");
		}

		return new MainMenuScreen().start();

	}

}
