package com.revature.pojo;

import java.io.Serializable;

/**
 * FlashCard will be modeled after a table in the Database
 * each state will be a field in the database
 * (each variable will have a column in the database)
 * 
 * this is called "Object Relational Mapping:
 * @author becklarson-Work
 *
 */

public class BankUsers implements Serializable {
	
	//state
	
	private int fcId;
	private String fcQuestion;
	private String fcAnswer;
	
	public BankUsers() {}
	//no args constructor
	public int getFcId() {
		return fcId;
	}

	public BankUsers(int fcId, String fcQuestion, String fcAnswer) {
		super();
		this.fcId = fcId;
		this.fcQuestion = fcQuestion;
		this.fcAnswer = fcAnswer;
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
	};
	

	
	

}
