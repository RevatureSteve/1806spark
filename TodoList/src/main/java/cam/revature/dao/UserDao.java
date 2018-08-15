package cam.revature.dao;

import java.util.List;

import cam.revature.domain.Task;
import cam.revature.domain.User;

public interface UserDao {

	
	
	//create
	//read
	public User getUserrByUsername(String username);
	public List <Task> getAllTasks();
	public List<Task> getTasksByUserId(int id);
	//update
	//delete
}
