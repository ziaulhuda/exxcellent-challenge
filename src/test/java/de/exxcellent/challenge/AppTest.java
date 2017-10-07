package de.exxcellent.challenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Example JUnit4 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public class AppTest {

    private String successLabel = "not successful";
	
	
	
		
	
	
	

    @Before
    public void setUp() throws Exception {
        successLabel = "successful";
		//create test weather data	
    }
	
/*	@Test
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
*/
}