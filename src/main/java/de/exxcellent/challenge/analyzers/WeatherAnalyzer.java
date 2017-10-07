package de.exxcellent.challenge.analyzers;

import de.exxcellent.challenge.model.*;
import java.util.*;

//specialized class for weather log
public class WeatherAnalyzer extends Analyzer{
	
	public WeatherAnalyzer(Database d){
		super(d);
	}
	
	//specialized function to find the day with smallest temprature spread
	public String dayWithSmallestTempSpread(){
		Record s = recWithSmallestDifference("MxT", "MnT");
		
		if(s == null)
			return null;
		return s.getData("Day");
	}
}