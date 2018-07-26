package com.revature.driver;

import com.revature.exceptions.NegativeArgumentException;
import com.revature.pojo.Pants;

//import com.revature.abstracts.Clothes;

import com.revature.pojo.Shirt;

public class Driver {
	
	public static void main(String[] args) {
		System.out.println("This is about shirts");
		Shirt myShirt = new Shirt(15, "wedding", true);
		Shirt myShirt2 = new Shirt();
		myShirt2.hasButtons = true;
		myShirt2.setOccassion("party");
		myShirt2.setSleeveLength(17);
		
		
		
		shirtsMethod(myShirt);
		
		
		Shirt s = new Shirt();
		int enteredCost = -100;
		if(enteredCost >= 0) {
			s.setCost(enteredCost);
			}else {
				throw new NegativeArgumentException("bad");
			}
		
		System.out.println(s.getCost());
		
		
		
		
		
		Pants myPants = new Pants();
		Pants myPants2 = new Pants(30, 32, "black");
		myPants2.lenght = 31;
		myPants2.setColor("Green");
		myPants2.setWaist(34);
		
		
		pantsMethod(myPants2);
		
		
		Pants p = new Pants();
		
		
	}
	
	public static void shirtsMethod(Shirt details) {
		System.out.println("Details about my shirt: " + details);
		System.out.println("Details about my shirt: " + details.hasButtons);

}
	
	
	public static void pantsMethod(Pants details) {
		System.out.println(details);
	}
	
	
	
	
	
	
	
	

}