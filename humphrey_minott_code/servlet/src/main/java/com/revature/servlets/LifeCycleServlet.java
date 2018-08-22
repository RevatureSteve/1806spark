package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleServlet extends HttpServlet {
	
//	url- /life
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException{
	System.out.println("/life- GET");
}

@Override
	public void init() throws ServletException {
		System.out.println("LifeCyle- init() called");
		super.init();
	}

@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LifeCyle- service() called (Not business logic method)");
		/* What is the point of the service()?
		 *	Parses the request meta data for the method type
		 * 		based upon Request Method Types (GET,POST,PUT, etc.)
		 *		will call the corresponding do*...method
		 */
		super.service(req, resp);
	}


@Override
	public void destroy() {
		System.out.println("LifeCyle- destroy() called");
		super.destroy();
	}
	
	

}
