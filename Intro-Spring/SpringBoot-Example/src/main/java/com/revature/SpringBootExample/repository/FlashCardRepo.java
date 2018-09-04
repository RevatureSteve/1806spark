package com.revature.SpringBootExample.repository;

import org.springframework.data.repository.CrudRepository;

import com.revature.SpringBootExample.beans.FlashCard;


public interface FlashCardRepo extends CrudRepository<FlashCard, Integer> {

	/*
	 * 		CrudRepository (Parent) - Basic Crud
	 * 		PagingAndSortingRepository
	 * 		JpaRepository
	 * 
	 */
	
	
}
