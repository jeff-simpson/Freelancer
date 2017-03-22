package edu.uga.cs4300.objectlayer;

public class Task {
	
	private int id;
	private String description;
	private String time;
	private String price;
	private int difficulty;
	private String location;

	public Task ()
	{
		
	}
	
	

	public Task(int id, String description, String time, String price, int difficulty, String location) {
		super();
		this.id = id;
		this.description = description;
		this.time = time;
		this.price = price;
		this.difficulty = difficulty;
		this.location = location;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
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