package com.revature.basket;
// in basket will be a template for what fruits can go inside the basket

/*
 * what should be in the basket
 * 
		 * -apple how many
		 * -banana how many and size
		 * -grape
		 * -cherry
		 * 
		 * 3 type of fruit basket
		 *  1 large fruit basket
		 *  2 medium fruit basket 
		 *  3 small fruit basket
		 * 
 * 
 */

public abstract class InBasket {
	
	//stake aka variables
	public String name;
	private int apple;
	private  int banana;
	private boolean juice;
	private int cherry;
	private int grape;


public InBasket() {
	//NO-argus constructor	
}





// behavior 
public abstract void makeBAsket();
// this is an abstract method need no-args





public InBasket(String name, int apple, int banana, boolean juice, int cherry, int grape) {
	super();
	this.name = name;
	this.apple = apple;
	this.banana = banana;
	this.juice = juice;
	this.cherry = cherry;
	this.grape = grape;
}





public int getApple() {
	return apple;
}





public void setApple(int apple) {
	this.apple = apple;
}





public int getBanana() {
	return banana;
}





public void setBanana(int banana) {
	this.banana = banana;
}





public boolean isJuice() {
	return juice;
}





public void setJuice(boolean juice) {
	this.juice = juice;
}





public int getCherry() {
	return cherry;
}





public void setCherry(int cherry) {
	this.cherry = cherry;
}





public int getGrape() {
	return grape;
}





public void setGrape(int grape) {
	this.grape = grape;
}





}
