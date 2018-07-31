//E

package com.Car;

public class Speakers extends Sedan implements Car {

	private int speakers;
	
    public Speakers() {}

	public Speakers(int advancedFeatures, int cylinder, int seats, String model, int speakers) {
		super(advancedFeatures, cylinder, seats, model);
		this.speakers = speakers;
		System.out.println(drive());
	}

	public int getSpeakers() {
		return speakers;
	}

	public void setSpeakers(int speakers) {
		this.speakers = speakers;
	}

	@Override
	public String toString() {
		return super.toString() + "Speakers [speakers=" + speakers + "]";
	}
	@Override
	public String drive() {
		return "Your Sedan is in your inventory!";
		
	}
    
    
	
}
