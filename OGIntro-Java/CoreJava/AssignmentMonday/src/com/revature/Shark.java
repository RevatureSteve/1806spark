package com.revature;

public class Shark extends Fish implements Splash{

	private boolean smellsBlood = true;
	
	private int sizeFt = 15;
	
	
	
	public boolean isSmellsBlood() {
		return smellsBlood;
	}

	public void setSmellsBlood(boolean smellsBlood) {
		this.smellsBlood = smellsBlood;
	}

	public int getSizeFt() {
		return sizeFt;
		
		
	}
	

	public void setSizeFt(int sizeFt) throws WrongSizeException {
		this.sizeFt = sizeFt; //the sizeFt for the new instantiated shark will equal this variable
		if (sizeFt < 10) { // if the sizeFt is less than 10
			System.out.println("BIG SHARKS ONLY");// then print out this
			this.sizeFt = 10; // and change the sizeFt to 10
			throw new WrongSizeException(); // then throw this Exception
		}else { // if it equals anything else
			this.sizeFt = sizeFt; // then make the sizeft equal to whatever it is
		}
	}

	public Shark(boolean smellsBlood, int sizeFt) {
		super();
		this.smellsBlood = smellsBlood;
		this.sizeFt = sizeFt;
		System.out.println("okay, you're gonna die");
	}

	private void bite() {
		
	}
	
	private void quickSwim () { 
		
	}
	
	
	
	
	@Override
	public void splash() {
		
		
	}

	@Override
	public void swim() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Splash start() {
		// TODO Auto-generated method stub
		return null;
	}

}
