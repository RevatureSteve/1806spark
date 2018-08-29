package com.revature;

import com.revature.abstracts.Clothes;

public class Dresses extends Clothes implements Wardrobe{
	
	public Dresses() {}
	public Dresses(int size, String color) {
		super(size, color);
		System.out.println("This dress rocks");
	}

	@Override
	public void Inventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Wearable() {
		// TODO Auto-generated method stub
		
	}

}
