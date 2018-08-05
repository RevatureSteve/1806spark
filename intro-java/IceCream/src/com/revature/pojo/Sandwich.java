package com.revature.pojo;

import com.revature.abstracts.Icecream;

public class Sandwich extends Icecream{

	private String cookie;
	
	public Sandwich() {
		super();
	}

	public Sandwich(String cookie) {
		super();
		this.cookie = cookie;
	}

	@Override
	public void servedIn() {
		System.out.println("Your Icecream will be served as a sandwich.");
	}
	
	public double takeBite(double biteSize) {
		if(biteSize > 0.4 && biteSize < 0.8) {
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