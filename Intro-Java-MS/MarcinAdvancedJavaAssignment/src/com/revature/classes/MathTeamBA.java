package com.revature.classes;

import com.revature.abstracts.MathTeam;
import com.revature.interfaces.LikeCupcakes;

public class MathTeamBA extends MathTeam implements LikeCupcakes {
	/**
	 * 
	 */
	private static final long serialVersionUID = -21256899232690364L;
	private int numOfSubs;

	/**
	 * @param startValue
	 */
	public MathTeamBA(int a, int b) {
		super(a,b);
		numOfSubs = 0;
		
	}

	public int getNumOfSubs() {
		return numOfSubs;
	}

	@Override
	public int subtract() throws Exception {
		numOfSubs++;
		int sum = this.getB() - this.getA();
		if (sum < 0) {
			throw new Exception();
		}
		return this.getB() - this.getA();
	}

	@Override
	public int divide() throws RuntimeException {
		if (getA() == 0) {
			throw new RuntimeException();
		}
		return getB() / getA();
	}

	

	@Override
	public String toString() {
		return super.toString() + "MathTeamBA [numOfSubs=" + numOfSubs + "]";
	}

	@Override
	public boolean likesCupcakes() {
		if (numOfSubs > 2) {
			return true;
		}
		return false;
	}

}
