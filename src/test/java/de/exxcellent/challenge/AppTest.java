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
	private PrintWriter weatherFile;
	
	private void createFile(String fileName) throws IOException{
		//create a sample weather test file with append mode = false
		FileWriter write = new FileWriter( fileName , false);
		weatherFile = new PrintWriter( write ); //FileWriter supports only bytes. PrintWriter supports text writing
	}
		
	private void createWeatherCSV() throws IOException{
		//create file
		createFile(weatherCSVPath);
		
		//put test data into the file and close
		String line = "Day,MxT,MnT,AvT,AvDP,1HrP TPcpn,PDir,AvSp,Dir,MxS,SkyC,MxR,Mn,R AvSLP";
		weatherFile.printf("%s,%n", line);
		line = "1,88,59,74,53.8,0,280,9.6,270,17,1.6,93,23,1004.5";
		weatherFile.printf("%s,%n", line);			
		line = "2,79,63,71,46.5,0,330,8.7,340,23,3.3,70,28,1004.5";
		weatherFile.printf("%s,%n", line);
		line = "3,77,55,66,39.6,0,350,5,350,9,2.8,59,24,1016.8";
		weatherFile.printf("%s,%n", line);
		
		weatherFile.close();
	}

    @Before
    public void setUp() throws Exception {
        successLabel = "successful";
		//create test weather data
		createWeatherCSV();
		
		
    }
	
	@Test
	public void csvDataReading(){//test to check that data is read correctly
		AllRecords weatherRecords = new AllRecords();
		weatherRecords.getInputData(weatherCSVPath);
		
		Assert.assertEquals("All records read", 3, weatherRecords.size());
		Record r = weatherRecords.getRecord(0);
		Assert.assertEquals("Correct number of columns", 14, r.size());
	}

    @Test
    public void dayWithSmallestTempSpread() {
		AllRecords weatherRecords = new AllRecords();
		weatherRecords.getInputData(weatherCSVPath);
		
        Assert.assertEquals("Day with smallest temprature spread is correct", weatherRecords.getRecord(1), weatherRecords.recWithSmallestDifference("MxT","MnT"));
    }

}