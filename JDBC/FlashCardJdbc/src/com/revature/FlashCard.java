package com.revature;

import java.io.Serializable;

/**
 * FlashCard Class will be modeled after a table in the Database
 * 		each state will be a field in the database
 * 		(each variable will have a column in the database)
 * 
 * This is called: "Object Relational Mapping" ORM -- mapping an object to a table
 * @author christopherholmes
 *
 */


public class FlashCard implements Serializable{
	//state
	private int fcID;
	private String fcQuestion;
	private String fcAnswer;
	public FlashCard() {}
	
	
	// Generate getters and setter
	
	public FlashCard(int fcID, String fcQuestion, String fcAnswer) {
		super();
		this.fcID = fcID;
		this.fcQuestion = fcQuestion;
		this.fcAnswer = fcAnswer;
	}


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
	
	
	
	
	
}

