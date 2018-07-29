package com.revature;

public class Launch {

	public static void main(String[] args) { 
		System.out.println("printing fish"); 
		
		Shark s = new Shark(true, 15); //creating a shark object
		System.out.println(s); // prints out new shark object
		
			int userInput = 0;
			s.setSizeFt(userInput);// this is risky code, the sizeFT can not be less than 10!
		
		Grouper g = new Grouper(true, "great"); // creating a new grouper object
		System.out.println(g); //print out that grouper object
		
		try {
			g.setHowsTaste(""); // I said I don't want an empty string so this is risky code
		} catch (WrongTasteException e) { // catch it with this error
			e.printStackTrace(); // print the message I said to print
		}
		
		
	}
	
	
	
}
