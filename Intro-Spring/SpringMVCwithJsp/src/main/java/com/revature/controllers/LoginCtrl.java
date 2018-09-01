package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.models.User;
import com.revature.service.AuthService;

@Controller
//@RequestMapping(value="/employee/")
public class LoginCtrl {

	@Autowired
	private AuthService authService;
	
	
	@RequestMapping(value="/login")
	public String loginGET(ModelMap modelMap){
		System.out.println("loginGET method");
		
		User user = new User();
		modelMap.addAttribute("user",user);
		
		return "Login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPost(HttpServletRequest req, User user, ModelMap modelMap){
		System.out.println("loginPost method");
		System.out.println(req.getParameter("username"));
		System.out.println(user.getUsername() + " : from object");
		
		User authUser = authService.auth(user);
		
		if(authUser != null){
			HttpSession session = req.getSession();
			
			modelMap.addAttribute("user", authUser);
			return "redirect:Home";
//			return "Home";
		}else{
			modelMap.addAttribute("errorMessage","Username/Password incorrect");
			return "Login";
		}
		
	}
}
