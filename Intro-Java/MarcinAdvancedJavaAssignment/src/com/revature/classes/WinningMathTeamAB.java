package com.revature.classes;


public class WinningMathTeamAB extends MathTeamAB{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3879437655609244502L;
	private int accessTimes;
	public WinningMathTeamAB(int accessTimes, int a, int b) {
		super(a, b);
		this.accessTimes = accessTimes;
	}
	@Override
	public String toString() {
		return super.toString() + "WinningMathTeamAB [accessTimes=" + accessTimes + "]";
	}
			
}
