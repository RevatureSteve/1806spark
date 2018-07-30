package com.revature.pojo;

import javax.swing.plaf.synth.SynthScrollBarUI;

import com.revature.basket.InBasket;

public class SmallBasket extends InBasket{
	public int someFruit = 4;

	public SmallBasket() {
		//no-args
	};
	
	@Override
	public void makeBAsket() {
		// TODO Auto-generated method stub
		System.out.println("the smallest basket");
		return;
		
	}

	public SmallBasket(String name, int apple, int banana, boolean juice, int cherry, int grape) {
		super(name, apple, banana, juice, cherry, grape);
		// TODO Auto-generated constructor stub
		
		if (someFruit >1 && someFruit <= 4) {
			System.out.println("this is a Medium basket");
		}
		else if (someFruit < 1 || someFruit >4) {
			System.out.println("Are you paying etra For that basket");
		}
	}
	
	
	
	
	

}
