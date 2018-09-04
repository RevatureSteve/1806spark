package com.revature.bean;

public class Engine {
	
	private boolean works;

	public Engine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Engine(boolean works) {
		super();
		this.works = works;
	}

	public boolean isWorks() {
		return works;
	}

	public void setWorks(boolean works) {
		this.works = works;
	}

	@Override
	public String toString() {
		return "Engine [works=" + works + "]";
	}
	
	

}
