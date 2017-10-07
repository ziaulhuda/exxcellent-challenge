package de.exxcellent.challenge.model;

import java.util.*;

//class to handle whole data and operations on it.
public class Database{
	private ArrayList<Record> entries;
	
	public Database(){
		entries = new ArrayList<Record>();
	}
	
	public int size(){
		return entries.size();
	}
	
	public Record get(int x){
		if(x >= entries.size())
			return null;
		return entries.get(x);
	}
	
	public void insert(String[] keys, String[] values){
		if(keys.length != values.length)
			return;
		
		Record rec = new Record(keys, values);
		entries.add(rec);
	}
}