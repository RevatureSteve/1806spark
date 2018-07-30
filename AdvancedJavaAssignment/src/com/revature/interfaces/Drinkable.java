package com.revature.interfaces;

public interface Drinkable {

	boolean isDrinkable = true;
	
	public static void whatYouDrank(String brandName) {
		System.out.println("You are drinking " + brandName + "!");
		System.out.println("Must be delicious!");
	}
	
	void drank();

}
