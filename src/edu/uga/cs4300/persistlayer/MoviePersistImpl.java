package edu.uga.cs4300.persistlayer;

import java.sql.ResultSet;
import java.sql.SQLException;

import edu.uga.cs4300.objectlayer.Movie;
import edu.uga.cs4300.objectlayer.Review;

public class MoviePersistImpl {
	
	public int addMovie(Movie movie) throws SQLException
	{
		
		String query ="INSERT INTO movies" +
					"(name, year, rank) VALUES" +
					"("+ movie.getName() + ","+ movie.getYear() + "," + movie.getRank() +");";
				
				
		return DbAccessInterface.create(query);
		
	}
	

	public static int updateMovie(Movie movie) throws SQLException
	{
		
		String query ="UPDATE movies " +
					"SET name = '" + movie.getName()  + "', rank = " + movie.getRank() + ", year = " + movie.getYear() +
					" WHERE id = "+ movie.getId()+";";
					
								
		return DbAccessInterface.create(query);
		
	}
	
	
	public static int updateGenre(Movie movie, String genre) throws SQLException
	{
		
		String query ="UPDATE movies_genres " +
					"SET genre = '" + genre +
					"' WHERE movie_id = "+ movie.getId()+";";
					
								
		return DbAccessInterface.create(query);
		
	}
	
	public static int deleteMovie(int movie_id) throws SQLException
	{
		
		String query ="DELETE FROM movies " +
					  "WHERE id = "+ movie_id +";";
					
		
		return DbAccessInterface.delete(query);
		
		
	}
	
	public static int deleteMovieGenreLink(int movie_id) throws SQLException
	{
		
		String query ="DELETE FROM movies_genres " +
					  "WHERE movie_id = "+ movie_id +";";
					
		
		return DbAccessInterface.delete(query);
		
		
	}
	
	public static int addReview(int movie_id, String review) throws SQLException
	{
		
		String query ="INSERT INTO reviews " +
					"(movie_id, review) VALUES " +
					"("+ movie_id + ", '" + review +"' );";
		return DbAccessInterface.create(query);
		
	}
	
	
	
	public static int addMovie(String title, int year, double rank) throws SQLException
	{
		
		String query ="INSERT INTO movies " +
					"(name, year, rank) VALUES " +
					"('"+ title + "', " + year +", "+ rank+ ");";
		return DbAccessInterface.create(query);
		
	}
	
	public static int addGenreToMovie(int movie_id, String genre) throws SQLException
	{
		
		String query ="INSERT INTO movies_genres " +
					"(movie_id, genre) VALUES " +
					"("+ movie_id + ", '" + genre +"');";
		return DbAccessInterface.create(query);
		
	}
	

	public int updateReview(Review review, Movie movie) throws SQLException
	{
		
		String query ="UPDATE reviews" +
					" SET movie_id = '" + review.getMovie_id()  + "', review = '" +review.getReview()+
					"'WHERE id = '"+ review.getId()+"';";
					
				
		return DbAccessInterface.create(query);
		
	}
	
	public int deleteReview(Review review) throws SQLException
	{
		
		String query ="DELETE FROM reviews " +
					"WHERE id = "+ review.getId() +";";
					
		return DbAccessInterface.delete(query);
		
	}
	public static int deleteReviewsByMovie(int movie_id) throws SQLException
	{
		
		String query ="DELETE FROM reviews " +
					"WHERE movie_id = "+movie_id +";";
					
		return DbAccessInterface.delete(query);
		
	}
	
	public static ResultSet returnMovieViaGenre(String genre) throws SQLException
	{
		
		
		String query = "SELECT movies.id, movies.name, movies.year, movies.rank from movies, movies_genres "+
						"WHERE movies_genres.movie_id = movies.id "+
						"and movies_genres.genre ='"+ genre +"';";
		
		ResultSet rs = DbAccessInterface.retrieve(query);
		
		return rs;
		
	}
	

	public static ResultSet returnMovieViaTitle(String title) throws SQLException
	{
		
		
		String query = "SELECT movies.id, movies.name, movies.year, movies.rank "+
						"from movies "+
						"WHERE movies.name  ='"+ title +"' limit 1;";
		
		ResultSet rs = DbAccessInterface.retrieve(query);
		
		return rs;
		
	}
	
	public static ResultSet returnMovieViaID(int movie_id) throws SQLException
	{
		
		
		String query = "SELECT movies.id, movies.name, movies.year, movies.rank "+
						"from movies "+
						"WHERE movies.id  ='"+ movie_id +"';";
		
		ResultSet rs = DbAccessInterface.retrieve(query);
		
		return rs;
		
	}
	
	
	public static ResultSet getGenreOfMovie(Movie movie) throws SQLException
	{
		
		
		String query = "SELECT genre "+
						"from movies_genres "+
						"WHERE movie_id ="+ movie.getId() +" ORDER BY genre;";
		
		ResultSet rs = DbAccessInterface.retrieve(query);
		
		return rs;
		
	}
	
	public static ResultSet returnReviews(Movie movie) throws SQLException
	{
		
		
		String query = "select * from reviews where movie_id = "+ movie.getId() +";";
		
		ResultSet rs = DbAccessInterface.retrieve(query);
		
		return rs;
		
	}
	
	
	
	
	public static void deleteReviewByID(int id) throws SQLException
	{
		String query = "Delete from reviews where id = "+ id +";";
		
		DbAccessInterface.delete(query);
		
	}
	

	
	

}
