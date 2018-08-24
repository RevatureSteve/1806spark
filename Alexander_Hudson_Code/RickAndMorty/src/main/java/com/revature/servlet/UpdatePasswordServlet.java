package com.revature.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Pojo.Users;
import com.revature.service.AppService;

public class UpdatePasswordServlet extends HttpServlet{
	
	AppService appService = new AppService();
	
	
	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		System.out.println("Password Update -POST");
		

			ObjectMapper mapper = new ObjectMapper();
			System.out.println("Mapping");

			BufferedReader bf = req.getReader();
			System.out.println("Buffer Reader");

			Users us = mapper.readValue(bf, Users.class);

			System.out.println(us);

			appService.updateUserPassWord(us.getPassWord());
		}
		
	}

