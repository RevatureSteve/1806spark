package com.revature;

public interface Inventory {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
	int level = 9000;
	
	public abstract void storeItem();
	
	default void equipItem() {
		System.out.println("Equip Item....");
	}

}