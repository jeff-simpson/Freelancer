package edu.uga.cs4300.boundary;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Type;
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
import com.google.gson.reflect.TypeToken;
import com.mysql.jdbc.Connection;


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


@WebServlet("/AjaxBoundary")
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

    
	private void completeTransaction(HttpServletResponse response, User receiver, User giver, Task task) throws SQLException {

		System.out.println("I got here");
		
		FreelancerLogicImpl.completeFullTransaction( giver,receiver, task);
		
		ArrayList<User> users = new ArrayList<User>();
		User user= FreelancerLogicImpl.returnUserByID(giver.getId());
		users.add(user);
		response.setContentType("application/json");
		Gson gson = new Gson();
		Type type = new TypeToken<List<User>>(){}.getType();
		String json = gson.toJson(users, type);
		try {
			PrintWriter out = response.getWriter();
			out.println(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	System.out.println("Jeff I am here");
    	
    	int receiverID = Integer.parseInt(request.getParameter("receiverID"));
    	System.out.println(receiverID);
    	int giverID = Integer.parseInt(request.getParameter("giverID"));
    	int taskID = Integer.parseInt(request.getParameter("taskID"));
    	
    	try {
    		
			User reciever = FreelancerLogicImpl.returnUserByID(receiverID);
			User giver = FreelancerLogicImpl.returnUserByID(giverID);
			Task task = FreelancerLogicImpl.returnTaskByID(taskID);
			completeTransaction( response,  reciever, giver,  task);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }

   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
		System.out.println("POSTPOST"); 
        doGet(request, response);
    }

}