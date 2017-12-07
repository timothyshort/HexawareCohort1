package freddie.data;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import freddie.utilities.CSV;
import freddie.utilities.DriverFactory;
import freddie.utilities.GlobalSettings;

@RunWith(value = Parameterized.class)
public class LoginTest {
	
	WebDriver driver;
	String email;
	String password = "trpass";
	
	@Before
	public void setup() {
		driver = DriverFactory.start();
		driver.get(GlobalSettings.AMSWebURL);
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void test() {
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys(email);
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
		driver.findElement(By.id("MainContent_btnLogin")).click();
	}
	
	// @Parameters: will take parameters from data source and provide to class
	@Parameters
	public static List<String[]> getTestData() {
		return CSV.get(GlobalSettings.TESTDATA + "LoginData.txt");
	}
	
	// Constructor
		// Receives params in argument from @Parameters for each iteration
		// Constructors MUST be named the same as the class name
		// Define class variables by params
	public LoginTest(String email, String password) {
		System.out.println(email + " " + password);
		this.email = email;
		this.password = password;
	}

}
