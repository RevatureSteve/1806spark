package com.revature.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
 *  @ this class using JPA: Java Persistence API
 *  	@Entity
 *  	@Table
 *  	@Id
 *  	@Column
 *  JPA used to map a Java Class to a DB Table for Hibernate
 *  
 */
@Entity
@Table(name="FLASH_CARDS")
public class FlashCard {

	@Id // primary key @, required!
	@Column(name="FC_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="fc_seq")
	@SequenceGenerator(name="fc_seq", sequenceName="fc_seq")
	private int id;
	
	@Column(name="FC_QUESTION", unique=true)
	private String question;
	
	@Column(name="FC_ANSWER")
	private String answer;
	
	
	public FlashCard() {	}


	public FlashCard(String question, String answer) {
		super();
		this.question = question;
		this.answer = answer;
	}



	public FlashCard(int id, String question, String answer) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	@Override
	public String toString() {
		return "FlashCard [id=" + id + ", question=" + question + ", answer=" + answer + "]";
	}
	
	
}
