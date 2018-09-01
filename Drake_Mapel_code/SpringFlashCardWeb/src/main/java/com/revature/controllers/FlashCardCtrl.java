package com.revature.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
public class FlashCardCtrl {
	
	@RequestMapping("/home")
	public String home() {
		System.out.println("welcome home spring");
		return "Hello Spring";
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String homeGET() {
		System.out.println("GET -welcome home spring");
		return "GET spring";
	}

}
