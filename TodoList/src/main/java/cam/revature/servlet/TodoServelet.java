package cam.revature.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import cam.revature.domain.Task;

public class TodoServelet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		
		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task (1,1, "go for run", 1, "Pending"));
		tasks.add(new Task (2,2, "go for walk", 2, "completed"));
		tasks.add(new Task (3,3, "go for sprint", 3, "cancelled"));
		
		ObjectMapper mapper = new ObjectMapper();
		resp.setContentType("application/json");
		String json = mapper.writeValueAsString(tasks);
		PrintWriter out = resp.getWriter();
		out.print(json);
	}
	
}
