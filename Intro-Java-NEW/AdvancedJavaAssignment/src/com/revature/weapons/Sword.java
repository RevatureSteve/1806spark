package com.revature.weapons;

import com.revature.Inventory;

import com.revature.abstracts.Weapons;

public class Sword extends Weapons implements Inventory{

	public Sword(int damage, String color) {
		super(damage, color);
		System.out.println("You've equip a new sowrd!");
	}

	public int slash() {
		System.out.println("You are slashing a monster");
		return 0;
		
	}
	
	public int stab() {
		System.out.println("You are stabing a monster");
		return 0;
		
	}


	@Override
	public void Attack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void storeItem() {
		// TODO Auto-generated method stub
		
	}

}
