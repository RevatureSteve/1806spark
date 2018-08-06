package com.revature.assign;

import java.io.Serializable;

/**
 * 
 * @author Eddie
 *
 *		Extend 2 classes LABEL B, C from that abstract class (LABEL A)
 *         -Implement the interface 
 *         -Provide 2 additional Methods 
 *         -Provide a constructor that will Sysout 
 *         -Add 2 throws exception declaration to 2 methods, 1 checked, 1 unchecked
 * 
 */

public class LabelB extends LabelA implements Action, Serializable {

	private String name;
	private int attackLevel;

	public LabelB() {
		System.out.println("LabelB no-args constructor has been accessed");
	}

	public LabelB(String name, int attackLevel) {
		this.name = name;
		this.attackLevel = attackLevel;
		System.out.println("LabelB args constructor has been accessed");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws Exception {
		if (name == null) {
			throw new Exception();
		} else {
			this.name = name;
		}
	}

	public int getAttackLevel() {
		return attackLevel;
	}

	public void setAttackLevel(int attackLevel) {
		if (attackLevel < 0) {
			throw new RuntimeException();
		} else {
			this.attackLevel = attackLevel;
		}
	}

	@Override
	public void standGround() {

	}

	@Override
	public void evolve() {

	}

	@Override
	public String toString() {
		return "LabelB [name=" + name + ", attackLevel=" + attackLevel + "]";
	}

}
