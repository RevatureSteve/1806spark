package com.revature;

import com.revature.abstracts.Sandwich;
import com.revature.pojo.Club;

//shortcut key for imports ctrl+shift+o;

public class Driver {

	public static void main(String[] args) {
		System.out.println("Going to create sandwiches");

//		Sandwich s = new Sandwich(); cannot instantiate abstract classes
		Sandwich c = new Club();
		c.startPrep();
		int size = c.takeBite();
		System.out.println(size);
	}

}
