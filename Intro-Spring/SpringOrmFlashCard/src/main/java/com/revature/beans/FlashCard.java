package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FLASH_CARD")
public class FlashCard {

	@Id
	@Column(name="FC_ID")
	private int fcId;
	
	private String question;
	
	private String answer;
	
	public FlashCard() {}
	
	public FlashCard(int fcId, String question, String answer) {
		super();
		this.fcId = fcId;
		this.question = question;
		this.answer = answer;
	}



	public int getFcId() {
		return fcId;
	}

	public void setFcId(int fcId) {
		this.fcId = fcId;
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
		return "FlashCard [fcId=" + fcId + ", question=" + question + ", answer=" + answer + "]";
	}
	
}
