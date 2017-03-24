package edu.uga.cs4300.persistlayer;

import java.sql.ResultSet;
import java.sql.SQLException;

import edu.uga.cs4300.objectlayer.Task;
import edu.uga.cs4300.objectlayer.User;

public class FreelancerPersistImpl {
	
	// Tasks
	
	public int addTask(Task task) throws SQLException
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
					 "', time = " + task.getTime() + 
					 ", price = " + task.getPrice() +
					 ", difficulty = " + task.getDifficulty() +
					 ", user_id = " + task.getUserID() +
					 ", location = " + task.getLocation() +
					" WHERE id = "+ task.getId()+";";
					
								
		return DbAccessInterface.create(query);
		
	}
	
	
	public static int deleteTask(Task task) throws SQLException
	{
		
		String query ="DELETE FROM tasks " +
					  "WHERE id = "+ task.getId() +";";
					
		
		return DbAccessInterface.delete(query);
	
	}
	
	//// User 
	
	public int addUser(User user) throws SQLException
	{
		
		String query ="INSERT INTO users" +
					"(firstName, lastName, email, password, isAdmin, rating) VALUES" +
					"('"+ user.getFirstName() + "','"+ user.getLastName() + "','" + user.getEmail()
					+"','" + user.getPassword() + "'," + user.isAdmin() + ",'"+ user.getRating()
					+"');";
				
				
		return DbAccessInterface.create(query);	
	}
	

	public static int updateUser(User user) throws SQLException
	{
		
		String query ="UPDATE users " +
					"SET firstName = '" + user.getFirstName()  + 
					 "', lastName = " + user.getLastName() + 
					 ", email = " + user.getEmail() +
					 ", password = " + user.getPassword() +
					 ", isAdmin = " + user.isAdmin() +
					 ", rating = " + user.getRating() +
					" WHERE id = "+ user.getId()+";";
					
								
		return DbAccessInterface.create(query);
		
	}
	
	
	public static int deleteUser(User user) throws SQLException
	{
		
		String query ="DELETE FROM users " +
					  "WHERE id = "+ user.getId() +";";
					
		
		return DbAccessInterface.delete(query);
	
	}
	
	
	
	
	
	/// Ratings
	
	
	public int addRating(User user, double rating) throws SQLException
	{
		
		String query ="INSERT INTO userRatings" +
					"(user_id, rating) VALUES" +
					"("+ user.getId() + ","+ rating+");";
				
				
		return DbAccessInterface.create(query);	
	}
	
	// Skills
	
	public int addSkills(User user, String skill) throws SQLException
	{
		
		String query ="INSERT INTO userSkills" +
					"(user_id, skill) VALUES" +
					"("+ user.getId() + ",'"+ skill+"');";
				
				
		return DbAccessInterface.create(query);	
	}
	
	
	// Assign Task
	
	public int assignTask(User user, Task task) throws SQLException
	{
		
		String query ="INSERT INTO asignee " +
					"(task_id, performer_id) VALUES" +
					"("+ task.getId() + ","+ user.getId()+");";
				
				
		return DbAccessInterface.create(query);	
	}
	
	
	// Complete Task
	
	public int completeTask(Task task) throws SQLException
	{
		
		String query ="INSERT INTO completedTasks " +
					"(task_id) VALUES" +
					"("+ task.getId()+");";
				
				
		return DbAccessInterface.create(query);	
	}
	
	//Transactions
	
	public int addTransaction(User creator, User performer, Task task, double amount) throws SQLException
	{
		
		String query ="INSERT INTO transactions " +
					"(creator_id, performer_id ,task_id, amount) VALUES" +
					"("+ creator.getId()+ ","+ performer.getId()+ task.getId() + ","+ amount +");";
				
				
		return DbAccessInterface.create(query);	
	}
	
	
	public int deleteTransaction(User creator, Task task, double amount) throws SQLException
	{
		
		String query ="DELETE FROM transactions" +
					" WHERE creator_id = "+ creator.getId()+
					" and task_id = "+ task.getId() +
					 " and amount = "+ amount +";";
				
				
		return DbAccessInterface.create(query);	
	}
	
	
	// Account Balance
	
	public static ResultSet returnAccountBalance(User user) throws SQLException
	{
		
		
		String query = "SELECT * FROM accountBalance "+
						"WHERE user_id ="+ user.getId() +";";
		
		ResultSet rs = DbAccessInterface.retrieve(query);
		
		return rs;
		
	}
	
	public static int updateAccountBalance(User user, double balance) throws SQLException
	{
		
		String query ="UPDATE accountBalance " +
					"SET balance = " + balance +
					" WHERE user_id = "+ user.getId()+";";
					
								
		return DbAccessInterface.create(query);
		
	}
	


}
