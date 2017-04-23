package edu.uga.cs4300.persistlayer;

import java.sql.ResultSet;
import java.sql.SQLException;

import edu.uga.cs4300.objectlayer.Task;
import edu.uga.cs4300.objectlayer.User;

public class FreelancerPersistImpl {
	
	// Tasks
	
	public static int addTask(Task task) throws SQLException
	{
		
		String query ="INSERT INTO tasks" +
					"(description, time, price, difficulty, user_id, location) VALUES" +
					"('"+ task.getDescription() + "','"+ task.getTime() + "'," + task.getPrice()
					+"," + task.getDifficulty() + "," + task.getUserID() + ",'"+ task.getLocation()
					+"');";
				
				
		return DbAccessInterface.create(query);	
	}
	
	
	public static int updateTask(Task task) throws SQLException
	{
		
		String query ="UPDATE tasks " +
					"SET description = '" +task.getDescription()  + 
					 "', time = '" + task.getTime() + 
					 "', price = '" + task.getPrice() +
					 "', difficulty = '" + task.getDifficulty() +
					 "', user_id = '" + task.getUserID() +
					 "', location = '" + task.getLocation() +
					" WHERE id = '"+ task.getId()+"';";
					
								
		return DbAccessInterface.create(query);
		
	}
	
	
	public static int updateTaskStatus(Task task, String status) throws SQLException
	{
		
		String query ="UPDATE taskStatus " +
					"SET status = '" +status  + 
					"' WHERE task_id = '"+ task.getId()+"';";
					
								
		return DbAccessInterface.create(query);
		
	}
	
	public static int createTaskStatusEntry(Task task) throws SQLException
	{
		
		String query ="INSERT INTO taskStatus" +
				"(task_id, status) VALUES" +
				"('"+ task.getId() + "','open');";
								
		return DbAccessInterface.create(query);
		
	}
	
	
	public static ResultSet returnTaskStatus(Task task) throws SQLException
	{
		
		String query = "SELECT * FROM taskStatus "+
						"WHERE task_id ='"+task.getId()+"';";
		System.out.println(query);
		ResultSet rs = DbAccessInterface.retrieve(query);
		
		return rs;
		
	}
	
	public static int deleteTask(Task task) throws SQLException
	{
		
		String query ="DELETE FROM tasks " +
					  "WHERE id = '"+ task.getId() +"';";
					
		
		return DbAccessInterface.delete(query);
	
	}
	
	

	public static ResultSet returnTaskByID(int task_id) throws SQLException
	{
		
		
		String query = "SELECT * FROM tasks "+
						"WHERE id ='"+ task_id +"';";
		
		ResultSet rs = DbAccessInterface.retrieve(query);
		
		return rs;
		
	}
	
	public static ResultSet returnAllTasks() throws SQLException
	{
		
		
		String query = "SELECT * FROM tasks"; 
		System.out.println(query);
		ResultSet rs = DbAccessInterface.retrieve(query);
		
		return rs;
		
	}

	public static ResultSet returnTaskByDescription(String description) throws SQLException
	{
		
		
		String query = "SELECT * FROM tasks "+
						"WHERE description = '"+ description +"';";
		
		ResultSet rs = DbAccessInterface.retrieve(query);
		
		return rs;
		
	}
	
	public static ResultSet returnAvailableTasks() throws SQLException
	{
		
		String query = "SELECT * FROM tasks, taskStatus "+
						"WHERE tasks.id = taskStatus.task_id and taskStatus.status = 'open';";
		
		ResultSet rs = DbAccessInterface.retrieve(query);
		
		return rs;
		
	}
	
	public static ResultSet returnPastTaskByUser(User user) throws SQLException
	{
		
		String query = "SELECT * FROM tasks, taskStatus "+
						"WHERE tasks.id = taskStatus.task_id and taskStatus.status = 'closed' and user_id ='"+user.getId()+"';";
		
		ResultSet rs = DbAccessInterface.retrieve(query);
		
		return rs;
		
	}
	
	public static ResultSet returnTaskTakenByUser(User user) throws SQLException
	{
		
		String query = "SELECT * FROM tasks, taskStatus "+
						"WHERE tasks.id = taskStatus.task_id and taskStatus.status = 'pending' and user_id ='"+user.getId()+"';";
		
		ResultSet rs = DbAccessInterface.retrieve(query);
		
		return rs;
		
	}
	
	public static ResultSet returnCurrentTasksGivenByUser(User user) throws SQLException
	{
		
		String query = "SELECT * FROM tasks, taskStatus "+
						" WHERE tasks.id = taskStatus.task_id and (taskStatus.status = 'pending' or taskStatus.status = 'open' or taskStatus.status = 'pending request' ) and user_id ='"+user.getId()+"';";
		
		ResultSet rs = DbAccessInterface.retrieve(query);
		
		return rs;
		
	}
	
	//// User 
	
	public static int addUser(User user) throws SQLException
	{
		
		String query ="INSERT INTO users" +
					"(firstName, lastName, email, password, isAdmin, rating) VALUES" +
					"('"+ user.getFirstName() + "','"+ user.getLastName() + "','" + user.getEmail()
					+"','" + user.getPassword() + "','" + user.isAdmin() + "','"+ user.getRating()
					+"');";
				
		System.out.println(query);
		return DbAccessInterface.create(query);	
	}
	

	public static int updateUser(User user) throws SQLException
	{
		
		String query ="UPDATE users " +
					"SET firstName = '" + user.getFirstName()  + 
					 "', lastName = '" + user.getLastName() + 
					 "', email = '" + user.getEmail() +
					 "', password = '" + user.getPassword() +
					 "', isAdmin = '" + user.isAdmin() +
					 "', rating = '" + user.getRating() +
					" WHERE id = '"+ user.getId()+"';";
					
								
		return DbAccessInterface.create(query);
		
	}
	
	
	public static int deleteUser(User user) throws SQLException
	{
		
		String query ="DELETE FROM users " +
					  "WHERE id = '"+ user.getId() +"';";
					
		
		return DbAccessInterface.delete(query);
	
	}
	
	public static ResultSet returnUserByID(int user_id) throws SQLException
	{
		
		
		String query = "SELECT * FROM users "+
						"WHERE id ='"+ user_id +"';";
		
		ResultSet rs = DbAccessInterface.retrieve(query);
		
		return rs;
		
	}
	public static ResultSet returnUserByEmail(String email) throws SQLException
	{
		
		
		String query = "SELECT * FROM users "+
						"WHERE email = '"+ email +"';";
		System.out.println(query);
		ResultSet rs = DbAccessInterface.retrieve(query);
		
		return rs;
		
	}
	
	public static ResultSet returnUser(User user) throws SQLException
	{
		
		
		String query = "SELECT * FROM users "+
						"WHERE id ='"+ user.getId() +"';";
		
		ResultSet rs = DbAccessInterface.retrieve(query);
		
		return rs;
		
	}
		
	
	public static ResultSet returnFreelancerIDByTask(Task task) throws SQLException
	{
		
		
		String query = "SELECT * FROM assignee "+
						"WHERE task_id = '"+ task.getId() +"';";
//		System.out.println(query);
		ResultSet rs = DbAccessInterface.retrieve(query);
		
		return rs;
		
	}
	

	/// Ratings
	
	
	public static int addRating(User user, double rating) throws SQLException
	{
		
		String query ="INSERT INTO userRatings" +
					"(user_id, rating) VALUES" +
					"('"+ user.getId() + "','"+ rating+"');";
				
				
		return DbAccessInterface.create(query);	
	}
	
	public static ResultSet returnAllRatings(User user) throws SQLException
	{
		
		
		String query = "SELECT * FROM userRatings "+
						"WHERE user_id ='"+ user.getId() +"';";
		
		ResultSet rs = DbAccessInterface.retrieve(query);
		
		return rs;
		
	}
	
	
	// Skills
	
	public static int addSkills(User user, String skill) throws SQLException
	{
		
		String query ="INSERT INTO userSkills" +
					"(user_id, skill) VALUES" +
					"('"+ user.getId() + "','"+ skill+"');";
				
				
		return DbAccessInterface.create(query);	
	}
	
	public static ResultSet returnAllSkills(User user) throws SQLException
	{
		
		
		String query = "SELECT * FROM userSkills "+
						"WHERE user_id ='"+ user.getId() +"';";
		
		ResultSet rs = DbAccessInterface.retrieve(query);
		
		return rs;
		
	}
	
	
	// Assign Task
	
	public int assignTask(User user, Task task) throws SQLException
	{
		
		String query ="INSERT INTO asignee " +
					"(task_id, performer_id) VALUES" +
					"('"+ task.getId() + "','"+ user.getId()+"');";
				
				
		return DbAccessInterface.create(query);	
	}
	
	public static ResultSet returnAllTasksViaUser(User user) throws SQLException
	{
		
		
		String query = "SELECT * FROM asignee "+
						"WHERE performer_id ='"+ user.getId() +"';";
		
		ResultSet rs = DbAccessInterface.retrieve(query);
		
		return rs;
		
	}
	public static ResultSet returnTaskPerformer(Task task) throws SQLException
	{
		
		
		String query = "SELECT * FROM asignee "+
						"WHERE task_id ='"+ task.getId() +"';";
		
		ResultSet rs = DbAccessInterface.retrieve(query);
		
		return rs;
		
	}
	
	
	// Complete Task
	
	public int completeTask(Task task) throws SQLException
	{
		
		String query ="INSERT INTO completedTasks " +
					"(task_id) VALUES" +
					"('"+ task.getId()+"');";
				
				
		return DbAccessInterface.create(query);	
	}
	
	//Transactions
	
	public static int addTransaction(User creator, User performer, Task task, double amount) throws SQLException
	{
		
		String query ="INSERT INTO transactions " +
					"(creator_id, performer_id ,task_id, amount) VALUES" +
					"('"+ creator.getId()+ "','"+ performer.getId()+"','"+ task.getId() + "','"+ amount +"');";
				
				
		return DbAccessInterface.create(query);	
	}
	
	
	public static int deleteTransaction(User creator, Task task, double amount) throws SQLException
	{
		
		String query ="DELETE FROM transactions" +
					" WHERE creator_id = '"+ creator.getId()+
					"' and task_id = '"+ task.getId() +
					 "' and amount = '"+ amount +"';";
				
				
		return DbAccessInterface.create(query);	
	}
	
	
	// Account Balance
	
	public static ResultSet returnAccountBalance(User user) throws SQLException
	{
		
		
		String query = "SELECT * FROM accountBalance "+
						"WHERE user_id ='"+ user.getId() +"';";
		
		ResultSet rs = DbAccessInterface.retrieve(query);
		
		return rs;
		
	}
	
	public static int updateAccountBalance(User user, double balance) throws SQLException
	{
		
		String query ="UPDATE accountBalance " +
					"SET balance = '" + balance +
					"' WHERE user_id = '"+ user.getId()+"';";
					
								
		return DbAccessInterface.create(query);
		
	}
	

}
