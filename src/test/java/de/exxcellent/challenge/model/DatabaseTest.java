package de.exxcellent.challenge.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Example JUnit4 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public class DatabaseTest {

	private String[] keys = {"a","b","c"}; 
	private String[] values = {"first","second","third"}; 
	Database db;
	
    @Before
    public void setUp() throws Exception {
		db = new Database();
    }
	
    @Test
    public void doNotAcceptWrongInput() {
		String[] k = {"a", "b"};
		String[] v = {"first"};
		db.insert(k,v);
		
        Assert.assertEquals("Data is not inserted", 0, db.size());
    }

	@Test
	public void correctInsert(){
		
		db.insert(keys, values);
		
		Assert.assertEquals("Size of database", 1, db.size());
		String v = db.get(0).getData("b");
		Assert.assertEquals("Correct value", "second", v);
	}

}