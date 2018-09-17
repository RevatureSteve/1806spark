package com.revature.flashcard.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.revature.flashcard.beans.FlashCard;
import com.revature.flashcard.beans.StudySet;

@Service
public class StudySetService {

	public Set<StudySet> getAllStudySet() {
		Set<StudySet> studySets = new HashSet<StudySet>();
		StudySet a = new StudySet();
		StudySet b = new StudySet();
		StudySet c = new StudySet();
		
		FlashCard f1 = new FlashCard(1, "1?", "1!");
		FlashCard f2 = new FlashCard(2, "2?", "2!");
		FlashCard f3 = new FlashCard(3, "3?", "3!");
		FlashCard f4 = new FlashCard(4, "4?", "4!");
		FlashCard f5 = new FlashCard(5, "5?", "5!");
		FlashCard f6 = new FlashCard(6, "6?", "6!");
		
		a.getStudySet().add(f1);
		a.getStudySet().add(f6);
		b.getStudySet().add(f2);
		b.getStudySet().add(f5);
		c.getStudySet().add(f3);
		
		studySets.add(a);
		studySets.add(b);
		studySets.add(c);
		
		return studySets;
	}
}
