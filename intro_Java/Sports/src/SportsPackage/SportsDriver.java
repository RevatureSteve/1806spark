package SportsPackage;

import SportsPackage.FavSports;

public class SportsDriver {
	
	public static void main(String[] args) {
		
		System.out.println("SPORTS! Yay");
		FavSports Soccer = new FavSports("Soccer", 9, true);
		FavSports football = new FavSports();
		football.setName("Football");
		football.setRank(10);
		football.isAwesome= (true);
		
		
		
		playsports(Soccer);
		playsports(football);
		
		
	}
		
		public static void playsports(FavSports favsports) {
			System.out.println(favsports +" because it's the best");
			
		
		}
	}

