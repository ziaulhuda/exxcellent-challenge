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
public class EPLAnalyzerTest {
	
	private EPLAnalyzer epla; 
		
    @Before
    public void setUp() throws Exception {
		CreateCSVData.createFootballCSV();
		CSVReader cr = new CSVReader();
		Database db = cr.readData(CreateCSVData.footballCSVPath);
		
		epla = new EPLAnalyzer(db);
    }

	@Test
	public void comparatorReturnsCorrectly(){
		
		String val = epla.teamWithSmallesGoalSpread();
		
		Assert.assertEquals("Team with smallest goal spread is correct", val, "Liverpool");		
	}

}