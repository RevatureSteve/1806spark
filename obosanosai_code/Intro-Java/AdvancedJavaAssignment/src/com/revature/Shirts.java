package com.revature;

import com.revature.abstracts.Clothes;

public class Shirts extends Clothes implements Wardrobe{

	/**
	 * 
	 */
	private static final long serialVersionUID = 30158212446158092L;

	public Shirts() {}
	
	public Shirts(int size, String color) {
		super(size, color);
		System.out.println("This is a cool Shirt");
	}
	@Override
	public void Inventory() {
		// TODO Auto-generated method stub Pp
		
	}

	@Override
	public void Wearable() {
		// TODO Auto-generated method stub
		
	}

}
