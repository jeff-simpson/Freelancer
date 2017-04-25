package edu.uga.cs4300.boundary;



import java.awt.List;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

import edu.uga.cs4300.logiclayer.FreelancerLogicImpl;
import edu.uga.cs4300.objectlayer.Task;
import edu.uga.cs4300.objectlayer.User;
import edu.uga.cs4300.persistlayer.DatabaseAccess;
import edu.uga.cs4300.persistlayer.FreelancerPersistImpl;
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
    DefaultObjectWrapperBuilder df = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
    SimpleHash root = new SimpleHash(df.build());
    
    public FreelancerBoundary()
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

    public static boolean empty( final String s )
    {
    	  return s == null || s.trim().isEmpty();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	String button = request.getParameter("button");
    	
    	System.out.println(button);
    	
    	// to dynamically accept tasks
    	if (request.getParameterMap().containsKey("offerToTakeTask"))
    	{
    		String taskID = request.getParameter("taskID");
    		String userID = request.getParameter("userID");
    	}
    	
        if(button.equals("Login!")){
			try {
				runLogin(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
		}
        else if(button.equals("Sign In!")){ 
        	try {
        		System.out.println("Sign in");
				runLogin(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }
     
        else if(button.equals("Sign Up!")){ 
        	try {
        		System.out.println("Sign up!");
				signUp(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }
     
        
        else if(button.equals("Create Account")){ 
        	try {
        		
				signUp(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }
        
        else if(button.equals("My Profile")){ 
        	try {
				myProfile(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        else if(button.equals("Sign Out")){
        	try {
				signOut(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }
        else if(button.equals("Create Task")){
        	try {
        		System.out.println("Here we are jeff");
				runTemplate(request,response,"submittask"); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }
        else if(button.equals("Submit Task")){ 
        	try {
				submitTask(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }
        else if(button.equals("Home")){ 
        	try {
				runWelcome(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }
        else if(button.equals("In Progress")|| button.equals("Completed") || button.equals("Not Started")|| button.equals("pending request")){ 
        	try {
        		System.out.println("hit pending");
        		
				theirProfile(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }
        else if(button.equals("Open") ||(button.equals("Awaiting Payment") )){ 
        	try {
				runWelcome(request,response); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }
        else if(button.equals("Accept Offer")){ 
        	try {
				acceptPerformerOffer(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }
        else if(button.equals("Decline Offer")){ 
        	
        	try {
				declinePerformerOffer(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }
        
        else if(button.equals("Pay")){ 
        	
        	try {
        		goToTransactionPage(request,response); 
        		//runTemplate(request,response,"transactions"); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }
        
        else if(button.equals("Decline")){ 
        	
        	try {
				declinePerformerOffer(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }
        
        else if(button.equals("Offer Your Services")){ 
        	
        	try {
				offerServices(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }	
        
        else if(button.equals("Add Skill")){ 
        	
        	try {
				addSkill(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }	
        else if(button.equals("Add to Balance")){ 
        	
        	try {
				updateBalance(request,response); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }
        
        else if(button.equals("Mark Complete")){ 
        	
        	try {
				markComplete(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }
    }
    

    private void markComplete(HttpServletRequest request, HttpServletResponse response) throws SQLException {
	
    	int taskID = Integer.parseInt(request.getParameter("taskID")); 
		Task t = FreelancerLogicImpl.returnTaskByID(taskID);
		FreelancerLogicImpl.updateTaskStatus(t, "Awaiting Payment");
		runWelcome(request,response); 
    }

	private void updateBalance(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		Double balance= Double.parseDouble(request.getParameter("balance")); 
		System.out.println(balance);
		User u = (User) request.getSession().getAttribute("user"); 
		FreelancerLogicImpl.updateAccountBalance(u,balance); 
		
		myProfile(request,response);
	}

	private void addSkill(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String skill = request.getParameter("skill"); 
		User u = (User) request.getSession().getAttribute("user"); 
		FreelancerLogicImpl.addSkills(u, skill);
		
		myProfile(request,response); 
	}

	private void payUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
    	int taskID = Integer.parseInt(request.getParameter("taskID")); 
    	
    	Task t = FreelancerLogicImpl.returnTaskByID(taskID); 
    	User b = FreelancerLogicImpl.returnTaskPerformer(t); 
    	User a = (User) request.getSession().getAttribute("user");
		
    	//FreelancerLogicImpl.addTransaction(a, b, t, t.getPrice()); 
    	
    	root.put("giver", a);
    	root.put("receiver", b);
    	root.put("task", t);
    	
    	
    	
		runTransactions(request,response); 
	}
	
	
	private void goToTransactionPage(HttpServletRequest request, HttpServletResponse response) throws SQLException {
    	int taskID = Integer.parseInt(request.getParameter("gtaskID")); 
    	
    	Task t = FreelancerLogicImpl.returnTaskByID(taskID); 
    	User b = FreelancerLogicImpl.returnTaskPerformer(t); 
    	User a = (User) request.getSession().getAttribute("user");
    	
    	User user =FreelancerLogicImpl.returnUserByID(a.getId());
		
    	//FreelancerLogicImpl.addTransaction(a, b, t, t.getPrice()); 
    	
    	root.put("giver", a);
    	root.put("receiver", b);
    	root.put("task", t);
    	
    	
		runTransactions(request,response); 
	}

	private void runTransactions(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		runTemplate(request,response,"transactions");
		
	}

	private void offerServices(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int taskID = Integer.parseInt(request.getParameter("taskID")); 
		Task t = FreelancerLogicImpl.returnTaskByID(taskID);
		User offerer = (User) request.getSession().getAttribute("user");
		FreelancerLogicImpl.offerServices(offerer, t);
		runWelcome(request,response);
		
	}

	private void declinePerformerOffer(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int taskID = Integer.parseInt(request.getParameter("taskID")); 
		int userID = Integer.parseInt(request.getParameter("performerID")); 
		String status = "decline";
		User u = FreelancerLogicImpl.returnUserByID(userID);
		Task t = FreelancerLogicImpl.returnTaskByID(taskID);
	    FreelancerLogicImpl.updateOfferStatus(u,t, status );
	    runWelcome(request,response);
		
	}

	private void acceptPerformerOffer(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int taskID = Integer.parseInt(request.getParameter("taskID")); 
		int userID = Integer.parseInt(request.getParameter("performerID")); 
		User u = FreelancerLogicImpl.returnUserByID(userID);
		Task t = FreelancerLogicImpl.returnTaskByID(taskID);
		String status = "accept";
		FreelancerLogicImpl.updateOfferStatus(u,t, status ); 
		runWelcome(request,response);
		
	}

	private void theirProfile(HttpServletRequest request, HttpServletResponse response) throws SQLException {
    	System.out.println("running their");
		String taskid = request.getParameter("gtaskID");
//		System.out.println("Task id: " + taskid);
		User taskGiver = (User) request.getSession().getAttribute("user"); 
		
		Task t = FreelancerLogicImpl.returnTaskByID(Integer.parseInt(taskid));
		System.out.println("Task id: "+ t.getId());
		User offerer = FreelancerLogicImpl.returnOfferer(t); 
		
		System.out.println("GOING TO USER'S ACCOUNT: " + offerer.getEmail());
		
		ArrayList<Task> tasks_taken = FreelancerLogicImpl.getTasksTaken(offerer); 
		ArrayList<Task> tasks_given = FreelancerLogicImpl.getTasksGiven(offerer); 
		
		ArrayList<Task> task_history = new ArrayList<Task>(); 
		task_history.addAll(tasks_taken); 
		task_history.addAll(tasks_given); 
		
		ArrayList<String> skills = FreelancerLogicImpl.returnAllSkills(offerer);
		root.put("taskid", taskid);
		root.put("skills", skills);
		root.put("tasks_taken", tasks_taken);
		root.put("tasks_given", tasks_given);
		root.put("task_history", task_history);
		root.put("userofferer", offerer);
		root.put("NAME", offerer.getFirstName()); 
		root.put("RANK", FreelancerLogicImpl.returnAverageRating(offerer));
		root.put("EMAIL", offerer.getEmail());
		
		runTemplate(request,response,"profile"); 
	}

	private void runLogin(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String username = request.getParameter("username"); 
		String password = request.getParameter("password");
		boolean verified = FreelancerLogicImpl.verifyUser(username, password);
		HttpSession session = request.getSession(); 
		if(verified){
		User u = FreelancerLogicImpl.returnUserByEmail(username);
		session.setAttribute("user",u );
		root.put("user", u);
		System.out.println("running welcome");
		runWelcome(request,response); 
		}
		else{
			runTemplate(request,response,"loginError");
		}
	}

	private void submitTask(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		User u = (User) request.getSession().getAttribute("user"); 
		Task t = new Task(); 
		
		String description = request.getParameter("description");
		t.setDescription(description);
		System.out.println(description);
		
		LocalDateTime dateTime = LocalDateTime.now();
		String time = dateTime.getHour() +":" + dateTime.getMinute() + " "+ dateTime.getDayOfMonth() + "/" + dateTime.getDayOfMonth() + "/" + dateTime.getYear(); 
		t.setTime(time);
		
		String price = request.getParameter("price");
		t.setPrice(Double.parseDouble(price));
		
		String difficulty=  request.getParameter("difficulty");
		t.setDifficulty(Integer.parseInt(difficulty));
	   
		String location = request.getParameter("location"); 
	    t.setLocation(location);
		
	    int userID = u.getId(); 
		t.setUserID(userID);
		
		int taskID = FreelancerLogicImpl.addTask(t);
		Task p = FreelancerLogicImpl.returnTaskByID(taskID); 
		System.out.println(p.getDescription());
		root.put("task", p);
		root.put("user", u);
		
		runWelcome(request,response); 

	}
	
	private void viewTask(HttpServletRequest request, HttpServletResponse response, String taskID) throws SQLException{ 
		runTemplate(request,response,"task");
	}
	
	private void myProfile(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		System.out.println("running my profile");
		User u = (User) request.getSession().getAttribute("user");
		System.out.println(u.getEmail());
		
		ArrayList<Task> tasks_taken = FreelancerLogicImpl.getTasksTaken(u); 
		ArrayList<Task> tasks_given = FreelancerLogicImpl.getTasksGiven(u); 
		ArrayList<Task> task_history = new ArrayList<Task>(); 
		task_history.addAll(tasks_taken); 
		task_history.addAll(tasks_given); 
		
		ArrayList<String> skills = FreelancerLogicImpl.returnAllSkills(u);
		
		double balance = FreelancerLogicImpl.returnAccountBalance(u);
		for(String e: skills){ 
			System.out.println(e);
		}
		System.out.println("blaance being pushed" + balance);
		root.put("skills", skills);
		root.put("balance", balance);
		root.put("tasks_available", task_history);
		root.put("tasks_taken", tasks_taken);
		root.put("tasks_given", tasks_given);
		root.put("user", u);
		root.put("NAME", u.getFirstName()); 
		root.put("RANK", FreelancerLogicImpl.returnAverageRating(u));
		root.put("EMAIL", u.getEmail());
		root.put("task_history", task_history);
		
		runTemplate(request,response,"myProfile"); 
		
	}

	private void signOut(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		request.changeSessionId(); 
		request.getSession().invalidate();
		try { response.sendRedirect("index.html"); }
		catch (IOException e) { e.printStackTrace(); }
	}

	private void signUp(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		 String firstName = request.getParameter("Firstname");
		 String lastName = request.getParameter("Lastname"); 
		 String email = request.getParameter("email");
		 String password = request.getParameter("password"); 
		 User u = new User();
		 u.setEmail(email);
		 u.setPassword(password);
		 u.setFirstName(firstName);
		 u.setLastName(lastName);
		 
		 System.out.println(u.getEmail());
		 FreelancerLogicImpl.addUser(u);
		 User u2 = FreelancerLogicImpl.returnUserByEmail(u.getEmail());
		 System.out.println(u.getEmail());
//		 System.out.println("Session First Name" + u2.getFirstName());
		 request.getSession().setAttribute("user", u2);
		 runWelcome(request,response); 
		
	}

	private void runWelcome(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		System.out.println("inside welcome!");
		User u = (User) request.getSession().getAttribute("user") ;
		System.out.println("TRYING TO GET TASKS");
		User user = FreelancerLogicImpl.returnUserByEmail(u.getEmail());
		ArrayList<Task> tasks_available = FreelancerLogicImpl.returnAvailableTasksNotYours(user);
		ArrayList<Task> tasks_taken = FreelancerLogicImpl.getTasksTaken(user); 
		ArrayList<Task> tasks_given = FreelancerLogicImpl.getTasksGiven(user);
		
		//System.out.println("User On Welcome Page Do this: " + user.getId());
//		for(Object e : tasks_available){ 
//			System.out.println(((Task) e).getDescription());
//		}
//		
//		System.out.println("task given");
//		for(Object d : tasks_given){ 
//			System.out.println(((Task) d).getDescription());
//		}
		
		root.put("user",user); 
		root.put("tasks_available", tasks_available);
		root.put("tasks_taken", tasks_taken);
		root.put("tasks_given", tasks_given);
		request.getSession().setAttribute("user", user);
    	runTemplate(request, response,"welcome");
	}

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	 System.out.println("POSTPOST"); 
        doGet(request, response);
    }
	
	

}