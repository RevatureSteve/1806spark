package com.ex.ramen;

public class Driver {
	
	public static void main(String[] args) {
		System.out.println("Ramens of the Day");
		
		Ramen shoryu = new Ramen();
		shoryu.setType("Shoryu");
		shoryu.vegeatarian = false;
		shoryu.spiceBomb = true;
		
		Ramen miso = new Ramen();
		miso.setType("Miso");
		miso.vegeatarian = true;
		miso.spiceBomb = false;
		
		
		takeRamen(shoryu);
		takeRamen(miso);
	}

	private static void takeRamen(Ramen ramen) {
		System.out.println("here is your " + ramen);
	}
	

}
