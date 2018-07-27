package com.revature;
import com.revature.Reptile;
public class BallPython extends Reptile{

	//state
	private Boolean isSpotted;
	private Boolean canConstrict;
	
	
	// No-arg must be created for POJO
	public BallPython() {}
	
	@Override // use this method instead of the parent method
	public String feedRat() { 
		System.out.println("Feeding a rat to which reptile???");
		return this.name;
	}
	
	@Override // also use this method instead of the parent method
	public Boolean heatResistance() {
		System.out.println("can you survive the heat?");
		return this.coldBlooded;
	}

	@Override // overrides toString method to make object readable (toString makes more sense)
	public String toString() {
		return "BallPython [isSpotted=" + isSpotted + ", canConstrict=" + canConstrict + ", coldBlooded=" + coldBlooded
				+ ", name=" + name + "]";
	}
	
	
}

	