package de.exxcellent.challenge.model;

import java.util.*;

//structure to keep record of a single element in the whole colection
public class Record{
	private HashMap<String, String> data; //HashMap to store data against each key from CSV file
	
	public Record(){
		data = new HashMap<String, String>();
	}
	
	//create a record with map initialized
	public Record(String[] keys, String[] values){
		if(keys.length != values.length)
			return;
		data = new HashMap<String, String>();
		for(int i=0; i < keys.length; ++i){
			data.put(keys[i],values[i]);
		}
	}
	
	public String getData(String key){
		return data.get(key);
	}
	
	public void insertData(String[] keys, String[] values){
		if(keys.length != values.length)
			return;
		
		for(int i=0; i < keys.length; ++i){
			data.put(keys[i],values[i]);
		}
	}
	
	public int size(){
		if(data == null)
			return 0;
		return data.size();
	}
}