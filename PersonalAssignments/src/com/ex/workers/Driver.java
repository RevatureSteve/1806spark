package com.ex.workers;

public class Driver {

	public static void main(String[] args) {
		System.out.println("here are my ");
		
		Workers fryCook = new Workers();
		fryCook.setMinAge(18);
		fryCook.setTypeOfWork("Fry Cook");
		fryCook.name = "Spongebob";
		
		Workers president = new Workers();
		president.setMinAge(40);
		president.setTypeOfWork("President");
		president.name = "Patrick";
		
		takeWorkers(president);
		takeWorkers(fryCook);
		
	}
	
	public static void takeWorkers(Workers workers) {
		System.out.println("my worker description: " + workers);
		
	}
}
