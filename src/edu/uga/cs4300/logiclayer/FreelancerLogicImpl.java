package edu.uga.cs4300.logiclayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.uga.cs4300.objectlayer.Movie;
import edu.uga.cs4300.objectlayer.Review;
import edu.uga.cs4300.persistlayer.MoviePersistImpl;

public class FreelancerLogicImpl {


	
	/** 
	 * Returns all movies via a requested genre
	 */
	 public static ArrayList < Movie > returnMovieViaGenre(String genre) throws SQLException
	    {
	        
	        ArrayList < Movie > movies = new ArrayList < Movie > ();
	        ResultSet rs = MoviePersistImpl.returnMovieViaGenre(genre);

	        try
	        {
	            while (rs.next())
	            {
	                String name = rs.getString("name");
	                int year = rs.getInt("year");
	                double rank = rs.getDouble("rank");
	                int id = rs.getInt("id");
	                Movie movie = new Movie(id,name, year, rank);
	                movies.add(movie);
	            }
	        }
	        catch (SQLException e)
	        {
	            e.printStackTrace();
	        }
	        return movies;

	    }
	 
	 /** 
		 * Returns all reviews for a movie
		 */
	 public static ArrayList < Review > returnReviews(Movie movie) throws SQLException
	    {
	        
	        ArrayList < Review > reviews = new ArrayList < Review > ();
	        ResultSet rs = MoviePersistImpl.returnReviews(movie);

	        try
	        {
	            while (rs.next())
	            {

	                int id = rs.getInt("id");
	                int movie_id = rs.getInt("movie_id");
	                String blurb = rs.getString("review");
	            
	                Review review = new Review(id,movie_id, blurb);
	                reviews.add(review);
	            }
	        }
	        catch (SQLException e)
	        {
	            e.printStackTrace();
	        }
	        return reviews;

	    }
	 
	 /** 
		 * individually delete review
		 */
	 public static void deleteReview(int id) throws SQLException
	 {
		 MoviePersistImpl.deleteReviewByID(id);
	 }
	 
	 /** 
		 *add a new review
		 */
	 public static void addReview(int movie_id, String review) throws SQLException
	 {
		 MoviePersistImpl.addReview(movie_id, review);
	 }
	 /** 
		 * Create a new movie
		 */

	 public static void addMovie(String title, int year, double rank, ArrayList < String > genres)  throws SQLException
	 {
		 MoviePersistImpl.addMovie(title, year, rank);	 
		 Movie movie = returnMovieViaTitle(title);
		 
		 for (int i = 0; i < genres.size(); i++)
		 {
			 String genre = genres.get(i);
			 MoviePersistImpl.addGenreToMovie(movie.getId(), genre);
		 }
		 
		 
	 }
	 
	 /** 
		 * Update movie
		 */
	 public static void updateMovie(int id, String title, int year, double rank, ArrayList<String> genres)  throws SQLException
	 {
		 Movie movie = new Movie(id, title, year, rank);
		 
		 MoviePersistImpl.updateMovie(movie);
		 MoviePersistImpl.deleteMovieGenreLink(movie.getId());
		 for (int i = 0; i < genres.size(); i++)
		 {
			 String genre = genres.get(i);
			 MoviePersistImpl.addGenreToMovie(movie.getId(), genre);
		 }
		 
	 }
	 
	 /** 
		 * Delete movie via ID
		 */
	 
	 public static void deleteMovie(int movie_id)  throws SQLException
	 {

		 MoviePersistImpl.deleteReviewsByMovie(movie_id);
		 MoviePersistImpl.deleteMovie(movie_id);	
		 MoviePersistImpl.deleteMovieGenreLink(movie_id);
		
		
	 }
	 
	 /** 
		 * Return a movie via the title 
		 */
	 
	 public static  Movie returnMovieViaTitle(String title) throws SQLException
	    {
	       
	        ResultSet rs = MoviePersistImpl.returnMovieViaTitle(title);
	        Movie movie = new Movie();

	        try
	        {
	            while (rs.next())
	            {
	                String name = rs.getString("name");
	                int year = rs.getInt("year");
	                double rank = rs.getDouble("rank");
	                int id = rs.getInt("id");
	                
	                movie.setYear(year);
	                movie.setRank(rank);
	                movie.setId(id);
	                movie.setName(name);
	              
	            }
	        }
	        catch (SQLException e)
	        {
	            e.printStackTrace();
	        }
	        return movie;

	    }
	 
	 /** 
		 * Returns a movie using its id
		 */
	 
	 public static  Movie returnMovieViaID(int movie_id) throws SQLException
	    {
	       
	        ResultSet rs = MoviePersistImpl.returnMovieViaID(movie_id);
	        Movie movie = new Movie();

	        try
	        {
	            while (rs.next())
	            {
	                String name = rs.getString("name");
	                int year = rs.getInt("year");
	                double rank = rs.getDouble("rank");
	                int id = rs.getInt("id");
	                
	                movie.setYear(year);
	                movie.setRank(rank);
	                movie.setId(id);
	                movie.setName(name);
	              
	            }
	        }
	        catch (SQLException e)
	        {
	            e.printStackTrace();
	        }
	        return movie;

	    }
	
	 
	 /** 
		 * Returns all genres of a movie
		 */
	 public static ArrayList<String> getGenreOfMovie(Movie movie) throws SQLException
	 {
		 
		 ArrayList < String > genres = new ArrayList < String > ();
		  ResultSet rs = MoviePersistImpl.getGenreOfMovie(movie);

	        try
	        {
	            while (rs.next())
	            {
	                String genre = rs.getString("genre");

	                genres.add(genre);	              
	            }
	        }
	        catch (SQLException e)
	        {
	            e.printStackTrace();
	        }
		return genres;

	 }

	
}
