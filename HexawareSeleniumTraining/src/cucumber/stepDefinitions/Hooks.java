package cucumber.stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import freddie.utilities.DriverFactory;

public class Hooks {
	WebDriver driver;
	
	@Before(order = 1)
	public void initializeBrowser() {
		driver = DriverFactory.start();
		System.out.println("Initializing WebDriver object");
	}
	
	@Before(order = 0)
	public void initalizeSetup() {
		System.out.println("Initialize settings and logger");
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
		System.out.println("Ending the WebDriver session");
	}

}
