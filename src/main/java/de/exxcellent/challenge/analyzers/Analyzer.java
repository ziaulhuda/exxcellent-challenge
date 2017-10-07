package de.exxcellent.challenge.analyzers;

import de.exxcellent.challenge.model.*;
import java.util.*;

//Base class for analyzer classes

class Analyzer{
	private Database db;
	
	public Analyzer(){
		db = new Database();
	}
	
	public Analyzer(Database d){
		db = d;
	}
	
	public void setDatabase(Database d){
		db = d;
	}
	
	public Database getDatabase(){
		return db;
	}
	
	//Function to return the Record obj with smallest diff between the values of the two columns provided
	protected Record recWithSmallestDifference(String first, String second){
		
		//initialize the smallest record with the first element of the records
		Record smallestRec = db.get(0);
		String v1 = smallestRec.getData(first);
		String v2 = smallestRec.getData(second);
		if(v1==null || v2 == null)
			return null;
		
		double smallestDiff = Math.abs(Double.parseDouble(v1) - Double.parseDouble(v2));
		double temp;
		
		//iterate over wholel list
		for(int i=1; i < db.size(); ++i){
			temp = Math.abs(Double.parseDouble(db.get(i).getData(first)) - Double.parseDouble(db.get(i).getData(second)));
			
			//new minimum difference found
			if (temp < smallestDiff){
				smallestRec = db.get(i);
				smallestDiff = temp;
			}
		}
		
		return smallestRec;
	}
}