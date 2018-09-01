package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.FlashCard;
import com.revature.service.AppService;
import com.revature.service.AppServiceImpl;

/*
 *  A Controller Class
 */
public class FlashCardCtrl {

	private static AppService appService = new AppServiceImpl();
	
	//HTTP - GET
	public static List<FlashCard> getAll(HttpServletRequest req, HttpServletResponse resp){
		System.out.println("All FCs Ctrl");
		List<FlashCard> fcList = appService.findAll();
		return fcList;
	}
	
	public static FlashCard getFc(HttpServletRequest req, HttpServletResponse resp){
		System.out.println("Get Fc");
		return null;
	}

}
