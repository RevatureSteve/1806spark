package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleServlet extends HttpServlet{
 
	/** 
	 *	url /life
	 */
	private static final long serialVersionUID = 4645341915339561963L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		System.out.println("LifeCycleServlet - doGet");
		
		String name = getServletContext().getInitParameter("myName");
		System.err.println(name);
		
		String dog = getInitParameter("dog"); //1st way
		String abc = getServletConfig().getInitParameter("abc"); //2nd way
		System.out.println(getServletName()+" " + dog + " " + abc);
	}





	@Override
	public void init() throws ServletException {
		System.out.println("LifeCycleServlet - init");
		super.init();
	}
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("LifeCycleServlet - service");
		super.service(arg0, arg1);
	}
	
	@Override
	public void destroy() {
		System.out.println("LifeCycleServlet - destroy");
		super.destroy();
	}
	
}
