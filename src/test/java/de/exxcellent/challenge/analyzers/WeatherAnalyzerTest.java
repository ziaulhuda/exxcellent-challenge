package de.exxcellent.challenge.analyzers;

import de.exxcellent.challenge.model.*;
import de.exxcellent.challenge.readers.*;
import de.exxcellent.challenge.CreateCSVData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Example JUnit4 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public class WeatherAnalyzerTest {
	
	private WeatherAnalyzer wa; 
		
    @Before
    public void setUp() throws Exception {
		CreateCSVData.createWeatherCSV();
		CSVReader cr = new CSVReader();
		Database db = cr.readData(CreateCSVData.weatherCSVPath);
		
		wa = new WeatherAnalyzer(db);
    }

	@Test
	public void comparatorReturnsCorrectly(){
		
		String val = wa.dayWithSmallestTempSpread();
		
		Assert.assertEquals("Day with smallest temperature spread is correct", val, "2");		
	}

}