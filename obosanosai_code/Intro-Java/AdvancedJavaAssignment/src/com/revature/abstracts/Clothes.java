package com.revature.abstracts;

import com.revature.Unchecked;
import com.revature.Wardrobe;

public abstract class Clothes implements Wardrobe {

	private int size;
	private String color;
	
	
	public Clothes() {}
	
	public Clothes(int size, String color) {
		this.size = size;
		this.color = color;
	}
	public abstract void Wearable();{
		
		
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size)throws Unchecked {
		if(size < 0) {
			throw new Unchecked ();
		}
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Clothes [size=" + size + ", color=" + color + "]";
	}
	
	
	
}
