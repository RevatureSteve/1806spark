package com.revature.classes;

import com.revature.abstracts.LabelA;
import com.revature.interfaces.LabelCupcake;

public class LabelAB extends LabelA implements LabelCupcake{
	private int result;
	

	/**
	 * @param sum
	 */
	public LabelAB(int sum, int a, int b) {
		super(a,b);
		System.out.println(this.toString());
	}

	public int getResult() {
		return result;
	}
	
	@Override
	public int subtract() throws Exception{
		result = this.getA() - this.getB();
		if(result<0) {
			throw new Exception();
		}
		return result;
		
	}

	@Override
	public int divide() throws RuntimeException{
		if(getB()==0) {
			throw new RuntimeException();
		}
		return result = this.getA() / this.getB();
	}
	
	public boolean areSame() {
		if(this.getA()==this.getB()) {
			return true;
		}
		return false;
	}
	
	public void flip() {
		int temp = this.getA();
		this.setA(this.getB());
		this.setB(temp);
	}

	@Override
	public String toString() {
		return super.toString() + "LabelAB [result=" + result + "]";
	}

	@Override
	public boolean likesCupcakes() {
		if(result>2) {
			return true;
		}
		return false;
	}
	
	

}
