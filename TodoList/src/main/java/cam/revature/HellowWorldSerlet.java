package cam.revature;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * How do I make a class follow is-a Serlet?
 *  - You specifically mean an HttpServlet?
 *  -extend HttpServlet
 * 
 * *note: HttpSerlvlet is a class found from the specific implementation
 * of Web Container software you chose like tomcat or weblogic
 */
public class HellowWorldSerlet extends HttpServlet {

	
	/* A serlet to handle requests and send back responses
	 * now i must decide what endpoint this serlet will handle
	 *  url - /hello
	 */
	 
	//handle a get request at the endpoint /hello
	// IQ: this signature is the same for ever do* method
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
	System.out.println("Hello World -GET");	
	}
	
	
}
