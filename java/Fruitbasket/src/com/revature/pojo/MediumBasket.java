package com.revature.pojo;

import com.revature.basket.InBasket;

public class MediumBasket extends InBasket {
	
	public int someFruit = 4; 

	@Override
	public void makeBAsket() {
		// TODO Auto-generated method stub
		
	}

	public MediumBasket(String name) {
		super();
		this.name = name;
		// TODO Auto-generated constructor stub
	}

	public MediumBasket(String name, int apple, int banana, boolean juice, int cherry, int grape) {
		super(name, apple, banana, juice, cherry, grape);
		// TODO Auto-generated constructor stub
		if (someFruit == 4 && someFruit  <=6) {
			System.out.println("this is a Medium basket");
		}
		else if (someFruit < 4 || someFruit >8) {
			System.out.println("Are you paying etra For that basket");
		}
	}

	public MediumBasket(int someFruit) {
		super();
		this.someFruit = someFruit;
	}
	
	
	
	

}
