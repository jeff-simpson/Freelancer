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

	                boolean admin = false;
	                if(isAdmin == 1)
	                {
	                	admin = true;
	                }
	                
	                
	                user.setId(id);
	                user.setFirstName(firstName);
	                user.setLastName(lastName);
	                user.setEmail(email);
	                user.setPassword(password);
	                user.setAdmin(admin);
	                user.setRating(rating);
	
	                
	              
	            }
	        }
	        catch (SQLException e)
	        {
	            e.printStackTrace();
	        }
	        return user;
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

	                boolean admin = false;
	                if(isAdmin == 1)
	                {
	                	admin = true;
	                }
	                
	                
	                user.setId(id);
	                user.setFirstName(firstName);
	                user.setLastName(lastName);
	                user.setEmail(email);
	                user.setPassword(password);
	                user.setAdmin(admin);
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
	 public static boolean verifyUser(String username, String password){ 
		 //check if the password is good or not
		 return true;
	 }

	public static ArrayList getTasksTaken(User u) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs = FreelancerPersistImpl.returnAllTasks(); 
		ArrayList tasks = new ArrayList();
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

	public static ArrayList getTasksAvailable(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	public static ArrayList getTasksGiven(User u) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static ResultSet returnAccountBalance(User user) throws SQLException
	{
		return FreelancerPersistImpl.returnAccountBalance(user);
	}
	
	
	public static int updateAccountBalance(User user, double balance) throws SQLException 
	{
		return FreelancerPersistImpl.updateAccountBalance(user, balance);
	}
	
	public static ResultSet returnUser(User user) throws SQLException
	{
		return FreelancerPersistImpl.returnUserByID(user.getId());
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
	
	public int assignTask(User user, Task task) throws SQLException
	{
		FreelancerPersistImpl persist = new FreelancerPersistImpl();
		return persist.assignTask(user, task);
	}
	
	public static ResultSet returnAllTasksViaUser(User user) throws SQLException
	{
		return FreelancerPersistImpl.returnAllTasksViaUser(user);
	}
	public static ResultSet returnTaskPerformer(Task task) throws SQLException
	{
		return FreelancerPersistImpl.returnTaskPerformer(task);
	}
	
	public int addTransaction(User creator, User performer, Task task, double amount) throws SQLException
	{
		FreelancerPersistImpl persist = new FreelancerPersistImpl();
		return persist.addTransaction(creator, performer, task, amount);
	}
	public int deleteTransaction(User creator, Task task, double amount) throws SQLException
	{
		FreelancerPersistImpl persist = new FreelancerPersistImpl();
		return persist.deleteTransaction(creator, task, amount);
	}
	
}
