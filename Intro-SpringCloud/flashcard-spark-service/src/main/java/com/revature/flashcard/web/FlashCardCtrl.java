package com.revature.flashcard.web;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.flashcard.models.FlashCard;
import com.revature.flashcard.models.StudySet;
import com.revature.flashcard.service.ApiService;
import com.revature.flashcard.service.FlashCardService;

import antlr.collections.List;

@RestController
@RequestMapping("api/v1")
public class FlashCardCtrl {
	
	@Autowired
	FlashCardService flashCardService;
	
	@Autowired
	ApiService apiService;
	
	@GetMapping("/")
	public String base() {
		return "base url";
	}

	@GetMapping("/flashcard/{id}/question/{question}")
	public ResponseEntity<FlashCard> fc(@PathVariable int id, @PathVariable String question) {
		Optional<FlashCard> fc = flashCardService.getFlashCardById(id);
		
		return new ResponseEntity<FlashCard>(fc.get(), HttpStatus.OK);
	}
	
	@PostMapping("/flashcard")
	public ResponseEntity<HttpStatus> createfc(@RequestBody FlashCard fc) {
		flashCardService.savefc(fc);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("flashcard/studyset")
	public Optional<FlashCard> retrieveAllFlashCardsAndStudySets() {
		Iterable<FlashCard> fcList = flashCardService.getAllFlashCards();
		StudySet[] studySetArr = apiService.setStudySetApi();
		List<FlashCard> fcList = new ArrayList<>();
		List<FlashCard> fcList = 
	}
	
	@GetMapping("/flashcard")
	public Iterable<FlashCard> allFlashCards() {
		Iterable<FlashCard> flashCardList = flashCardService.getAllFlashCards();
		return flashCardList;
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public HttpStatus err() {
		return HttpStatus.NOT_FOUND;
	}
}
