package com.revature.weapons;

import com.revature.Inventory;

import com.revature.abstracts.Weapons;

public class Staff extends Weapons implements Inventory{
	
	public Staff(int damage, String color) {
		super(damage, color);
		System.out.println("You've equip a staff");
	}

	@Override
	public void Attack() {
		// TODO Auto-generated method stub
		
	}
	
	public String cast() {
		System.out.println("You are casting a spell");
		return null;
		
	}
	
	public int slam() {
		System.out.println("You are slaming a monster");
		return 0;
		
	}

	@Override
	public void storeItem() {
		// TODO Auto-generated method stub
		
	}

}
