package com.revature.pojo;

import java.io.Serializable;

public class FlashCard implements Serializable{
	
	/**
	 * Flashcard class will be modeled after a table in the database 
	 * 	each state will be a field in the database 
	 * (each variable will have a column in the dataase)
	 * 
	 * 
	 * This is called: "Object Relational Mapping" ORM
	 */
	
	
	// state
	private int fcID;
	private String fcQuestion;
	private String fcAnswer;

	//no-args constructor
	public FlashCard() {}
	
	

	
	public FlashCard(int fcID, String fcQuestion, String fcAnswer) {
		super();
		this.fcID = fcID;
		this.fcQuestion = fcQuestion;
		this.fcAnswer = fcAnswer;
	}




	// getters and setters
	
	public int getFcID() {
		return fcID;
	}

	public void setFcID(int fcID) {
		this.fcID = fcID;
	}

	public String getFcQuestion() {
		return fcQuestion;
	}

	public void setFcQuestion(String fcQuestion) {
		this.fcQuestion = fcQuestion;
	}

	public String getFcAnswer() {
		return fcAnswer;
	}

	public void setFcAnswer(String fcAnswer) {
		this.fcAnswer = fcAnswer;
	}


	@Override
	public String toString() {
		return "FlashCard [fcID=" + fcID + ", fcQuestion=" + fcQuestion + ", fcAnswer=" + fcAnswer + "]";
	}
	
	
	
	
	
	
}
