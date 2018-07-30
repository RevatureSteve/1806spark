package com.revature.monday;
/**
 * LABELA is the bar POJO it includes 4 states beer, wine, food, and callTaxi
 * also 2 behaviors, eating and drinking
 */
import java.util.Arrays;

public abstract class LABELA {
	
	/* POJO - State, behavior, override toString* Requires 3 methods(1 concrete, 1 abstract), 2 properties, */
	//3 properties - variables
	private String [] beer;
	private String [] wine;
	private String food;
	private boolean callTaxi;
	
	public LABELA() {
		//NO-ARGS Constructor
	}
	
	
	public LABELA(String[] beer, String[] wine, String food, boolean callTaxi) {
		super();
		this.beer = beer;
		this.wine = wine;
		this.food = food;
		this.callTaxi = callTaxi;
	}
	public String[] getBeer() {
		return beer;
	}
	public void setBeer(String[] beer) {
		this.beer = beer;
	}
	public String[] getWine() {
		return wine;
	}
	public void setWine(String[] wine) {
		this.wine = wine;
	}
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	public boolean isCallTaxi() {
		return callTaxi;
	}
	public void setCallTaxi(boolean callTaxi) {
		this.callTaxi = callTaxi;
	}
	
	//Behavior
	public abstract void eating();
	public abstract void drinking();
	
	@Override
	public String toString() {
		return "LABELA [beer=" + Arrays.toString(beer) + ", wine=" + Arrays.toString(wine) + ", food=" + food
				+ ", callTaxi=" + callTaxi + "]";
	}
	
}
	
//	beer = new beer[4];
//	beer[0] = new Beer(1, "Miller Lite");
//	beer[1] = new Beer (2, "Orion");
//	beer[2] = new Beer(3, "Guinness");
//	beer[3] = new Beer(4, "Milwaukees Best Ice");
//	
//	for (int b = 0; b < beer.length; b++)
//		System.out.println("Have a nice cold " + b);
//
//	


