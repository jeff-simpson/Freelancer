package edu.uga.cs4300.boundary;

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uga.cs4300.logiclayer.MovieLogicImpl;
import edu.uga.cs4300.objectlayer.Movie;
import edu.uga.cs4300.objectlayer.Review;
import edu.uga.cs4300.persistlayer.DatabaseAccess;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.SimpleHash;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;


@WebServlet("/IMDBBoundary")
public class IMDBBoundary extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    Configuration cfg = null;
    static Connection con = DatabaseAccess.connect();

    private String templateDir = "/WEB-INF/templates";

    public IMDBBoundary()
    {
        super();
    }

    public void init()
    {
        cfg = new Configuration(Configuration.VERSION_2_3_25);
        cfg.setServletContextForTemplateLoading(getServletContext(), templateDir);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);

    }
       

    
    
    /** 
     * This method checks to see if a value was entered
     */
    public static boolean empty( final String s )
    {
    	  return s == null || s.trim().isEmpty();
    }
    

    /** 
     * Because of the checkbox implementation, this mehtod handles calling all of the requests from the checkboxes
     * returns an ArrayList of all the genres that were submitted
     */
    public static ArrayList<String> getSubmittedGenres(HttpServletRequest request)
    {
    	ArrayList < String > genresSort = new ArrayList < String > ();
    	ArrayList < String > genres = new ArrayList < String > ();
    	
    	String Action = request.getParameter("Action");
    	String Animation = request.getParameter("Animation");
    	String Comedy  = request.getParameter("Comedy");
    	String Crime = request.getParameter("Crime");
    	String Drama  = request.getParameter("Drama");
    	String Family  = request.getParameter("Family");
    	String Fantasy = request.getParameter("Fantasy");
    	String Horror  = request.getParameter("Horror");
    	String Music = request.getParameter("Music");
    	String Musical = request.getParameter("Musical");
    	String Romance = request.getParameter("Romance");
    	String SciFi  = request.getParameter("Sci-Fi");
    	String Thriller = request.getParameter("Thriller");
    	String War  = request.getParameter("War");
    	
    	genresSort.add(Action);
		genresSort.add(Animation);
		genresSort.add(Comedy);
		genresSort.add(Crime); 
		genresSort.add(Drama); 
		genresSort.add(Family); 
		genresSort.add(Fantasy); 
		genresSort.add(Horror); 
		genresSort.add(Music); 
		genresSort.add(Musical); 
		genresSort.add(Romance); 
		genresSort.add(SciFi); 
		genresSort.add(Thriller); 
		genresSort.add(War); 


		for (int i = 0; i < genresSort.size(); i++)
		{
			if(!empty(genresSort.get(i)))
			{
				genres.add(genresSort.get(i));
				System.out.println(genresSort.get(i));
			}
			
		}
		
		return genres;
    }
    /** 
     * A basic method that just stores all the available methods, used to clean up code
     */
    public static ArrayList<String> getAllGenres()
    {
    	
    	ArrayList < String > genres = new ArrayList < String > ();
    	
    	String Action ="Action";
    	String Animation ="Animation";
    	String Comedy  = "Comedy";
    	String Crime = "Crime";
    	String Drama  = "Drama";
    	String Family  = "Family";
    	String Fantasy = "Fantasy";
    	String Horror  = "Horror";
    	String Music ="Music";
    	String Musical = "Musical";
    	String Romance = "Romance";
    	String SciFi  ="Sci-Fi";
    	String Thriller = "Thriller";
    	String War  = "War";
    	
    	genres.add(Action);
    	genres.add(Animation);
    	genres.add(Comedy);
    	genres.add(Crime); 
    	genres.add(Drama); 
    	genres.add(Family); 
    	genres.add(Fantasy); 
    	genres.add(Horror); 
    	genres.add(Music); 
    	genres.add(Musical); 
    	genres.add(Romance); 
    	genres.add(SciFi); 
    	genres.add(Thriller); 
    	genres.add(War); 
    	
    	return genres;
    	
    }


    public void runTemplate(HttpServletRequest request, HttpServletResponse response) throws SQLException
    {
        // You can use this structure for all of your objects to be sent to browser
        Template template = null;
        DefaultObjectWrapperBuilder df = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
        SimpleHash root = new SimpleHash(df.build());
        String templateName = "";
        
        
        /** 
         * Is active when the user is searching for all movies containing a genre
         */
        
        if(request.getParameterMap().containsKey("movieGenre"))
        {
        	String genre = request.getParameter("movieGenre");
        	
        	ArrayList < Movie > movies = new ArrayList < Movie > ();
        	movies = MovieLogicImpl.returnMovieViaGenre(genre);
        	
        	root.put("movies", movies);
        	templateName = "genre.ftl";
        
        }
        
        /** 
         * Is active when a user searches for a movie by name
         */
        
        if(request.getParameterMap().containsKey("movieName"))
        {
        	String title = request.getParameter("movieName");
        	
        	ArrayList < Review > reviews = new ArrayList < Review > ();
        	Movie movie = MovieLogicImpl.returnMovieViaTitle(title);
        	
        	ArrayList < String> genres = MovieLogicImpl.getGenreOfMovie(movie);
        	
        	if(movie.getName() == null)
        	{
        		root.put("movieTitle", title);
        		templateName ="createMovie.ftl";
        		
        	}
        	else
        	{
        		reviews = MovieLogicImpl.returnReviews(movie);
            	
            	root.put("movie", movie);
            	root.put("genres", genres);
            	root.put("reviews", reviews);
            	templateName = "reviews.ftl";
        	}
        		
        
        }
        
        /** 
         * is active when user attempts to delete a review
         */
        
        if(request.getParameterMap().containsKey("deleteReview"))
        {
        	String reviewID = request.getParameter("reviewID");
        	String title = request.getParameter("movieName");
        	
        	int id = Integer.parseInt(reviewID);
        	MovieLogicImpl.deleteReview(id);
        	
        	ArrayList < Review > reviews = new ArrayList < Review > ();
        	Movie movie = MovieLogicImpl.returnMovieViaTitle(title);
        	reviews = MovieLogicImpl.returnReviews(movie);
        	
        	ArrayList < String> genres = MovieLogicImpl.getGenreOfMovie(movie);
        	
        	root.put("genres", genres);
        	root.put("movie", movie);
        	root.put("reviews", reviews);
        	templateName = "reviews.ftl";
        
        }
        
        
        /** 
         * is actiive when user wants to write a review
         */
        if(request.getParameterMap().containsKey("createReview"))
        {
        	String review = request.getParameter("review");
        	String movieID = request.getParameter("movieID");
        	
        	int id = Integer.parseInt(movieID);
        	MovieLogicImpl.addReview(id, review);
        	
        	ArrayList < Review > reviews = new ArrayList < Review > ();
        	Movie movie = MovieLogicImpl.returnMovieViaID(id);
        	reviews = MovieLogicImpl.returnReviews(movie);
        	
        	ArrayList < String> newGenres = MovieLogicImpl.getGenreOfMovie(movie);
        	
        	root.put("genres", newGenres);
        	root.put("movie", movie);
        	root.put("reviews", reviews);
        	templateName = "reviews.ftl";
        
        }
        
        /** 
         * is active when a user wants to create a movie
         */
        
        if(request.getParameterMap().containsKey("createMovie"))
        {
        	String title = request.getParameter("title");
        	String year = request.getParameter("year");
        	String rank = request.getParameter("rank");
       /// 	String genre = request.getParameter("movieGenre");
        	
        	// Get all genres

        	ArrayList < String > genres = getSubmittedGenres(request);

        	if( !empty(title) && !empty(year) && !empty(rank) && !genres.isEmpty())
        	{
        		int movie_year = Integer.parseInt(year);
            	double movie_rank = Double.parseDouble(rank);
            	
            	MovieLogicImpl.addMovie(title, movie_year, movie_rank, genres);
            	
            	ArrayList < Review > reviews = new ArrayList < Review > ();
            	Movie movie = MovieLogicImpl.returnMovieViaTitle(title);
            	reviews = MovieLogicImpl.returnReviews(movie);
            	
            	ArrayList < String> newGenres = MovieLogicImpl.getGenreOfMovie(movie);
            	
            	root.put("genres", newGenres);
            	root.put("movie", movie);
            	root.put("reviews", reviews);
            	templateName = "reviews.ftl";
        		
        	}
        	else
        	{
        		
        		String Error = "You must have fill out the correct fields";
        		templateName = "createMovie.ftl";
            	root.put("error", Error);
        	}
        	
        
        }
        
        /** 
         * Is active when a user wants to update a movie
         */
        if(request.getParameterMap().containsKey("manageMovie"))
        {
        	
        	String movieID = request.getParameter("movieID");
        	int id = Integer.parseInt(movieID);

        	Movie movie = MovieLogicImpl.returnMovieViaID(id);

        	ArrayList<String> allGenres = getAllGenres();
        	ArrayList<String> movieGenres = MovieLogicImpl.getGenreOfMovie(movie);
        	
        	root.put("allGenres", allGenres);
        	root.put("movieGenres", movieGenres);
        	root.put("movie", movie);
        	templateName = "manageMovie.ftl";
        
        }
        
        
        if(request.getParameterMap().containsKey("updateMovie"))
        {
        	String id = request.getParameter("movieID");
        	String title = request.getParameter("title");
        	String year = request.getParameter("year");
        	String rank = request.getParameter("rank");
        	//String genre = request.getParameter("movieGenre");
        	
        	int movie_id = Integer.parseInt(id);
        	
        	ArrayList < String > genres = getSubmittedGenres(request);
        	
        	if( !empty(title) && !empty(year) && !empty(rank) && !genres.isEmpty()) 		
        	{
        		
            	int movie_year = Integer.parseInt(year);
            	double movie_rank = Double.parseDouble(rank);
            	
            	MovieLogicImpl.updateMovie(movie_id, title, movie_year, movie_rank, genres);
            	
            	Movie newMovie = MovieLogicImpl.returnMovieViaID(movie_id);
            	ArrayList < Review > reviews = new ArrayList < Review > ();
            	reviews = MovieLogicImpl.returnReviews(newMovie);
            	
            	ArrayList < String> newGenres = MovieLogicImpl.getGenreOfMovie(newMovie);
            	
            	root.put("genres", newGenres);

            	root.put("movie", newMovie);
            	root.put("reviews", reviews);
            	templateName = "reviews.ftl";
        	}
        	
        	else
        	{
           	
        		Movie movie = MovieLogicImpl.returnMovieViaID(movie_id);
        		
            	String Error = "You must have fill out the correct fields";
            	
            	root.put("error", Error);
            	root.put("movie", movie);
            	templateName = "manageMovie.ftl";
        	}
 
        
        }
        
        /** 
         * is active when a user wants to delete a movie
         */
        
        if(request.getParameterMap().containsKey("deleteMovie"))
        {
        	String id = request.getParameter("movieID");
        	int movie_id = Integer.parseInt(id);
        	
        	MovieLogicImpl.deleteMovie(movie_id);
        	
        	templateName = "deleteSuccess.ftl";
        
        }
        

        try
        {
            
            template = cfg.getTemplate(templateName);
            response.setContentType("text/html");
            Writer out = response.getWriter();
            template.process(root, out);
          
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (TemplateException e)
        {
            e.printStackTrace();
        }
       // DatabaseAccess.closeConnection(con);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            runTemplate(request, response);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

}