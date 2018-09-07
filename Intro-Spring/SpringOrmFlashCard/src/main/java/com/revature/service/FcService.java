package com.revature.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.FlashCard;
import com.revature.repository.FcRepository;

@Service
@Transactional() //can be class or method level
public class FcService {

	@Autowired
	FcRepository fcRepo; //note this the interface
	
	public void createFlashCard(FlashCard fc){
		System.out.println("service -createFc");
		fcRepo.saveFc(fc);
		fcRepo.saveFc(new FlashCard(2,"What is C#", "lame"));
		fcRepo.saveFc(new FlashCard(3,"What is JavaScript", "not java"));
	}
	
	
	public List<FlashCard> getAllFlashCard(){
		System.out.println("service -getAll");
		return fcRepo.findAllFlashCards();
	}
}
