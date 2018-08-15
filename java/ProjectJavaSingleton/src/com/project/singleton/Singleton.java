package com.project.singleton;

import com.project.Interface.WorkingWithInterface;

/*
 *  step to create a singleton
 *  1. name constructor with same name after the class
 *  2. generate getter and setter and place them after the constructor 
 *  3. i will need a method to create and return .instance (before i create it i will need somewhere to store it)
 *  4. before #3 i will need private static Singleton instance variable
 */

public class Singleton  implements WorkingWithInterface { // implements was created with 
	// put state/field/ variables here
	private int won = 10;
	private boolean isAlive;
	private static Singleton instance; // singleton is the data type and instance is the variable.. and what ever is in singleton class will be stored in the instance variable
	
	
	private Singleton() {
	//constructor dont have return type
	// and they have the same name as class
		// no args constructor
	}
	
	public static Singleton getInsatnce() { // this will need to be public static Singleton( this will be an return type) 
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
		
	private Singleton(int won, boolean isAlive) { 
		super(); 
		this.won = won;
		this.isAlive = isAlive;
	}

	// place getter and setter below the constructor convention
	
	public int getWon() { // this will get won and what ever the value is will be return
		return won;
	} 


	public void setWon(int won) {
		this.won = won;  // shadowing is when you have two variable with the same name 
	}


	public boolean isAlive() {
		return isAlive;
	}


	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	@Override
	public String toString() {
		return "Singleton [won=" + won + ", isAlive=" + isAlive + "]";
	}

	@Override
	public void helloInterface() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean helloWorld(int player) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
