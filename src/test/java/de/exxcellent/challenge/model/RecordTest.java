package de.exxcellent.challenge.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Example JUnit4 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public class RecordTest {

	private String[] keys = {"a","b","c"}; 
	private String[] values = {"first","second","third"}; 
	Record record;
	
    @Before
    public void setUp() throws Exception {
		record = new Record(keys, values);
    }
	
	@Test
	public void correctCreation(){
		
		Assert.assertEquals("Size of record", 3, record.size());
		String v = record.getData("b");
		Assert.assertEquals("Correct value", "second", v);
	}

    @Test
    public void doNotAcceptWrongInput() {
		String[] k = {"a", "b"};
		String[] v = {"first"};
		record = new Record(k, v);
		
        Assert.assertEquals("Data in record not initialized", 0, record.size());
    }
}