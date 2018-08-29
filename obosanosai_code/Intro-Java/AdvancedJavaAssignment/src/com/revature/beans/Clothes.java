package com.revature.beans;

import java.io.Serializable;

import com.revature.abstracts.Wearable;

/*
 * Clothes Class is not just a pojo
 * Clothes Class is a JavaBean - stricter version of pojo
 * 
 *         1. state must be fully encapsulated
 *         2. provide getters and setters where needed
 *         3. must have a no-args constructor
 *         4. class must implement Serializable 
 *         5. override toString()
 */
public class Clothes implements Serializable, Wearable {
	
	private static final long serialVersionUID = 102;
	private int itemnum;
	private String name;
	
	
	public Clothes() {}

	public Clothes(int itemnum, String name) {
		super();
		this.itemnum = itemnum;
		this.name = name;
	}
	@Override
	public void wear() {
		System.out.println("Clothes are worn");
		
	}
	public int getItemnum() {
		return itemnum;
	}

	public void setItemnum(int itemnum) {
		this.itemnum = itemnum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Clothes [itemnum=" + itemnum + ", name=" + name + "]";
	}
	
}
	
