package freddie.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LoginDemo {

	public static void main(String[] args) throws InterruptedException {
		
		String email = "rachel.simmons@testemail.com";
		String password = "password";
		
		// Step 1: Open browser
		WebDriver driver;
		
		// Which browser? >> IE
		System.setProperty("webdriver.chrome.driver", "C:\\HexawareTraining\\Cohort101\\Software\\chromedriver.exe");
		driver = new ChromeDriver();
		
		// Step 2: Go to URL
		driver.get("http://sdettraining.com/projects/");
		
		// Step 3: Click on Account Management System
			// How do we find the element?
			// What action do we perform?
		driver.findElement(By.linkText("Account Management System")).click();
		
		// PAUSE AND LET PAGE LOAD
		Thread.sleep(2000);
		
		// Step 4: Enter username
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys(email);
		
		// Step 5: Enter the password
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
		
		// Step 6: Click login button
		driver.findElement(By.id("MainContent_btnLogin")).click();
		
		
		// Step 7: Validate confirmation
		String confirmation = driver.findElement(By.id("conf_message")).getText();
		if (confirmation.equals("Logged in successfully")) {
			System.out.println("TEST PASSED");
		}
		else {
			System.out.println("TEST FAILED");
		}
		
		// Step 8: Close the browser
		Thread.sleep(2500);
		driver.quit();

	}

}
