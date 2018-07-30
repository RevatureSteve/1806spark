package com.revature.monday;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class MAINCLASS {
	
	public static void main(String[] args) {
	
	
		System.out.println("DancingThreads");
		
		Thread t1 = new ChildThread();
		t1.start();
		
		DancingTh dtr = new DancingTh();
		Thread t2 = new Thread(dtr);
		t2.start();
		
		
		
	//Concrete method from RobotWaiterInterface
	RobotWaiterInterface.robotBouncer();
	
	//Abstract Method from RobotWaiterInterface
	BarPresentationUtil greet = new BarPresentationUtil();
	greet.robotWaiter();
	

	
	
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			
			BarPresentationUtil.talkToServer();
			int userInput = scan.nextInt();
			
			System.out.println("You have selected " + userInput + " Processing...beep, boop");
			switch (userInput) {
			case 1:
				System.out.println("Here's Your Beer!");
				break;
			case 2:
				System.out.println("Here's Your Wine!");
				break;
			case 3:
				System.out.println("Here's Your Food!");
				break;
			case 4:
				System.out.println("Your taxi has arrived, Goodbye!");
				System.exit(1);
				break;
			case 5:
				System.out.println(RobotWaiterInterface.singKaraoke);
				break;
			case 6:
				String receipt = "src/com/revature/monday/persistToFile.txt";
				writeCharacterStream(receipt);
				readCharacterStream(receipt);
				break;
			case 7:
				userCheckInfoPersist();
				return;
		
				
				
				
				
				
			}
		}

		
		
}

	private static void readCharacterStream(String receipt) {
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(receipt));){
			
			writer.write("Thank You for your purchase");
			writer.write("Your Confirmation number is 123456789");
		
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void writeCharacterStream(String receipt) {
		try(BufferedReader reader = new BufferedReader(new FileReader(receipt));){
			
			String line = "";
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		}
		
	public static void userCheckInfoPersist() {
		
		ReceiptSerializable yourCheck = BarPresentationUtil.createNewCheck();
		
//		try {
		ReceiptDao.serializeCheck(yourCheck);
//	}catch (IOException e) {
		BarPresentationUtil.errorView("Corrupt File");}
	
		
	public static void getDisplayCheck() {
		ReceiptSerializable yourCheck = ReceiptDao.deserializeCheck();
		BarPresentationUtil.presentCheck(yourCheck);
	}
		
	}

	
		
	
	

