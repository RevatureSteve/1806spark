package com.revature;

public class Rice {
	private String name;
	private String type;
	public int size;
	private boolean isTasty;
	
	
	public Rice() {}
	
	public Rice(String name, String type) {
		super();
		this.name = name;
		this.type = type;
		
		}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isTasty() {
		return isTasty;
	}

	public void setTasty(boolean isTasty) {
		this.isTasty = isTasty;
	}

	@Override
	public String toString() {
		return "Rice [name=" + name + ", type=" + type + ", isTasty=" + isTasty + "]";
	}

	

}
