package edu.uga.cs4300.logiclayer;

import java.awt.List;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uga.cs4300.objectlayer.Task;
import edu.uga.cs4300.objectlayer.User;
import edu.uga.cs4300.persistlayer.DbAccessInterface;
import edu.uga.cs4300.persistlayer.FreelancerPersistImpl;
import freemarker.template.TemplateException;


public class FreelancerLogicImpl {

	public static int addTask(Task task) throws SQLException
	 {
		FreelancerPersistImpl.addTask(task);
		ResultSet rs = FreelancerPersistImpl.returnTaskByDescription(task.getDescription()); 
		int id = 0; 
		  try
	        {
	            while (rs.next())
	            {
	            	id = rs.getInt("id");
	              
	            }
	        }
		  finally{}
		  
		  Task newTask = returnTaskByID(id);
		  FreelancerPersistImpl.createTaskStatusEntry(newTask);
		return id; 
	 }
	 
	public static void updateTask(Task task)throws SQLException
	 {
		 FreelancerPersistImpl.updateTask(task);
	 }
	
	public static void deleteTask(Task task) throws SQLException
	 {
		 FreelancerPersistImpl.deleteTask(task);
	 }
	 
	public static void updateTaskStatus(Task task, String status) throws SQLException
	 {
		 FreelancerPersistImpl.updateTaskStatus(task, status);
	 }
	
	public static String returnTaskStatus(Task task) throws SQLException
	 {
		 String status= "";
		 
		 ResultSet rs = FreelancerPersistImpl.returnTaskStatus(task);
		 
		 try
	        {
	            while (rs.next())
	            {

	            	status = rs.getString("status");

	            }
	        }
	        catch (SQLException e)
	        {
	            e.printStackTrace();
	        }
		return status;
		 
	 }
	
	public static ArrayList<Task> returnAvailableTasks() throws SQLException {
			// TODO Auto-generated method stub
			ResultSet rs = FreelancerPersistImpl.returnAvailableTasks(); 
			ArrayList<Task> tasks = new ArrayList<Task>();
			 try
		        {
		            while (rs.next())
		            {
		            	Task task = new Task(); 
		            	int id = rs.getInt("id");
		                String description = rs.getString("description");
		                String time = rs.getString("time");
		                double price = rs.getDouble("price");
		                int difficulty = rs.getInt("difficulty");
		                int user_id = rs.getInt("user_id");
		                String location = rs.getString("location");
		                
		                
		                task.setId(id);
		                task.setDescription(description);
		                task.setTime(time);
		                task.setPrice(price);
		                task.setDifficulty(difficulty);
		                task.setUserID(user_id);
		                task.setLocation(location);
		                
		                tasks.add(task); 
		            }
		        }
		        catch (SQLException e)
		        {
		            e.printStackTrace();
		        }
			return tasks;
		}
	 
	

	
	
	public static ArrayList<Task> returnPastTaskByUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs = FreelancerPersistImpl.returnAvailableTasks(); 
		ArrayList<Task> tasks = new ArrayList<Task>();
		 try
	        {
	            while (rs.next())
	            {
	            	Task task = new Task(); 
	            	int id = rs.getInt("id");
	                String description = rs.getString("description");
	                String time = rs.getString("time");
	                double price = rs.getDouble("price");
	                int difficulty = rs.getInt("difficulty");
	                int user_id = rs.getInt("user_id");
	                String location = rs.getString("location");
	                
	                
	                task.setId(id);
	                task.setDescription(description);
	                task.setTime(time);
	                task.setPrice(price);
	                task.setDifficulty(difficulty);
	                task.setUserID(user_id);
	                task.setLocation(location);
	                
	                tasks.add(task); 
	            }
	        }
	        catch (SQLException e)
	        {
	            e.printStackTrace();
	        }
		return tasks;
	}
	
	public static  Task returnTaskByID(int task_id) throws SQLException
	    {
	       
	        ResultSet rs = FreelancerPersistImpl.returnTaskByID(task_id);
	        Task task = new Task();

	        try
	        {
	            while (rs.next())
	            {
	            	int id = rs.getInt("id");
	                String description = rs.getString("description");
	                String time = rs.getString("time");
	                double price = rs.getDouble("price");
	                int difficulty = rs.getInt("difficulty");
	                int user_id = rs.getInt("user_id");
	                String location = rs.getString("location");
	                
	                
	                task.setId(id);
	                task.setDescription(description);
	                task.setTime(time);
	                task.setPrice(price);
	                task.setDifficulty(difficulty);
	                task.setUserID(user_id);
	                task.setLocation(location);

	                
	              
	            }
	        }
	        catch (SQLException e)
	        {
	            e.printStackTrace();
	        }
	        return task;

	    }

	public int assignTask(User user, Task task) throws SQLException
		{
			FreelancerPersistImpl persist = new FreelancerPersistImpl();
			return persist.assignTask(user, task);
		}
		
	public static  ArrayList<Task> returnAllTasksViaUser(User user) throws SQLException
		{
			//needs to return task object, see above in returnAvailableTasks
			ResultSet rs = FreelancerPersistImpl.returnAllTasksViaUser(user);
			ArrayList<Task> tasks = new ArrayList<Task>(); 
		    Task task = new Task();

	        try
	        {
	            while (rs.next())
	            {
	            
	            	int id = rs.getInt("id");
	                String description = rs.getString("description");
	                String time = rs.getString("time");
	                double price = rs.getDouble("price");
	                int difficulty = rs.getInt("difficulty");
	                int user_id = rs.getInt("user_id");
	                String location = rs.getString("location");
	                
	                
	                task.setId(id);
	                task.setDescription(description);
	                task.setTime(time);
	                task.setPrice(price);
	                task.setDifficulty(difficulty);
	                task.setUserID(user_id);
	                task.setLocation(location);
	                tasks.add(task);
	                
	              
	            }
	        }
	        catch (SQLException e)
	        {
	            e.printStackTrace();
	        }
	        return tasks;
		}
		
	public int completeTask(Task task) throws SQLException
		{
			FreelancerPersistImpl persist = new FreelancerPersistImpl();
			return persist.completeTask(task);
		}

	//Users
	 
	 public static void addUser(User user) throws SQLException
	 {
		 FreelancerPersistImpl.addUser(user);
	 }
	 
	 public static void updateUser(User user)throws SQLException
	 {
		 FreelancerPersistImpl.updateUser(user);
	 }
	
	 public static void deleteUser(User user) throws SQLException
	 {
		 FreelancerPersistImpl.deleteUser(user);
	 }

	 public static User returnUserByEmail(String email1) throws SQLException
	 {
		 	ResultSet rs = FreelancerPersistImpl.returnUserByEmail(email1);
	        User user = new User();

	        try
	        {
	            while (rs.next())
	            {
	            	int id = rs.getInt("id");
	                String firstName = rs.getString("firstName");
	                String lastName = rs.getString("lastName");
	                String email = rs.getString("email");
	                String password = rs.getString("password");
	                int isAdmin = rs.getInt("isAdmin");
	                double rating = rs.getDouble("rating");

	                
	                
	                
	                user.setId(id);
	                user.setFirstName(firstName);
	                user.setLastName(lastName);
	                user.setEmail(email);
	                user.setPassword(password);
	                user.setAdmin(isAdmin);
	                user.setRating(rating);
	
	                
	              
	            }
	        }
	        catch (SQLException e)
	        {
	            e.printStackTrace();
	        }
	        return user;
	 }
	 
	 public static  User returnTaskPerformer(Task task) throws SQLException
		{
			ResultSet rs = FreelancerPersistImpl.returnTaskPerformer(task);
			if (!rs.next())
				return null;
			else
			{
				rs = FreelancerPersistImpl.returnUserByID(rs.getInt(3));
				if (!rs.next())
					return null;
				else
				{
					User user = new User();
					user.setId(rs.getInt(1));
					user.setFirstName(rs.getString(2));
					user.setLastName(rs.getString(3));
					user.setEmail(rs.getString(4));
					user.setPassword(rs.getString(5));
					user.setAdmin(rs.getInt(6));
					user.setRating(rs.getInt(7));
					return user;
				}
			}
		}
	
	 public static ArrayList<Task> getTasksGiven(User u) throws SQLException {
			ResultSet rs = FreelancerPersistImpl.returnAvailableTasks();
			ArrayList<Task> tasks = new ArrayList<Task>();
			while (rs.next())
			{
				if (rs.getInt(6) == u.getId())
				{
					Task task = new Task();
					task.setId(rs.getInt(1));
					task.setDescription(rs.getString(2));
					task.setTime(rs.getString(3));
					task.setPrice(rs.getDouble(4));
					task.setDifficulty(rs.getInt(5));
					task.setId(u.getId());
					task.setLocation(rs.getString(6));
					tasks.add(task);
				}
			}
			return tasks;
		}
	 
	 public static User returnUserByID(int user_id) throws SQLException
	    {
	       
	        ResultSet rs = FreelancerPersistImpl.returnUserByID(user_id);
	        User user = new User();

	        try
	        {
	            while (rs.next())
	            {
	            	int id = rs.getInt("id");
	                String firstName = rs.getString("firstName");
	                String lastName = rs.getString("lastName");
	                String email = rs.getString("email");
	                String password = rs.getString("password");
	                int isAdmin = rs.getInt("isAdmin");
	                double rating = rs.getDouble("rating");

	               
	                
	                
	                user.setId(id);
	                user.setFirstName(firstName);
	                user.setLastName(lastName);
	                user.setEmail(email);
	                user.setPassword(password);
	                user.setAdmin(isAdmin);
	                user.setRating(rating);
	
	                
	              
	            }
	        }
	        catch (SQLException e)
	        {
	            e.printStackTrace();
	        }
	        return user;

	    }
	
	 
	 // Ratings
	 
	 public static void addRating(User user, double rating)throws SQLException
	 {
		 FreelancerPersistImpl.addRating(user, rating);
	 }
	
	 public static ArrayList<Double> returnAllRatings(User user)throws SQLException
	 {
		 ArrayList <Double> ratings = new ArrayList <Double>();
		 
		
		 
		 ResultSet rs =  FreelancerPersistImpl.returnAllRatings(user);;
		 
		 	        try
		 	        {
		 	            while (rs.next())
		 	            {
		 	                double rating = rs.getDouble("rating");

		 	                ratings.add(rating);

		 	            }
		 	        }
		 	        catch (SQLException e)
		 	        {
		 	            e.printStackTrace();
		 	        }
		 	        return ratings;
		 
		 	    }
		 
	 public static double returnAverageRating(User user) throws SQLException
	 {
		double rating = 0;
		
		ArrayList <Double> ratings = returnAllRatings(user);
		
		for (int i = 0; i < ratings.size(); i++) {
			rating = rating + ratings.get(i);
		}
	
		//average them
		rating = (rating / ratings.size());
		
		return rating;
		
	 }
	
	//Skills
	 public static void addSkills(User user, String skill)throws SQLException
	 {
		 FreelancerPersistImpl.addSkills(user, skill);
	 }
	 
	 //IVANO ADDED THESE TO BE FILLED OUT <3
	 public static boolean verifyUser(String username, String password) throws SQLException{ 
		 
		 User user = returnUserByEmail(username);
		 System.out.println("verifying user:" + username+ " systempass: " + user.getPassword() + " entered pass: " + password + " ");
		 if(user.getPassword().equals(password)){
			 return true;
		 }
		 else{
		 return false;
		 }
	 }

	 public static ArrayList<Task> getTasksTaken(User u) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs = FreelancerPersistImpl.returnAllTasks(); 
		ArrayList<Task> tasks = new ArrayList<Task>();
		 try
	        {
	            while (rs.next())
	            {
	            	Task task = new Task(); 
	            	int id = rs.getInt("id");
	                String description = rs.getString("description");
	                String time = rs.getString("time");
	                double price = rs.getDouble("price");
	                int difficulty = rs.getInt("difficulty");
	                int user_id = rs.getInt("user_id");
	                String location = rs.getString("location");
	                
	                
	                task.setId(id);
	                task.setDescription(description);
	                task.setTime(time);
	                task.setPrice(price);
	                task.setDifficulty(difficulty);
	                task.setUserID(user_id);
	                task.setLocation(location);
	                
	                tasks.add(task); 
	            }
	        }
	        catch (SQLException e)
	        {
	            e.printStackTrace();
	        }
		return tasks;
	}

	 public static double returnAccountBalance(User user) throws SQLException
	{
		ResultSet rs = FreelancerPersistImpl.returnAccountBalance(user);
		
		
		double balance = 0.0;
		 try
	        {
	            while (rs.next())
	            {
	   
	            	balance = rs.getDouble("balance");
	            
	                
	  
	            }
	        }
	        catch (SQLException e)
	        {
	            e.printStackTrace();
	        }
		
		
		return balance;
		
		
	}
	
	 public static int updateAccountBalance(User user, double balance) throws SQLException 
	{
		return FreelancerPersistImpl.updateAccountBalance(user, balance);
	}
	
	 public static User returnUser(User user) throws SQLException
	{
		ResultSet rs = FreelancerPersistImpl.returnUserByID(user.getId());
		if (rs.next())
		{
			User returned = new User();
			user.setId(rs.getInt(1));
			user.setFirstName(rs.getString(2));
			user.setLastName(rs.getString(3));
			user.setEmail(rs.getString(4));
			user.setPassword(rs.getString(5));
			user.setRating(rs.getDouble(7));
			user.setAdmin(rs.getInt(6));
			return returned;
		}
		else return null;
	}
	 
	 
	 
	 public static User returnFreelancerByTask(Task task) throws SQLException
	 {
		 int id = 0;
		 
		 	ResultSet rs = FreelancerPersistImpl.returnFreelancerIDByTask(task);
	        

	        try
	        {
	            while (rs.next())
	            {
	            	 id = rs.getInt("performer_id");
	                
	              
	            }
	        }
	        catch (SQLException e)
	        {
	            e.printStackTrace();
	        }
	        
	        User user = returnUserByID(id);
	        return user;
	 }
	
	 public static ArrayList<String> returnAllSkills(User user) throws SQLException
	{
		ArrayList<String> returned = new ArrayList<String>();
		ResultSet skills = FreelancerPersistImpl.returnAllSkills(user);
		while (skills.next())
		{
			returned.add(skills.getString(1));
		}
		return returned;
	}
	
//	 public static void addTransaction(User creator, User performer, Task task, double amount) throws SQLException
//	{
//	
//		FreelancerPersistImpl.addTransaction(creator, performer, task, amount);
//	}
	
	 public static int addTransaction(User creator, User performer, Task task, double amount) throws SQLException
		{
		
			int success = FreelancerPersistImpl.addTransaction(creator, performer, task, amount);
			return success;
		}
	 
	 
	 public static void deleteTransaction(User creator, Task task, double amount) throws SQLException
	{
		
		 FreelancerPersistImpl.deleteTransaction(creator, task, amount);
	}
	
}
