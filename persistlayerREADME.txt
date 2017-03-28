Current Methods:
	// Tasks
	
	public static int addTask(Task task)
	public static int updateTask(Task task)
	public static int deleteTask(Task task)
	public static ResultSet returnTaskByID(int task_id)
	
	//// User 
	
	public static int addUser(User user)
	public static int updateUser(User user)
	public static int deleteUser(User user)
	public static ResultSet returnUserByID(int user_id)
	public static ResultSet returnUserByEmail(String email)
	public static ResultSet returnUser(User user)
		
	
	/// Ratings
	public static int addRating(User user, double rating)
	public static ResultSet returnAllRatings(User user)
	
	// Skills
	public static int addSkills(User user, String skill)
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

	
Needed Methods:
	

