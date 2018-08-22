package com.revature.pojo;

import java.io.Serializable;

/**
 * 	FlashCard Class will be modeled after a table in the Database
 * 		each state will be a field in the database
 * 		(each variable will have a column in the database)
 * 
 * 	This is called: "Object Relational Mapping" ORM
<<<<<<< HEAD
 * @author Steve Work PC
 *
 */
public class FlashCard implements Serializable{

	// state
=======
 * @author Stephen Hong
 *
 */
public class FlashCard implements Serializable{
	
	//	state
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
	private int fcId;
	private String fcQuestion;
	private String fcAnswer;
	
<<<<<<< HEAD
	// no-args constructor
	public FlashCard() {}
	
=======
	//	no-args constructor
	public FlashCard() {}

>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
	public FlashCard(int fcId, String fcQuestion, String fcAnswer) {
		super();
		this.fcId = fcId;
		this.fcQuestion = fcQuestion;
		this.fcAnswer = fcAnswer;
	}

<<<<<<< HEAD


	// getters and setter
=======
	// getters and setters
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
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
	
<<<<<<< HEAD
=======
	
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
}
