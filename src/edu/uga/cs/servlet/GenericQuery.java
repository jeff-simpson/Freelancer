package edu.uga.cs.servlet;

import java.util.ArrayList;
import java.util.List;

class GenericQuery {

	private List<String> results;
	private List<String> headers;
	
	public GenericQuery() {
		results = new ArrayList<String>();
		headers = new ArrayList<String>();
	}

	public GenericQuery(ArrayList<String> query, ArrayList<String> header) {
		results = new ArrayList<String>();
		headers = new ArrayList<String>();
		
		for(int i = 0; i < query.size(); i++)
		{
			results.add(query.get(i));
		}
			
		for(int i = 0; i < header.size(); i++)
		{
			headers.add(header.get(i));
		}
	
			
	}

	public int getSize() {
		return headers.size();
	}
	
	public int getResultsSize() {
		return results.size();
	}
	
	public int getNumOfRows()
	{
		int size = 0;
		size = results.size() / headers.size();
		return size;
	}


	public String getQuery(int x) {
		return results.get(x);
	}
	
	public List<String> getHeaders() {
		return headers;
	}
	
	public List<String> getResults() {
		return results;
	}
	
}
