package com.revature.pojo;

import com.revature.abstracts.House;

public class HouseA extends House{

	private boolean isTwoStoryHouse;
	private int numberOfWindows;

	public HouseA() {}
	
	public HouseA(boolean isTwoStoryHouse, int numberOfToothpicks, int livingSpace) {
		super();
		this.isTwoStoryHouse = isTwoStoryHouse;
		this.numberOfWindows = numberOfWindows;
		this.livingSpace = livingSpace;
	}



	@Override
	public int sublet() {
	System.out.println("Subleting space");
		return this.livingSpace;
	}
	
	
	@Override
	public void building() {
		System.out.println("Building a house");
	}
}
