package com.kingsgame.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kingsgame.dao.Dao;


public class HelloWorldServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		Dao dao = new Dao();
		dao.createUser("joseph@me.com", "password", "fname", "lname", 1);
		System.out.println("User created.");
	}
}