package com.ex.ramen;

public class Ramen {
	
	private String type;
	public boolean vegeatarian;
	public boolean spiceBomb;
	
	public Ramen() {}

	public Ramen(String type, boolean vegeatarian, boolean spiceBomb) {
		super();
		this.type = type;
		this.vegeatarian = vegeatarian;
		this.spiceBomb = spiceBomb;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Ramen [type=" + type + ", vegeatarian=" + vegeatarian + ", spiceBomb=" + spiceBomb + "]";
	}
	
}
