package com.revature.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.exceptions.OverdraftDiscoveredException;
import com.revature.interfaces.Screen;
import com.revature.services.Service;

public class Withdrawal implements Screen {

	@Override
	public Screen start() {
		Scanner scan = new Scanner(System.in);
		System.out.println("<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("How many chimichangas do you wanna steal?");
		System.out.println("<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("Amount of chimichangas: ");
		try {
			Double amount = scan.nextDouble();
			Service.withdrawl(amount);
		} catch (OverdraftDiscoveredException e) {
			System.out.println("                                         ");
			System.out.println("Sorry not sorry, not enough chimichangas!");
			System.out.println("                                         ");
			return this.start();
		} catch (InputMismatchException e) {
			System.out.println("                                                                          ");
			System.out.println("Ptts, no wonder you failed english, enter an int/double not a string duhh!!");
			System.out.println("                                                                           ");
			return this.start();
		}

		return new MainMenu().start();
	}

}