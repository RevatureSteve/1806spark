package com.revature.abstracts;

public abstract class Attractions {
	
	public String name;
	private boolean isOpen;
	
	public Attractions() {
		
	}
	
	

	public Attractions(String name, boolean isOpen) {
		this.name = name;
		this.isOpen = isOpen;
	}



	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	
	
}
