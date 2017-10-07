package de.exxcellent.challenge.readers;

import de.exxcellent.challenge.model.*;
import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths;

//class to read csv files and create a database
public class CSVReader implements FileReader{
	
	public Database readData(String fileName){
		Database db = null;
		Path pathToFile = Paths.get(fileName);

		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			// read the headers from the text file 
			String line = br.readLine();
			if(line.isEmpty()){
				//invalid csv file.
				System.out.println("Invalid CSV file.");
				return null;
			}
			
			db = new Database();
			
			//get the attribute headers
			String[] keys = line.split(",");
			
			line = br.readLine(); //read next line
			
			while(line != null){//iterate over whole file and add new record per line
				String[] values = line.split(",");
				
				db.insert(keys, values);
				line = br.readLine();
			}

		}catch (IOException ioe) {
            ioe.printStackTrace();
			return null;
        }
		
		return db;
	}
}