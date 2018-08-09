package com.revature.pojo;

import java.io.Serializable;

/**
 * Modelled after a table in the database, with the same states as the table's columns
 * 	Called: "Object Relational Mapping"
 * @author chin2
 *
 */
public class FlashCard implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// States
	private int id;
	private String fc_question;
	private String fc_answer;

	//Constructor(s)
	public FlashCard() {
	}

	public FlashCard(int id, String fc_question, String fc_answer) {
		super();
		this.id = id;
		this.fc_question = fc_question;
		this.fc_answer = fc_answer;
	}



	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFc_question() {
		return fc_question;
	}

	public void setFc_question(String fc_question) {
		this.fc_question = fc_question;
	}

	public String getFc_answer() {
		return fc_answer;
	}

	public void setFc_answer(String fc_answer) {
		this.fc_answer = fc_answer;
	}
	
	// toString
	@Override
	public String toString() {
		return "FlashCard [id=" + id + ", fc_question=" + fc_question + ", fc_answer=" + fc_answer + "]";
	}
	
	

}
