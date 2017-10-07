package de.exxcellent.challenge;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class CreateCSVData{
	
	public static String weatherCSVPath = System.getProperty("user.dir") + "/target/test-classes/de/exxcellent/challenge/weather.csv";
	public static String footballCSVPath = System.getProperty("user.dir") + "/target/test-classes/de/exxcellent/challenge/football.csv";
	private static PrintWriter file;
	
	private static void createFile(String fileName) throws IOException{
		//create a sample weather test file with append mode = false
		FileWriter write = new FileWriter( fileName , false);
		file = new PrintWriter( write ); //FileWriter supports only bytes. PrintWriter supports text writing
	}
	
	public static void createWeatherCSV() throws IOException{
		//create file
		createFile(weatherCSVPath);
		
		//put test data into the file and close
		String line = "Day,MxT,MnT,AvT,AvDP,1HrP TPcpn,PDir,AvSp,Dir,MxS,SkyC,MxR,Mn,R AvSLP";
		file.printf("%s,%n", line);
		line = "1,88,59,74,53.8,0,280,9.6,270,17,1.6,93,23,1004.5";
		file.printf("%s,%n", line);			
		line = "2,79,63,71,46.5,0,330,8.7,340,23,3.3,70,28,1004.5";
		file.printf("%s,%n", line);
		line = "3,77,55,66,39.6,0,350,5,350,9,2.8,59,24,1016.8";
		file.printf("%s,%n", line);
		
		file.close();
	}
	
	public static void createFootballCSV() throws IOException{
		//create file
		createFile(footballCSVPath);
		
		//put test data into the file and close
		String line = "Team,Games,Wins,Losses,Draws,Goals,Goals Allowed,Points";
		file.printf("%s,%n", line);
		line = "Arsenal,38,26,9,3,79,36,87";
		file.printf("%s,%n", line);			
		line = "Manchester United,38,24,5,9,87,45,77";
		file.printf("%s,%n", line);
		line = "Liverpool,38,24,8,6,67,30,80";
		file.printf("%s,%n", line);
		
		file.close();
	}
	
}