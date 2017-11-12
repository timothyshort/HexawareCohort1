package freddie.frameworks;

import org.junit.After;
// Make sure to import org.junit.Assert and DO NOT import org.framework.Assert
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JUnitTest01 {
	
	@Test
	public void pageTitleSmokeTest() {
		// setUp();
		System.out.println(" *We wil run a smoke test*");
		String expectedTitle = " Freddie Selenium Training Page";
		String actualTitle = " TrainingRite Selenium Training";
		// tearDown();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
	public void pageURLSmokeTest() {
		System.out.println(" *We will run another smoke test*");
	}
	
	@Before
	public void setUp() {
		System.out.println("Getting data from database");
		System.out.println("Initialize driver");
	}
	
	@After
	public void tearDown() {
		System.out.println("Close DB connection");
		System.out.println("Close the driver");
	}

}
