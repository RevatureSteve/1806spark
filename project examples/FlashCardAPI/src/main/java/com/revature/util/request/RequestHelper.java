package com.revature.util.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controllers.FlashCardCtrl;

 
public class RequestHelper
{
	
	public String process(HttpServletRequest request, HttpServletResponse response)	{
		
		System.out.println("Request Helper process was called: "+request.getRequestURI());
		
		switch(request.getRequestURI())
		{
		case "/FlashCardAPI/api/v1/flashcard/get":
			System.out.println("RH -Get called but no path for support");
			return "404";
		case "/FlashCardAPI/api/v1/flashcard/all":
			return jacksonApiConverter(FlashCardCtrl.getAll(request, response));
		case "/FlashCardAPI/login":
//			return LoginCtrl.login(request);
		default:
			return "404";
		}
	}
	
	private static String jacksonApiConverter(Object obj){
		ObjectMapper jackson = new ObjectMapper();
		try {
			return jackson.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "500";
		}
	}
}
