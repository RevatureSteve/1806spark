package com.revature.SpringBootExample.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.SpringBootExample.beans.FlashCard;
import com.revature.SpringBootExample.service.FlashCardService;

@RestController
public class FlashCardCtrl {

	@Autowired
	FlashCardService fcService;
	
	
	/*
	 *	header: 
	 *		content-type = application/json
	 *			use @RequestBody
	 *	
	 *		When using form data (form tag/element)
	 *		context-type =[{"key":"Content-Type","value":"application/x-www-form-urlencoded","description":""}]
	 * 
	 */
//	@RequestMapping(value="/flashcard/{id}", method=RequestMethod.GET)
	@GetMapping("/flashcard/{id}")
	public FlashCard getFc(@PathVariable int id){
		System.out.println("FlashCardCtrl -get");
		return fcService.getFc(id);
	}
	
	@GetMapping("/flashcard")
	public List<FlashCard> getAllFc(){
		System.out.println("FlashCardCtrl -get");
		return fcService.retrieveAllFcs();
	}
	
	// 201 -CREATED
	@PostMapping("/flashcard")
	public ResponseEntity<FlashCard> createFc(@RequestBody FlashCard fc){
		System.out.println("FlashCardCtrl -createFc");
		fc = fcService.createFlashCard(fc);
		return new ResponseEntity<FlashCard>(fc, HttpStatus.CREATED);
	}
}
