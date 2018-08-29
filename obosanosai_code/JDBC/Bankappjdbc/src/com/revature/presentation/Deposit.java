package com.revature.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.interfaces.Screen;
import com.revature.services.Service;

public class Deposit implements Screen {

	@Override
	public Screen start() {
		Scanner scan = new Scanner(System.in);
        System.out.println("<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("How many chimichangas do you wanna deposit?");
        System.out.println("<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("Amount of chimichangas: ");
		try {
			Double amount = scan.nextDouble();
			Service.deposit(amount);
		} catch (InputMismatchException e) {
			System.out.println("                                                                           ");
			System.out.println("Ptts, no wonder you failed english, enter an int/double not a string duhh!!");
			System.out.println("                                                                           ");
			return this.start();
		}
		
		return new MainMenu().start();
	}
	
	

}