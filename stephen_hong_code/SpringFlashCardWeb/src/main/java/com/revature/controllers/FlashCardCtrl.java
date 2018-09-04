package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FlashCardCtrl {
	
	/*
	 * 	@RequestMapping handles all request types that are not already handled
	 */
	@RequestMapping("/home")
	public String home() {
		System.out.println("Welcome home spring");
		return "Hello Spring";
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String homeGET() {
		System.out.println("GET -Welcome home spring");
		return "GET Spring";
	}

}
