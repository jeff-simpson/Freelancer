Current Methods:

	// Tasks
	 public static void addTask(HttpServletRequest request, HttpServletResponse response)
	 public static void updateTask(HttpServletRequest request, HttpServletResponse response)
	 public static void deleteTask(HttpServletRequest request, HttpServletResponse response)
	 public static Task returnTaskByID(HttpServletRequest request, HttpServletResponse response)

	//Users
	 public static void addUser(HttpServletRequest request, HttpServletResponse response)
	 public static void updateUser(HttpServletRequest request, HttpServletResponse response)
	 public static void deleteUser(HttpServletRequest request, HttpServletResponse response)
	 public static User returnUserByID(HttpServletRequest request, HttpServletResponse response)
	 public static User returnUserByUsername(HttpServletRequest request, HttpServletResponse response)
	 
	// Ratings 
	 public static void addRating(HttpServletRequest request, HttpServletResponse response)
	 public static ArrayList<Double> returnAllRatings(HttpServletRequest request, HttpServletResponse response) 
	 public static double returnAverageRating(HttpServletRequest request, HttpServletResponse response)
	 
	//Skills
	 public static void addSkills(HttpServletRequest request, HttpServletResponse response)
	
	





Methods Needed:
	// Tasks
	
	
	//// User 
	
	public static ResultSet returnUser(User user)
		
	
	/// Ratings

	
	// Skills
	public static ResultSet returnAllSkills(User user)
	
	// Assign Task
	
	public int assignTask(User user, Task task)
	public static ResultSet returnAllTasksViaUser(User user)
	public static ResultSet returnTaskPerformer(Task task)
	
	
	// Complete Task
	
	public int completeTask(Task task)
	
	//Transactions
	
	public int addTransaction(User creator, User performer, Task task, double amount)
	public int deleteTransaction(User creator, Task task, double amount)
	
	
	// Account Balance
	
	public static ResultSet returnAccountBalance(User user)
	public static int updateAccountBalance(User user, double balance) 

	



