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
public class AnalyzerTest {
	
	private Analyzer anz;
	
    @Before
    public void setUp() throws Exception {
		CreateCSVData.createWeatherCSV();
		CSVReader cr = new CSVReader();
		Database db = cr.readData(CreateCSVData.weatherCSVPath);
		
		anz = new Analyzer(db);
    }

	@Test
	public void comparatorReturnsCorrectly(){
		
		Record rec = anz.recWithSmallestDifference("MxT","MnT");
		
		Assert.assertEquals("reord with smallest difference is correct", rec, anz.getDatabase().get(1));		
	}
	
	@Test
	public void comparatorReturnsNull(){
		
		Record rec = anz.recWithSmallestDifference("MxT","mock");
		
		Assert.assertEquals("reord is null", rec, null);		
	}

}