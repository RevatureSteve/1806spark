package com.revature.abstracts;

import java.io.Serializable;

import com.revature.Inventory;
import com.revature.exceptions.CheckedException;
import com.revature.exceptions.UncheckedException;

public abstract class Weapons implements Inventory, Serializable {
	
	private static final long serialVersionUID = 123;
	
	private int damage;
	private String color;
	
	public Weapons() {
		super();
	}
	
	public Weapons(int damage, String color) {
		this.damage = damage;
		this.color = color;
	}
	
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		if(damage < 0) {
			throw new UncheckedException();
		}
		this.damage = damage;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) throws CheckedException {
		if(color == null) {
			throw new CheckedException();
		}
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Weapons [damage=" + damage + ", color=" + color + "]";
	}
	
	public abstract void Attack();
	
}

