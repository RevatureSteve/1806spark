package com.revature.pojos;

import java.io.Serializable;

public class FlashCard implements Serializable  {
private int fc_id;
private String fc_question;
private String fc_answer;

//No args constructor
public FlashCard() {
}



public FlashCard(int fc_id, String fc_question, String fc_answer) {
	super();
	this.fc_id = fc_id;
	this.fc_question = fc_question;
	this.fc_answer = fc_answer;
}



//getters and setters.

public int getFc_id() {
	return fc_id;
}

public void setFc_id(int fc_id) {
	this.fc_id = fc_id;
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

@Override
public String toString() {
	return "FlashCard [fc_id=" + fc_id + ", fc_question=" + fc_question + ", fc_answer=" + fc_answer + "]";
};





}
