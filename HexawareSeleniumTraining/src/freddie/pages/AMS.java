package freddie.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AMS {
	
	// Click Create Account
	public static void clickCreateAccount(WebDriver driver) {
		// Click on create account
	}
	
	// Enter Login Details
	public static void setUsername(WebDriver driver, String username) {
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys(username);
	}
	
	public static void setPassword(WebDriver driver, String password) {
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
	}
	
	public static void clickGo(WebDriver driver) {
		driver.findElement(By.id("MainContent_btnLogin")).click();
	}
	
	public static void login(WebDriver driver, String username, String password) {
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys(username);
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
		driver.findElement(By.id("MainContent_btnLogin")).click();
	}

}
