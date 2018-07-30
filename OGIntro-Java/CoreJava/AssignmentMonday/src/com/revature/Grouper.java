package com.revature;

public class Grouper extends Fish implements Splash{

	private boolean isLazy = true;
	
	private String howsTaste = "great";
	
	
	public Grouper(boolean isLazy, String howsTaste, Boolean canSwim, Boolean HasScales) {
		super(canSwim, HasScales);
		this.isLazy = isLazy;
		this.howsTaste = howsTaste;
		System.out.println("okay, this should taste good");
	}

	public Grouper(Boolean canSwim, Boolean hasScales) {
		super(canSwim, hasScales);
	}

	public boolean isLazy() {
		return isLazy;
	}

	public void setLazy(boolean isLazy) {
		this.isLazy = isLazy;
	}

	public String getHowsTaste() {
		return howsTaste;
	}

	public void setHowsTaste(String howsTaste) throws WrongTasteException {
		this.howsTaste = howsTaste;
		if(howsTaste.equals("")) {
			System.out.println("enter SOMETHING about the taste, (preferrably, great)");
		}
		
	}

	private void gulp() {
		
	}
	
	private void sitNWait() {
		
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
