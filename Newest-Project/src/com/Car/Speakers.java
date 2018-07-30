//E

package com.Car;

public class Speakers extends Sedan {

	private int speakers;
	
    public Speakers() {}

	public Speakers(int advancedFeatures, int cylinder, int seats, String model, int speakers) {
		super(advancedFeatures, cylinder, seats, model);
		this.speakers = speakers;
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
    
    
	
}
