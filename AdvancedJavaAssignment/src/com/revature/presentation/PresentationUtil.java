package com.revature.presentation;

import java.util.Scanner;

import com.revature.abstracts.Drinks;
import com.revature.dao.DrinksDao;
import com.revature.exceptions.EmptyStringException;
import com.revature.exceptions.NoNegativeException;
import com.revature.pojo.Bottle;
import com.revature.pojo.Can;

public class PresentationUtil {
	
	public static void welcomeMenu() {
		System.out.println("Please select from the options below:");
		System.out.println("Enter 1 to make a new soda");
		System.out.println("Enter 2 to make a new juice");
		System.out.println("Enter 3 to read your drinks");
		System.out.println("Enter 4 to exit");
	}
	
	public static Can makingSoda() throws EmptyStringException, NoNegativeException {
		Can soda = new Can();
		Scanner scan = new Scanner(System.in);
		System.out.println("-----New soda-----");
		System.out.println("Enter soda brand name:");
		String brandName = scan.nextLine();
		if (brandName.equals("")) {
			throw new EmptyStringException();
		} else {
			soda.setBrandName(brandName);
		}
		System.out.println("Enter ounces");
		int ounces = scan.nextInt();
		if (ounces < 0) {
			System.out.println("Sorry you can't have negative ounces.  Please try again");
		} else {
			soda.setOunces(ounces);			
		}
		System.out.println("Enter weight:");
		int weight = scan.nextInt();
		if (weight < 0) {
			System.out.println("Sorry you can't have negative weight. Please try again");
		}
		soda.setWeight(weight);
		return soda;
		
	}
	
	
	public static Bottle makingNewJuice() throws EmptyStringException, NoNegativeException {
		Bottle juice = new Bottle();
		Scanner scan = new Scanner(System.in);
		System.out.println("-----New Juice-----");
		System.out.println("Enter juice brand name:");
		String brandName = scan.nextLine();
		if (brandName.equals("")) {
			throw new EmptyStringException();
		} else {
			juice.setBrandName(brandName);
		}
		System.out.println("Enter the amount of ounces:");
		int ounces = scan.nextInt();
		if (ounces < 0) {
			System.out.println("Sorry you can't have negative ounces please try again");
			juice.setOunces(12);
			throw new NoNegativeException();
		} else {
			juice.setOunces(ounces);
		}
		System.out.println("Enter the weight:");
		int weight = scan.nextInt();
		if (weight < 0) {
			System.out.println("Sorry can't have negative weight please try again");
			juice.setWeight(2);
			throw new NoNegativeException();
		} else {
			juice.setWeight(weight);
		}
		return juice;
		
	}
	
	
	public static void presentDrinks() {
		System.out.println("-----Current Drinks-----");
		System.out.println(DrinksDao.readDrinks());
	}
	
}
