package com.revature.practice;

public class Launcher {
	
	public static void main(String[] args) {
		
		IceCream vanilla = new IceCream();
		IceCream chocolate = new IceCream("chocolate", true, 3);
		
		try {
			vanilla.setFlavor("vanilla");
		} catch (NoNull e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		vanilla.setNumberOfScoopes(-1);
		
		
		
		
		vanilla.sprinkles = false;
		
		System.out.println(vanilla.toString());
		System.out.println(chocolate.toString());
		
		
		
	}
	
	public static void makeIceCream(IceCream pop) {
		
		System.out.println(pop);
		
		
	}
	
	

}
