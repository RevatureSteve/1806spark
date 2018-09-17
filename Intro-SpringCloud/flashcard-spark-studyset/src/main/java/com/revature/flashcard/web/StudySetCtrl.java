package com.revature.flashcard.web;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.flashcard.beans.FlashCard;
import com.revature.flashcard.beans.StudySet;
import com.revature.flashcard.service.StudySetService;

@RestController
public class StudySetCtrl {

	@Autowired
	StudySetService studySetService;
	
	@GetMapping("/studyset")
	public Set<StudySet> allStudySets() {
		System.out.println("StudySet");
		Set<StudySet> studySet = studySetService.getAllStudySet();
		return studySet;
	}
	
}
