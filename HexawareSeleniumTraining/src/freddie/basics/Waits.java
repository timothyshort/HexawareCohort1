package freddie.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import freddie.utilities.DriverFactory;
import freddie.utilities.GlobalSettings;

public class Waits {

	public static void main(String[] args) {
		String email = "rachel.simmons@testemail.com";
		String password = "password";
		
		System.setProperty("webdriver.chrome.driver", GlobalSettings.driverDirectory + "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		// Define the IMPLICIT wait, which is true for all elements
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// Create EXPLICIT Wait for specific element(s)
		
		// 1. Define the wait
		WebDriverWait wait = new WebDriverWait(driver, 3);
		
		// 2. Define a web element with the wait condition
		WebElement emailBox = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("MainContent_txtUserName"))));
		WebElement passwordBox = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("MainContent_txtPassword"))));
		WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("MainContent_btnLogin"))));
		
		emailBox.sendKeys(email);
		passwordBox.sendKeys(password);
		submitButton.click();
		
		// Exercise: apply wait to the Login button and use the element clickable condition
		
	}

}
