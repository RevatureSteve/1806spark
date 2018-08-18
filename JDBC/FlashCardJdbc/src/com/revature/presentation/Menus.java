package com.revature.presentation;

import java.util.Scanner;

<<<<<<< HEAD
import com.revature.dao.FlashCardDaoImpl;
=======
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
import com.revature.pojo.FlashCard;

public class Menus {

	public static void welcome() {
<<<<<<< HEAD
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
=======
		System.out.println("**********************");
		System.out.println("*Welcome to FlashCards*");
		System.out.println("**********************");
	}
	
	
	public static FlashCard createFlashCardMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("---Creating a Flashcard---");
		System.out.println("Enter FlashCard question: ");
		String question = scan.nextLine();
		System.out.println("Enter FlashCard answer: ");
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
		String answer = scan.nextLine();
		
		FlashCard fc = new FlashCard(0, question, answer);
		
		return fc;
<<<<<<< HEAD
				
	}
	public static int getFlashCardMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("---Find a Flashcard---");
		System.out.println("Enter Flashcard id: ");
		int id = scan.nextInt();
		return id;
				
=======
		
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
	}
}
