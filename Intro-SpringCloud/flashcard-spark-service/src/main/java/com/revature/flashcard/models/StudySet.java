package com.revature.flashcard.models;

import java.util.HashSet;
import java.util.Set;

public class StudySet {

	private int id;
	private Set<FlashCard> studySet = new HashSet<>();

	public StudySet() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<FlashCard> getStudySet() {
		return studySet;
	}

	public void setStudySet(Set<FlashCard> studySet) {
		this.studySet = studySet;
	}
	
	
	
}
