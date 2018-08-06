package com.revature.presentation;

import java.util.Scanner;

import com.revature.dao.FlashCardDaoImpl;
import com.revature.pojo.FlashCard;

public class Menus {

	public static void welcome() {
		System.out.println("***********************");
		System.out.println("*Welcome to FlashCards*");
		System.out.println("***********************");
	}
	
	public static FlashCard createFlashCardMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("---Creating a Flashcard---");
		System.out.println("Enter Flashcard question: ");
		String question = scan.nextLine();
		System.out.println("Enter Flashcard answer: ");
		String answer = scan.nextLine();
		
		FlashCard fc = new FlashCard(0, question, answer);
		
		return fc;
				
	}
	public static int getFlashCardMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("---Find a Flashcard---");
		System.out.println("Enter Flashcard id: ");
		int id = scan.nextInt();
		return id;
				
	}
}
