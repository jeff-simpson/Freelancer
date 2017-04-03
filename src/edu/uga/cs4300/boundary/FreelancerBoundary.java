package edu.uga.cs4300.boundary;



import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import edu.uga.cs4300.persistlayer.DatabaseAccess;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.SimpleHash;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;


@WebServlet("/FreelancerBoundary")
public class FreelancerBoundary extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    Configuration cfg = null;
    static Connection con = (Connection) DatabaseAccess.connect();

    private String templateDir = "/WEB-INF/templates";

    public FreelancerBoundary()
    {
        super();
    }

    public void init()
    {
        cfg = new Configuration(Configuration.VERSION_2_3_25);
        cfg.setServletContextForTemplateLoading(getServletContext(), templateDir);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);

    }

    public void runTemplate(HttpServletRequest request, HttpServletResponse response, String name) throws SQLException
    {
        // You can use this structure for all of your objects to be sent to browser
        Template template = null;
        DefaultObjectWrapperBuilder df = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
        SimpleHash root = new SimpleHash(df.build());
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
    	String button = request.getParameter("button");
        if(button.equals("Login!")){
			try {
				runWelcome(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
		}
        else if(button.equals("Sign Up!")){ 
        	signUp(request,response); 
        }
        
        else if(button.equals("My Profile")){ 
        	myProfile(request,response);
        }
        else if(button.equals("Sign Out")){
        	signOut(request,response); 
        }
        else if(button.equals("Submit Task")){ 
        	submitTask(request,response); 
        }
    }

    private void submitTask(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void myProfile(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void signOut(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void signUp(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void runWelcome(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
    	runTemplate(request, response,"welcome");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

}