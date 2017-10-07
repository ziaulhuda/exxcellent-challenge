package de.exxcellent.challenge.readers;

import de.exxcellent.challenge.model.*;
import de.exxcellent.challenge.CreateCSVData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Example JUnit4 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public class CSVReaderTest {
	
	private CSVReader cr;
	
    @Before
    public void setUp() throws Exception {
		CreateCSVData.createWeatherCSV();
		cr = new CSVReader();
    }

	@Test
	public void correctReading(){
		
		Database db = cr.readData(CreateCSVData.weatherCSVPath);
		
		Assert.assertEquals("Size of database", 3, db.size());
		String v = db.get(0).getData("Day");
		Assert.assertEquals("Correct value", "1", v);
	}

}