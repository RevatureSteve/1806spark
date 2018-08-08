package com.revature.pogo;

import java.io.Serializable;

/**
 * FlashCard Class will be modeled after a table in the Database each state will
 * be a field in the database (each variable will have a column in the database)
 * 
 * This is called: "Object Relational Mapping" ORM
 * 
 * @author Alex Moraga
 *
 */

public class FlashCard implements Serializable {

	// State
	private int fcId;
	private String fcQuestion;
	private String fcAnswer;

	// no-args constructor
	public FlashCard() {
		super();
	}

	public FlashCard(int fcId, String fcQuestion, String fcAnswer) {
		super();
		this.fcId = fcId;
		this.fcQuestion = fcQuestion;
		this.fcAnswer = fcAnswer;
	}
	// Setter and Getters
	public int getFcId() {
		return fcId;
	}

	public void setFcId(int fcId) {
		this.fcId = fcId;
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
		return "FlashCard [fcId=" + fcId + ", fcQuestion=" + fcQuestion + ", fcAnswer=" + fcAnswer + "]";
	}
	

}
