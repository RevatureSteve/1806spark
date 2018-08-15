package cam.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import cam.revature.domain.Task;
import cam.revature.service.AppService;

/**
 * Servlet implementation class TodoIdServlet
 */
public class TodoIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private AppService appService = new AppService();
	
    public TodoIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TodoIdServlet -GET");
		int id = Integer.parseInt(request.getParameter("userId"));
		System.out.println("The id of the User is: " +request.getParameter("userId"));
		
		List<Task> userTasks = appService.getTasksByUserId(id);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(userTasks);
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
