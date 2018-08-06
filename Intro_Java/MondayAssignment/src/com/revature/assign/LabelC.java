package com.revature.assign;

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

public class LabelC extends LabelA implements Action {

	private String furColor;
	private int defenseLevel;

	public LabelC() {
		System.out.println("LabelC no-args constructor has been accessed");
	}

	public LabelC(String furColor, int defenseLevel) {
		this.furColor = furColor;
		this.defenseLevel = defenseLevel;
		System.out.println("LabelC args constructor has been accessed");
	}

	public String getFurColor() {
		return furColor;
	}

	public void setFurColor(String furColor) throws Exception {
		if (furColor == null) {
			throw new Exception();
		} else {
			this.furColor = furColor;
		}
	}

	public int getDefenseLevel() {
		return defenseLevel;
	}

	public void setDefenseLevel(int defenseLevel) {
		if (defenseLevel < 0) {
			throw new RuntimeException();
		} else {
			this.defenseLevel = defenseLevel;
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
		return "LabelC [furColor=" + furColor + ", defenseLevel=" + defenseLevel + "]";
	}

}
