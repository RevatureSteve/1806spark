package com.revature.pojo;

import java.io.Serializable;

/**
 *
 *FlashCard Class will be modified after a table in the database 
 *		each state will be a field in the database
 *		(each variable will have a column in the database)
 *	
 *This is call: "Object Relational Mapping"
 *
 *@author sidhu
 *
 */
public class FlashCard implements Serializable {
	
	//constructor
	public FlashCard(int fcid, String fcQuestion, String fcAnswer) {
		super();
		this.fcid = fcid;
		this.fcQuestion = fcQuestion;
		this.fcAnswer = fcAnswer;
	}

	//state
	private int fcid;
	private String fcQuestion;
	private String fcAnswer;
	
	//no args constructor
	public FlashCard() {}

	
	
	
	//getters and setters
	public int getFcid() {
		return fcid;
	}

	public void setFcid(int fcid) {
		this.fcid = fcid;
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

	//toString()
	@Override
	public String toString() {
		return "FlashCard [fcid=" + fcid + ", fcQuestion=" + fcQuestion + ", fcAnswer=" + fcAnswer + "]";
	}
	
	

}
