package de.exxcellent.challenge;

import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */

//structure to keep record of a single element in the whole colection
class Record{
	private HashMap<String, String> data; //HashMap to store data against each key from CSV file
	
	Record(){
		data = new HashMap<String, String>();
	}
	
	//create a record with map initialized
	Record(String[] keys, String[] values){
		data = new HashMap<String, String>();
		for(int i=0; i < keys.length; ++i){
			data.put(keys[i],values[i]);
		}
	}
	
	String getData(String key){
		return data.get(key);
	}
	
	int size(){
		if(data == null)
			return 0;
		return data.size();
	}
}

//class to handle whole data and operations on it.
class AllRecords{
	private ArrayList<Record> records;
	
	AllRecords(){
		records = new ArrayList<Record>();
	}
	
	int size(){
		return records.size();
	}
	
	Record getRecord(int x){
		if(records == null || x >= records.size())
			return null;
		return records.get(x);
	}
	
	//reads the input csv file and updates records list
	void getInputData(String fileName){
		Path pathToFile = Paths.get(fileName);
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			// read the headers from the text file 
			String line = br.readLine();
			if(line.isEmpty()){
				//invalid csv file.
				System.out.println("Invalid file format");
				System.exit(1);
			}
			
			//get the attribute headers
			String[] keys = line.split(",");
			
			line = br.readLine(); //read next line
			
			while(line != null){//iterate over whole file and add new record per line
				String[] values = line.split(",");
				
				Record rec = new Record(keys, values);
				records.add(rec);
				line = br.readLine();
			}

		}catch (IOException ioe) {
            ioe.printStackTrace();
			System.exit(1);
        }
	}
	
	//Function to return the Record obj with smallest diff between the values of the two columns provided
	Record recWithSmallestDifference(String first, String second){
		
		//initialize the smallest record with the first element of the records
		Record smallestRec = records.get(0);
		double smallestDiff = Math.abs(Double.parseDouble(records.get(0).getData(first)) - Double.parseDouble(records.get(0).getData(second)));
		double temp;
		
		//iterate over wholel list
		for(int i=1; i < records.size(); ++i){
			temp = Math.abs(Double.parseDouble(records.get(i).getData(first)) - Double.parseDouble(records.get(i).getData(second)));
			
			//new minimum difference found
			if (temp < smallestDiff){
				smallestRec = records.get(i);
				smallestDiff = temp;
			}
		}
		
		return smallestRec;
	}
}

//specialized class for weather log
class WeatherLog extends AllRecords{
	//specialized function to find the day with smallest temprature spread
	String dayWithSmallestTempSpread(){
		Record s = recWithSmallestDifference("MxT", "MnT");
		
		if(s == null)
			return null;
		return s.getData("Day");
	}
}

//specialized class for EPL teams records
class EPLRecords extends AllRecords{
	//specialized function to find the team with smallest goal difference
	String teamWithSmallesGoalSpread(){
		Record s = recWithSmallestDifference("Goals", "Goals Allowed");
		
		if(s == null)
			return null;
		return s.getData("Team");
	}
}

public final class App {

    public static void main(String... args) {

        // Your preparation code …
		WeatherLog wl = new WeatherLog();
		
		//the input files can also be taken as input params to the program.
		wl.getInputData(System.getProperty("user.dir") + "/target/classes/de/exxcellent/challenge/weather.csv");
		
		EPLRecords epl = new EPLRecords();
		epl.getInputData(System.getProperty("user.dir") + "/target/classes/de/exxcellent/challenge/football.csv");
		
		String dayWithSmallestTempSpread = wl.dayWithSmallestTempSpread();     // Your day analysis function call …
        String teamWithSmallesGoalSpread = epl.teamWithSmallesGoalSpread(); // Your goal analysis function call …

        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallesGoalSpread);
    }
}
