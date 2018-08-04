package com.revature.dao;

import java.util.List;

import com.revature.pojo.FlashCard;

public class FLashCardDaoImple implements FlashCardDao {
	
	private final static  String USERRNAME = "flashcard_db";
	private final static String PASSWORD = "p4ssw0rd";
	// nospace in url
	private final static String URL = "jdbc:oracle:thin:@octocat.czuadbiw1r4y.us-east-2.rds.amazonaws.com:1521:ORCL";

	

	@Override
	public List<FlashCard> getAllFlashCards() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FlashCard getFlashCardById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
