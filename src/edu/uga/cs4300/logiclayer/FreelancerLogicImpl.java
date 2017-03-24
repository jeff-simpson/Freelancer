package edu.uga.cs4300.logiclayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.uga.cs4300.objectlayer.Task;
import edu.uga.cs4300.objectlayer.User;
import edu.uga.cs4300.persistlayer.DbAccessInterface;
import edu.uga.cs4300.persistlayer.FreelancerPersistImpl;


public class FreelancerLogicImpl {

	
	 public static void addTask(Task task) throws SQLException
	 {
		 FreelancerPersistImpl.addTask(task);
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
	
	
	 
	 
	/** 
	 * Returns all movies via a requested genre
	 */
//	 public static ArrayList < Movie > returnMovieViaGenre(String genre) throws SQLException
//	    {
//	        
//	        ArrayList < Movie > movies = new ArrayList < Movie > ();
//	        ResultSet rs = MoviePersistImpl.returnMovieViaGenre(genre);
//
//	        try
//	        {
//	            while (rs.next())
//	            {
//	                String name = rs.getString("name");
//	                int year = rs.getInt("year");
//	                double rank = rs.getDouble("rank");
//	                int id = rs.getInt("id");
//	                Movie movie = new Movie(id,name, year, rank);
//	                movies.add(movie);
//	            }
//	        }
//	        catch (SQLException e)
//	        {
//	            e.printStackTrace();
//	        }
//	        return movies;
//
//	    }
	 


	
}
