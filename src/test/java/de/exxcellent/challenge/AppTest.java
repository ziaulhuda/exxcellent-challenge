package de.exxcellent.challenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * Example JUnit4 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public class AppTest {

    private String successLabel = "not successful";
	private String weatherCSVPath = System.getProperty("user.dir") + "/target/test-classes/de/exxcellent/challenge/weather.csv";
	private String footballCSVPath = System.getProperty("user.dir") + "/target/test-classes/de/exxcellent/challenge/football.csv";
	private PrintWriter file;
	
	private void createFile(String fileName) throws IOException{
		//create a sample weather test file with append mode = false
		FileWriter write = new FileWriter( fileName , false);
		file = new PrintWriter( write ); //FileWriter supports only bytes. PrintWriter supports text writing
	}
		
	private void createWeatherCSV() throws IOException{
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
	
	private void createFootballCSV() throws IOException{
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

    @Before
    public void setUp() throws Exception {
        successLabel = "successful";
		//create test weather data
		createWeatherCSV();
		createFootballCSV();
		
    }
	
	@Test
	public void csvDataReading(){//test to check that data is read correctly
		AllRecords records = new AllRecords();
		records.getInputData(weatherCSVPath);
		
		Assert.assertEquals("All records read", 3, records.size());
		Record r = records.getRecord(0);
		Assert.assertEquals("Correct number of columns", 14, r.size());
	}

    @Test
    public void dayWithSmallestTempSpread() {
		WeatherLog wl = new WeatherLog();
		wl.getInputData(weatherCSVPath);
		
        Assert.assertEquals("Day with smallest temprature spread is correct", "2", wl.dayWithSmallestTempSpread());
    }
	
    @Test
    public void teamWithSmallesGoalSpread() {
		EPLRecords epl = new EPLRecords();
		epl.getInputData(footballCSVPath);
		
        Assert.assertEquals("Team with smallest goal difference is correct", "Liverpool", epl.teamWithSmallesGoalSpread());
    }

}