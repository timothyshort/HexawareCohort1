package freddie.frameworks;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTest01 {
	
	@Test(enabled=false)
	public void mySecondTest() {
		System.out.println("Test2");
	}
	
	@Test(priority = 1)
	public void myFirstTest() {
		System.out.println("Test1");
	}
	
	@Test(priority = 3)
	public void myThirdTest() {
		System.out.println("Test1");
	}
	
	@BeforeMethod
	public void setUp() {
		System.out.println("Setup");
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Teardown");
	}

}
