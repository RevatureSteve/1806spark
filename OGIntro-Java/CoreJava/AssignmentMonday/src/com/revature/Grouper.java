package com.revature;

public class Grouper extends Fish implements Splash{

	private boolean isLazy = true;
	
	private String howsTaste = "great";
	
	
	public Grouper(boolean isLazy, String howsTaste) {
		super();
		this.isLazy = isLazy;
		this.howsTaste = howsTaste;
		System.out.println("okay, this should taste good");
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
			throw new WrongTasteException();
		}
		
	}

	private void gulp() {
		
	}
	
	private void sitNWait() {
		
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
