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

public class LabelD extends LabelB {

	public LabelD() {
		super();
		System.out.println("LabelD no-args constructor has been accessed");
	}

	public LabelD(String name, int attackLevel) {
		super(name, attackLevel);
		System.out.println("LabelD args constructor has been accessed");
	}

}
