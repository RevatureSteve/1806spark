package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public class RequetHelper {
	public static String process(HttpServletRequest request) {
		System.out.println(request.getRequestURI());
		
		switch(request.getRequestURI()) {
		case "/HelloFrontController/login.do": 
			return LoginController.Login(request);
		case "/HelloFrontController/home.do": 
			return HomeController.home(request);
		default: 
			return "resources/html/unsuccessfulLogin.html";
		}
	}
}
