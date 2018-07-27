package com.revature.classes;

public class LabelBAext extends LabelBA{
	private int x;

	/**
	 * @param x
	 */
	public LabelBAext(int x, int a, int b) {
		super(a,b);
		this.x = x;
	}

	@Override
	public String toString() {
		return super.toString() + "LabelBAext [x=" + x + "]";
	}
}
