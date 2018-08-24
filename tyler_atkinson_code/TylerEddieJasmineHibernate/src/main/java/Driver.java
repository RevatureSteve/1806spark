import com.revature.dao.TodoDao;
import com.revature.dao.TodoDaoImpl;
import com.revature.pojo.taskPojo;

public class Driver {

	public static void main(String[] args) {
	
		TodoDao todoDao = new TodoDaoImpl();
//
//		taskPojo tp = todoDao.getTaskById(1);
//		
//		System.out.println(tp);
		
		
		taskPojo tp = new taskPojo(1,"coding with redbull", 3);
		
		todoDao.createTask(tp);
		
		System.out.println(tp);
		
	}

}
