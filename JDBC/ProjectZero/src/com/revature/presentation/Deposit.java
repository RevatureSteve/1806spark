package com.revature.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.businesslogic.Service;
import com.revature.interfaces.Screen;

public class Deposit implements Screen {

	@Override
	public Screen start() {
		Scanner scan = new Scanner(System.in);
		System.out.println("How much would you like to deposit?");
		System.out.println("Amount: ");
		try {
			Double amount = scan.nextDouble();
			Service.deposit(amount);
		} catch (InputMismatchException e) {
			System.out.println("Please enter numeric amount");
			return this.start();
		}
		
		return new MainMenu().start();
	}
	
	

}
