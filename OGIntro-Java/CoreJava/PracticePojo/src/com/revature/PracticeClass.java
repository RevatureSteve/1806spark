package com.revature;

public class PracticeClass {
	private Boolean isTall;
	private String name;
	@Override
	public String toString() {
		return "PracticeClass [isTall=" + isTall + ", name=" + name + "]";
	}
	public Boolean getIsTall() {
		return isTall;
	}
	public void setIsTall(Boolean isTall) {
		this.isTall = isTall;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
