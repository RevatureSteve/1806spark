package com.revature;

import java.util.Scanner;

import com.revature.pojo.FlashCard;

public class Menus {
	
	public static void Welcome() {
		System.out.println("$");
		System.out.println("Flashcards");
		System.out.println("$");
		
	}
	
	public static FlashCard createFlashCardMenu() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("----------Creating  FC________");
		System.out.println(" Enter q *********************");
		String question = scan.nextLine();
		System.out.println("Enter answer((((((((((((()))))");
		String answer = scan.nextLine();
		
		FlashCard fc = new FlashCard(0, question, answer);
		
		return fc;
	}

}
