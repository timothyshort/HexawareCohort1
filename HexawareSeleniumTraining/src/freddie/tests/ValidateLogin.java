package freddie.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import freddie.pages.AMS;
import freddie.pages.AMSPage;
import freddie.pages.DashboardPage;
import freddie.pages.Home;
import freddie.utilities.DriverFactory;
import freddie.utilities.GlobalSettings;

public class ValidateLogin {
	WebDriver driver;
	String email = "tim@testemail.com";
	String password = "trpass";
	
	@Before
	public void setup() {
		driver = DriverFactory.start();
		driver.get(GlobalSettings.rootWebURL);
		
		// Home Page
		Home.clickAMS(driver);
		// driver.findElement(By.linkText("Account Management System")).click();
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	// Test
	@Test
	@Ignore
	public void validateLoginTest1() {
		// Login (AMS)
		AMS.setUsername(driver, email);
		AMS.setPassword(driver, password);
		AMS.clickGo(driver);		
	}
	
	@Test
	@Ignore
	public void validateLoginTest2() {
		AMS.login(driver, email, password);
	}
	
	@Test
	public void validateLoginTest3() {
		AMSPage AMSPage = new AMSPage(driver);
		AMSPage.login(email, password);
		
		DashboardPage Dashboard = new DashboardPage(driver);
		Assert.assertTrue(Dashboard.getConfirmMessage().contains("success"));
	}
		
	


}
