package com.revature.presentation;

import com.revature.FlashCard;

public class Menus { // static because you don't wanna instantiate menus

	public static void welcome() {
		System.out.println();
		System.out.println();
		System.out.println();
	}
	public static void createFlashCardmenu() {
		System.out.println("Creating a Flashcard");
		System.out.println("Entre Flashcard question: ");
		String question = scan.nextLine();
		System.out.println("Enger FlashCard answer: ");
		String answer = scan.nextLine();
		
		FlashCard fc = new FlashCard(0, question, answer);
		
		return fc;
	}
}
