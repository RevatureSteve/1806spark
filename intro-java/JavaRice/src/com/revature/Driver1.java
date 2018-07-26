package com.revature;


public class Driver1 {

	public static void main(String[] args) {
		System.out.println("Going to make different types of Rice");
		Rice friedRice = new Rice("fried Rice", "pork");
		Rice whiteRice = new Rice();
		whiteRice.setName("White-Rice");
		whiteRice.setType("not pork");
		whiteRice.size = 2;
		
		makeRice(friedRice);
	}
	public static void makeRice(Rice rice) {
		System.out.println("My rice argument:" + rice);
		System.out.println("the size:" + rice.size);
	}
}
