package com.revature.assign;

/**
 * 
 * @author Eddie
 *
 * 		Extend 2 SubClasses LABEL D, E one from each of the previous classes (LABEL B,C)
 * 			-Provide a Constructor that Calls Super Constructor and Sysout afterwards
 * 			-Check the inherited methods and the exceptions
 * 
 */

public class LabelE extends LabelC {

	public LabelE() {
		super();
		System.out.println("LabelE no-args constructor has been accessed");
	}

	public LabelE(String furColor, int defenseLevel) {
		super(furColor, defenseLevel);
		System.out.println("LabelE args constructor has been accessed");
	}

}
