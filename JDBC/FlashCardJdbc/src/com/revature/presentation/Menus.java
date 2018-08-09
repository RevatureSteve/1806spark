package com.revature.presentation;

<<<<<<< HEAD
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
=======
import java.util.Scanner;

import com.revature.pojo.FlashCard;

public class Menus {

	public static void welcome() {
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
>>>>>>> fa66388667395c761e59539daaea36af9d01238b
		String answer = scan.nextLine();
		
		FlashCard fc = new FlashCard(0, question, answer);
		
		return fc;
<<<<<<< HEAD
=======
		
>>>>>>> fa66388667395c761e59539daaea36af9d01238b
	}
}
