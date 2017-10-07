package de.exxcellent.challenge.analyzers;

import de.exxcellent.challenge.model.*;
import java.util.*;

//specialized class for EPL teams records
public class EPLAnalyzer extends Analyzer{
	
	public EPLAnalyzer(Database d){
		super(d);
	}
	
	//specialized function to find the team with smallest goal difference
	public String teamWithSmallesGoalSpread(){
		Record s = recWithSmallestDifference("Goals", "Goals Allowed");
		
		if(s == null)
			return null;
		return s.getData("Team");
	}
}