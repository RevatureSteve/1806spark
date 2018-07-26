package com.revature.abstracts;

import com.revature.NoFlavorException;
import com.revature.TooFewArgumentException;

public abstract class Icecream {
	private String flavor;
	public double scoops;

	public abstract void servedIn();

	public Icecream() {
		super();
	}

	public Icecream(String flavor, double scoops) {
		super();
		this.flavor = flavor;
		this.scoops = scoops;
	}

	public double takeBite() {
		this.scoops = scoops - 0.2;
		return this.scoops;
	}

	public double takeBite(double biteSize) {
		if (biteSize > 0.4 && biteSize < 0.8) {
			System.out.println("You ate too much too fast. You got a brain freeze. :(");
			this.scoops -= biteSize;
		} else if (biteSize > 0.75) {
			System.out.println("There is no way you can eat that much at once! O.o");
		} else {
			this.scoops -= biteSize;
		}
		return this.scoops;
	}

	public double getScoops() {
		return scoops;
	}

	public void setScoops(double scoops) throws TooFewArgumentException {
		if (scoops <= 0) {
			System.out.println("Oh come now, you cant have anything less than one scoop. Ill give you one.");
			this.scoops = 1;
			throw new TooFewArgumentException();
		} else {
			this.scoops = scoops;
		}
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) throws NoFlavorException{
		if (flavor == "") {
			System.out.println("Sorry we dont serve flavorless icecream. Ill give you Vanilla.");
			this.flavor = "vanilla";
			throw new NoFlavorException();
		} else {
			this.flavor = flavor;
		}
	}

}
