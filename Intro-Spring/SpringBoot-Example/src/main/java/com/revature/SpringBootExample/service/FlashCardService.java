package com.revature.SpringBootExample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.SpringBootExample.beans.FlashCard;
import com.revature.SpringBootExample.repository.FlashCardRepo;

@Service
public class FlashCardService {

	@Autowired
	FlashCardRepo fcRepo;
	
	public FlashCard getFc(int fcId){
		System.out.println("service -getFc");
		return fcRepo.findOne(fcId);
	}
	
	
	public List<FlashCard> retrieveAllFcs(){
		System.out.println("service - retrieve all");
		return (List<FlashCard>) fcRepo.findAll();
	}
	
	public FlashCard createFlashCard(FlashCard fc){
		System.out.println("service -createFc");
		fcRepo.save(fc);
		return fc;
	}
}
