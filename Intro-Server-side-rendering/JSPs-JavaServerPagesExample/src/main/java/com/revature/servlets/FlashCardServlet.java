package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.FlashCard;
import com.revature.service.FlashCardService;

@WebServlet("/flashcard")
public class FlashCardServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(getServletName() + " doGet");
		
		FlashCard fc = new FlashCardService().getFc(new FlashCard(5, null, null));
		
		//Save FC to the User's Session
		HttpSession session = req.getSession();
		session.setAttribute("fc", fc);
		
		//Send User to the new View
		req.getRequestDispatcher("flashcard.jsp").forward(req, resp);
		
		
	}
	
}
