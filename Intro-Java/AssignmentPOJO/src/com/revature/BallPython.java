package com.revature;
import com.revature.Reptile;
public class BallPython extends Reptile{

	//state
	private Boolean isSpotted;
	private Boolean canConstrict;
	
	// No-arg must be created for POJO
	public BallPython() {}
	
	@Override
	public String[] feedRat() {
		System.out.println("Feeding a rat to which reptile???");
		return this.name;
	}
	
	@Override
	public Boolean heatResistance() {
		System.out.println("can you survive the heat?");
		return this.coldBlooded;
	}
	
}

	