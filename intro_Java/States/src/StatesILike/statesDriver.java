package StatesILike;

import StatesILike.statesIlike;	

public class statesDriver {
	
	public static void main(String[] args) {
		
		System.out.println("States I like....enjoy");
		statesIlike Florida = new statesIlike("Florida", 7677886, 26);
		statesIlike Georgia = new statesIlike ();
		Georgia.setName("Georgia");
		Georgia.setPopulation(2000000000);
		Georgia.setTimesVisited(567);
		
		 travelstates(Florida);
		 travelstates(Georgia);
		 
	}
	
	public static void travelstates(statesIlike statesIlike) {
		System.out.println("I always end up travelling to the south to visit " + statesIlike);
		 
				
	
	}

}
