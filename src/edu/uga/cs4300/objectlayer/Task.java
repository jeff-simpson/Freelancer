package edu.uga.cs4300.objectlayer;

public class Task {
	
	private int id;
	private String description;
	private String time;
	private double price;
	private int difficulty;
	private String location;
	private int userID;

	public Task ()
	{
		
	}
	
	

	public Task(int id, String description, String time, double price, int difficulty, String location, int userID) {
		super();
		this.id = id;
		this.description = description;
		this.time = time;
		this.price = price;
		this.difficulty = difficulty;
		this.location = location;
		this.userID = userID;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserID() {
		return userID;
	}



	public void setUserID(int userID) {
		this.userID = userID;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}