package edu.uga.cs4300.boundary;


import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.mysql.jdbc.Connection;

import edu.uga.cs.servlet.Actor;
import edu.uga.cs4300.logiclayer.FreelancerLogicImpl;
import edu.uga.cs4300.objectlayer.Task;
import edu.uga.cs4300.objectlayer.User;
import edu.uga.cs4300.persistlayer.DatabaseAccess;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.SimpleHash;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;


@WebServlet("/FreelancerBoundary")
public class AjaxBoundary extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    Configuration cfg = null;
    static Connection con = (Connection) DatabaseAccess.connect();

    private String templateDir = "/WEB-INF/templates";
    DefaultObjectWrapperBuilder df = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
    SimpleHash root = new SimpleHash(df.build());
    
    public AjaxBoundary()
    {
        super();
    }

    public void init()
    {
        cfg = new Configuration(Configuration.VERSION_2_3_25);
        cfg.setServletContextForTemplateLoading(getServletContext(), templateDir);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
        FreelancerLogicImpl logic = new FreelancerLogicImpl(); 
        
    }

    public void runTemplate(HttpServletRequest request, HttpServletResponse response, String name) throws SQLException
    {
        // You can use this structure for all of your objects to be sent to browser
        Template template = null;
       
        String templateName = name + ".ftl";
        
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
    		 
    		 int creatorID = Integer.parseInt(request.getParameter("creatorID"));
    		 int freelancerID = Integer.parseInt(request.getParameter("freeLancerID"));
    		
    		 int taskID = Integer.parseInt(request.getParameter("taskID"));
    		 double amount = Integer.parseInt(request.getParameter("payAmount"));
    		 double rating = Integer.parseInt(request.getParameter("rating"));
    		 
    		User creator = FreelancerLogicImpl.returnUserByID(creatorID);
    		User freelancer = FreelancerLogicImpl.returnUserByID(freelancerID);
    		Task task =FreelancerLogicImpl.returnTaskByID(taskID); 
    		
    		 
    		
    			int success = FreelancerLogicImpl.addTransaction( creator,  freelancer,  task,  amount);
    			double accountBalance =FreelancerLogicImpl.returnAccountBalance(creator);
    			
    			FreelancerLogicImpl.addRating(creator, rating);
         	    String json = new Gson().toJson(success);

         	   //If the above success method works, you can try updating with this new account balance!
//         	   double accountBalance =FreelancerLogicImpl.returnAccountBalance(creator);
//         	   String json = new Gson().toJson(accountBalance);
         	    
         	    response.setContentType("application/json");
         	    response.setCharacterEncoding("UTF-8");
         	    response.getWriter().write(json);
         	    System.out.println(json);

//             runTemplate(request, response);
         }
         catch (SQLException e)
         {
             e.printStackTrace();
         }
    }

   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
		System.out.println("POSTPOST"); 
        doGet(request, response);
    }

}