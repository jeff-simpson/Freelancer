Current Methods:

	// Tasks
	 public static void addTask(Task task)
	 public static void updateTask(Task task)
	 public static void deleteTask(Task task)
	 public static Task returnTaskByID(int task_id)

	//Users
	 public static void addUser(User user)
	 public static void updateUser(User user)
	 public static void deleteUser(User user)
	 public static User returnUserByID(int user_id)
	 
	// Ratings 
	 public static void addRating(User user, double rating)
	 public static ArrayList<Double> returnAllRatings(User user) 
	 public static double returnAverageRating(User user)
	 
	//Skills
	 public static void addSkills(User user, String skill)
	
	





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

	
