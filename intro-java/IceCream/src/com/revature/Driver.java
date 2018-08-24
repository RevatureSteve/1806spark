package com.revature;

import com.revature.pojo.Cup;
import com.revature.pojo.Cone;
import com.revature.pojo.Sandwich;

public class Driver {
	
	public static void main(String[] args) {
		System.out.println("Going to get icecream!");
		Cone cone1 = new Cone();
		try {
			cone1.setScoops(0);
		} catch (TooFewArgumentException e) {
			e.printStackTrace();
		}
		try {
			cone1.setFlavor("");
		} catch (NoFlavorException e) {
			e.printStackTrace();
		}
		Cone cone2 = new Cone("chocolate", 2.0, "waffle");
		System.out.println();
		cone2.takeBite(0.8);
		System.out.println();
		cone2.takeBite(0.5);
		System.out.println();
		cone2.takeBite(0.2);
		
	}
}
