package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FlashCardCtrl {
	
	@RequestMapping("/home")
	public String home() {
		System.out.println("welcome home spring");
		return "Hello string";
	}
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String home1() {
		System.out.println("welcome home spring");
		return "Hello string";
	}

}
