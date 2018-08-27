package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.Service;

public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Service ss = new Service();
       
    public UpdatePasswordServlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uId = Integer.parseInt(request.getParameter("uId"));
		String password = request.getParameter("password");
		 int row = ss.updateUserPssword(uId, password);
		System.out.println(row);
		
	}

}
