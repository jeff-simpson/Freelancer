package edu.uga.cs4300.objectlayer;

public class Person {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private boolean isAdmin;
	private double rating;
	private double balancePayable;
	private double balanceReceivable;
	private double balance;

	public Person ()
	{
		
	}
	
	public Person (int id, String firstName, String lastName, String email,  String password, boolean isAdmin, double rating, double balancePayable, double balanceRecievable, double balance)
	{
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password =  password;
		this.isAdmin = isAdmin;
		this.rating = rating;
		this.balancePayable = balancePayable;
		this.balanceReceivable = balanceRecievable;
		this.balance = balance;

		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public double getBalancePayable() {
		return balancePayable;
	}

	public void setBalancePayable(double balancePayable) {
		this.balancePayable = balancePayable;
	}

	public double getBalanceReceivable() {
		return balanceReceivable;
	}

	public void setBalanceReceivable(double balanceReceivable) {
		this.balanceReceivable = balanceReceivable;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
}
