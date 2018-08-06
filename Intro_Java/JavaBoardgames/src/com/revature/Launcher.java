package com.revature;

public class Launcher {

	public static void main(String[] args) {

		Boardgame b1 = new Boardgame();

		try {
			b1.setName("Catan");
		} catch (NoBlanks e) {
			e.printStackTrace();
		}

		b1.setNumOfPlayers(4);
		b1.playTime = 1;

		Boardgame b2 = new Boardgame("Monopoly", 6, 3);

		getGame(b1);
		getGame(b2);

		b1.pickGame();

	}

	public static void getGame(Boardgame boardgame) {
		System.out.println(boardgame);
	}

}
