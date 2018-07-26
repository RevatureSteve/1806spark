package com.ex.workers;

public class Workers {
	
	private String typeOfWork;
	public String name;
	private int minAge;
	
	//workers NO-ARGS
	public Workers() {}

	/*
	 * constructor 
	 */
	public Workers(String typeOfWork, String name, int minAge) {
		super();
		this.typeOfWork = typeOfWork;
		this.name = name;
		this.minAge = minAge;
	}
	/*
	 * getters and setters for typeOfWork and minAge
	 */
	public String getTypeOfWork() {
		return typeOfWork;
	}

	public void setTypeOfWork(String typeOfWork) {
		this.typeOfWork = typeOfWork;
	}

	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	/*
	 *(non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Workers [typeOfWork=" + typeOfWork + ", name=" + name + ", minAge=" + minAge + "]";
	}
	

	
	
	
	

}
