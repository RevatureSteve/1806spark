package com.practice2;

public class Cars {
	
	private String engine;
	public int doors;
	private boolean isGasoline;
	
	public Cars() {}

	public Cars(String engine, boolean isGasoline) {
		super();
		this.engine = engine;
		this.doors = doors;
		this.isGasoline = isGasoline;
	}


	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public boolean isGasoline() {
		return isGasoline;
	}

	public void setGasoline(boolean isGasoline) {
		this.isGasoline = isGasoline;
	}

	@Override
	public String toString() {
		return "Cars [engine=" + engine + ", doors=" + doors + ", isGasoline=" + isGasoline + "]";
	}
	
	
}
