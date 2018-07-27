package com.revature.classes;

import com.revature.abstracts.LabelA;
import com.revature.interfaces.LabelCupcake;

public class LabelBA extends LabelA implements LabelCupcake {
	private int numOfSubs;

	/**
	 * @param startValue
	 */
	public LabelBA(int a, int b) {
		super(a,b);
		numOfSubs = 0;
		System.out.println(this.toString());
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
		return super.toString() + "LabelBA [numOfSubs=" + numOfSubs + "]";
	}

	@Override
	public boolean likesCupcakes() {
		if (numOfSubs > 2) {
			return true;
		}
		return false;
	}

}
