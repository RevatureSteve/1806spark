package com.revature.pojo;

import com.revature.abstracts.Icecream;
import java.util.Random;

public class Cone extends Icecream{

	private String coneType;

	public Cone() {
		super();
	}

	
	
	public Cone(String flavor, double scoops, String coneType) {
		super(flavor, scoops);
		this.coneType = coneType;
	}



	@Override
	public void servedIn() {
		System.out.println("Your Icecream will be served in a cone. Be careful not to drop it.");
	}
	
	public double takeBite(double biteSize) {
		System.out.println("*you ate " + biteSize + " of a scoop*");
		Random rand = new Random();
		int dropChance = rand.nextInt(10);
		if(dropChance == 9) {
			System.out.println("Uh Oh you dropped the cone D:");
			this.scoops = 0;
			return this.scoops;
		}
		if(biteSize > 0.4 && biteSize < 0.76) {
			System.out.println("You ate too much too fast. You got a brain freeze. :(");
			this.scoops -= biteSize;
		} else if (biteSize > 0.75) {
			System.out.println("There is no way you can eat that much at once! O.o");
		} else {
			this.scoops -= biteSize;
		}
		return this.scoops;
	}
}
