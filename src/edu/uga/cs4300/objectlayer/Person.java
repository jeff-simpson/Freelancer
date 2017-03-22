package edu.uga.cs4300.objectlayer;

public class Person {
	
	private int id;
	private String firstName;
	private String lastName;
	private int year;
	private double rank;
	
	public Movie ()
	{
		
	}
	
	
	public Movie(int id, String name, int year, double rank)
	{
		this.id = id;
		this.name = name;
		this.year = year;
		this.rank = rank;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public double getRank() {
		return rank;
	}


	public void setRank(double rank) {
		this.rank = rank;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
}
