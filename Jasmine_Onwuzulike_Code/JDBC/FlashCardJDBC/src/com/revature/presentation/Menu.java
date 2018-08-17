package com.revature.presentation;

import java.util.Scanner;

import com.revature.pojos.FlashCard;

public class Menu {

	
	public static void welcome() {
		System.out.println("***************************");
		System.out.println("Welcome");
		System.out.println("***************************");

	}
	
	public static FlashCard createFlashCardMenu() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Crating a Flashcard");
		System.out.println("Enter flashcard question"  );
		String question = scan.nextLine();
		System.out.println("Enter flashcard answer");
		String answer = scan.nextLine();
		scan.close();
		FlashCard fc = new FlashCard(0, question, answer);
		return fc;
	};
}
