package com.revature.classes;

@SuppressWarnings("serial")
public class LabelABext extends LabelAB{
	private int accessTimes;
	public LabelABext(int sum, int accessTimes, int a, int b) {
		super(sum, a, b);
		this.accessTimes = accessTimes;
	}
	@Override
	public String toString() {
		return super.toString() + "LabelABext [accessTimes=" + accessTimes + "]";
	}	
	
	
}
