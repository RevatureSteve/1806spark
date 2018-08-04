package com.revature.pojo;

/*
 * flashCard class will be modeled after a table in the database each state will be a field in the database
 * (each variable will have a column in the database
 * 
 * this is called: "object relational/table mapping"
 * @Author Steve Pc
 */

public class FlashCard {
	//stake/field/variable
	private int field;
	private String fcQuestion;
	private String fcAnswer;
	

	// no-args constructor 
	public FlashCard() {
		//no-args
	}
	
	public FlashCard(int field, String fcQuestion, String fcAnswer) {
		super();
		this.field = field;
		this.fcQuestion = fcQuestion;
		this.fcAnswer = fcAnswer;
	}


	public int getField() {
		return field;
	}


	public void setField(int field) {
		this.field = field;
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
		return "FlashCard [field=" + field + ", fcQuestion=" + fcQuestion + ", fcAnswer=" + fcAnswer + "]";
	}


	
	
	
	
}
