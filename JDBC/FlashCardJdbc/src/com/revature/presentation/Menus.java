package com.revature.presentation;

import java.util.Scanner;

import com.revature.pojo.FlashCard;

public class Menus {
	
	public static void welcome() {
		System.out.println("Welcome to Flashcards");
	}

	public static FlashCard createFlashCardMenu() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Creating a Flashcard");
		System.out.println("Enter Flashcard Question");
		String question = scan.nextLine();
		System.out.println("Enter Flashcard Answer: ");
		String answer = scan.nextLine();
		
		FlashCard fc = new FlashCard(0, question, answer);
		
		//scan.close();
		
		return fc;
	}
}
