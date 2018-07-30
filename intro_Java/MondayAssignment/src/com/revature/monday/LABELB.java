package com.revature.monday;

public class LABELB extends LABELA implements RobotWaiterInterface {
	
	//State
	private boolean isCold;
	private double cost;
	
	//NO-ARG
	
	public LABELB () {
		
	}

	public LABELB(boolean isCold, double cost) {
		super();
		this.isCold = isCold;
		this.cost = cost;
	if(isCold = true) {
		System.out.println("Here's your ice cold beer!");
	}else {
		System.out.println("Sorry we just put this in the cooler");
	}
	if(cost > 3.00) {
		System.out.println("Here's a Tallboy");
	}else {
		System.out.println("Here's our " + cost + " Special");
	}
	
	}

	@Override
	public void eating() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drinking() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void robotWaiter() {
		System.out.println("Saying something else");
		
	}

}
