package com.revature;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.revature.IOHandler;

public class Launch {

	public static void main(String[] args) { 
		String filePath = "src/com/revature/FishPrints.txt"; 
		int input=IOHandler.userInput(); //handles the number 1, 2 input
			
		
		
		System.out.println("Current Grouper: " + FishDao.deserialize());
		
		
		switch(input) {
		case 1:
			Shark s = new Shark(true, 15, true, true); //creating a shark object
			System.out.println(s); // prints out new shark object
					try {
						s.setSizeFt(10); //SETS SIZE HERE, THIS MUST BE AT LEAST 10 OR EXCEPTION WILL BE THROWN
					} catch (WrongSizeException e1) {
						e1.printStackTrace();
					}//this is risky code, the sizeFT can not be less than 10!
					write(filePath, s);
			break;
		case 2:
			Grouper g = new Grouper(true, "great", true, true); // creating a new grouper object
			System.out.println(g); //print out that grouper object
			
			try {
				g.setHowsTaste(""); // I said I don't want an empty string so this is risky code
			} catch (WrongTasteException e) { // catch it with this error
				e.printStackTrace(); // print the message I said to print
			}
			try {
				FishDao.serializeFish(g); //serializes the grouper
			} catch (IOException i) {
				i.printStackTrace();
			}
			break;
		case 3:
			Runnable t1 = new newRunnable(); //Reference to new runnable i created
			Thread threa1 = new Thread(t1); // creates a new thread
			threa1.start(); // starts the thread
		// Deserializes the Grouper 
		}
		
		
		
		
		System.out.println("I quit");
		
		
	}
	
	public static void write(String filePath, Shark printShark) { //Method that writes shark to FishPrints
try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));){		//connecting to the file, closes the connection after 
				bw.write(printShark.getSizeFt() + ":" + printShark.getSmellsBlood()+ ":" + printShark.getCanSwim() + ":" + printShark.getHasScales() + "\n");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

static void read(String filePath){ // 
	

	try(BufferedReader reader = new BufferedReader(new FileReader(filePath));){
		
		String line = "";
		while((line = reader.readLine()) != null){
			System.out.println(line);
		}			
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
}


	}
	
	
	

