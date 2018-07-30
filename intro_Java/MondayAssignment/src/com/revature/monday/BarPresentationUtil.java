package com.revature.monday;

import java.util.Scanner;

public class BarPresentationUtil implements RobotWaiterInterface {
	
	public static void talkToServer(){
		
		System.out.println("Enter 1 to order a beer");
		System.out.println("Enter 2 to order a glass of Wine");
		System.out.println("Enter 3 to order some food");
		System.out.println("Enter 4 to call a taxi");
		System.out.println("Enter 5 to sing Karaoke");
		System.out.println("Enter 6 to generate Receipt");
		System.out.println("Enter 7 to Post Receipt");
		

	}
	
	public static ReceiptSerializable createNewCheck() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter total cost of Visit: ");
		double checkTotal = scan.nextDouble();
		System.out.println("Enter Credit Card Number");
		int creditCardNumber = scan.nextInt();
		
		ReceiptSerializable yourCheck = new ReceiptSerializable(checkTotal, creditCardNumber);
		scan.close();
		
		return yourCheck;
		
	}
	
	public static void presentCheck(ReceiptSerializable yourCheck) {
		System.out.println(yourCheck);
	}
	
	public static void errorView(String message) {
		System.out.println("The matrix has a glitch");
		System.out.println("There is no spoon");
	}
	
	

	@Override
	public void robotWaiter() {
		
		System.out.println("Welcome to the virtual Bar, I am your robot server please select an option");
		
	}

	

	
}

