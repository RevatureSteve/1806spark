package com.revature.pojo;

import com.revature.basket.InBasket;

public class LargeBasket extends InBasket{
	
	public int someFruit= 4;
 
	@Override
	public void makeBAsket() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "LargeBasket [name=" + name + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public LargeBasket(String name) {
		super();
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	public LargeBasket(String name, int apple, int banana, boolean juice, int cherry, int grape) {
		super(name, apple, banana, juice, cherry, grape);
		// TODO Auto-generated constructor stub
		this.name = name; 
		
		if (someFruit >1 && someFruit <= 4) {
			System.out.println("this is a Medium basket");
		}
		else if (someFruit < 1 || someFruit >4) {
			System.out.println("Are you paying etra For that basket");
		}
	}

	public LargeBasket(int someFruit) {
		super();
		this.someFruit = someFruit;
	}
	
	

//	public boolean isAllFruit() {
////		if(allFruit != null) {
////			
////		}
//		return allFruit;
//	}
//
//	public void setAllFruit(boolean allFruit) {
//		this.allFruit = allFruit;
//		
//	}
	
	

}
