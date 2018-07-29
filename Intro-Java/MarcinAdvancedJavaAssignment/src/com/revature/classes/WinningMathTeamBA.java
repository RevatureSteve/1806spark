package com.revature.classes;

public class WinningMathTeamBA extends MathTeamBA{
	/**
	 * 
	 */
	private static final long serialVersionUID = 589230420930654746L;
	private int x;

	/**
	 * @param x
	 */
	public WinningMathTeamBA(int x, int a, int b) {
		super(a,b);
		this.x = x;
	}

	@Override
	public String toString() {
		return super.toString() + "WinningMathTeamBA [x=" + x + "]";
	}
}
