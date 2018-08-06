package com.revature.presentation;

import java.util.Scanner;

import com.revature.pojo.BankUsers;

public class Menus {
	
	public static void welcome() {
		System.out.println("-----------------------");
		System.out.println("Welcome");
		System.out.println("-----------------------");
	}
	public static BankUsers createFlashCardMenu() {
		Scanner scan = new Scanner(System.in); 
		System.out.println("---Creating a flashcard---");
	
		System.out.println("Enter a flashcard question: ");
		String question = scan.nextLine();
		System.out.println("Enter a flashcard answer: ");
		String answer = scan.nextLine();
		
		BankUsers fc = new BankUsers(0, question, answer);
		return fc;
	}
}
