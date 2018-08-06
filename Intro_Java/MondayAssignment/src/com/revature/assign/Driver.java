package com.revature.assign;

import java.io.IOException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		while (true) {
			Screen.startScreen();

			int userInput = scan.nextInt();

			switch (userInput) {
			case 1:
				createLabelB();
				break;
			case 2:
				readLabelB();
				break;
			case 3:
				bufferWriteLabelB();
				break;
			case 4:
				bufferReadLabelB();
				break;
			case 5:
				System.out.println("Program Terminated");
				System.exit(1);
				break;
			}
		}
	}
	
	public static void createLabelB() {
		LabelB label = Screen.newLabelB();
		
			try {
				LabelDao.serializeLabelB(label);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public static void readLabelB(){
		LabelB label = LabelDao.deserializeLabelB();
		
		Screen.displayLabelB(label);
	}
	
	public static void bufferWriteLabelB() {
		LabelB label = Screen.newLabelB();
		
		BuffWrite.writeCharacters(label);
		
	}
	
	public static void bufferReadLabelB() {
		LabelB label = BuffWrite.readCharacters();
		
		Screen.displayLabelB(label);
	}

}
