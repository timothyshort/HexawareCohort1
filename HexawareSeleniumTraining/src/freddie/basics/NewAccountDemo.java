package freddie.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import freddie.utilities.Checkbox;

public class NewAccountDemo {
	
	public static void main(String[] args) throws InterruptedException {
		// List all variables
		String name = "Rachel Simmons";
		String email = "rachel.simmons@testemail.com";
		String phoneNumber = "3213213214";
		String password = "password";
		String verifyPassword = "password";
		String country = "Finland";
		String gender = "female";
		boolean weeklyEmail = true;
		boolean monthlyEmail = false;
		boolean occasionalEmail = true;
		
		
		// Open the browser and navigate to home URL
		System.setProperty("webdriver.chrome.driver", "C:\\HexawareTraining\\Cohort101\\Software\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://sdettraining.com/projects/");
		Thread.sleep(500);
		
		// Click on Account Management link
		driver.findElement(By.partialLinkText("Account")).click();
		Thread.sleep(500);
		
		// Click Create Account button
		driver.findElement(By.linkText("CREATE ACCOUNT")).click();
		
		// Fill out the registration form
		driver.findElement(By.id("MainContent_txtFirstName")).sendKeys(name);
		driver.findElement(By.id("MainContent_txtEmail")).sendKeys(email);
		driver.findElement(By.id("MainContent_txtHomePhone")).sendKeys(phoneNumber);
		
		// Radio Button >> click
		if (gender.equalsIgnoreCase("female")) {
			driver.findElement(By.id("MainContent_Female")).click();
		}
		else if (gender.equalsIgnoreCase("male")) {
			driver.findElement(By.id("MainContent_Male")).click();
		}
		
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
		driver.findElement(By.id("MainContent_txtVerifyPassword")).sendKeys(verifyPassword);
		
		// Drop-down Menu (select) >> select by value or visible text
		new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByValue(country);
		
		
		// Define checkboxes as Web Elements
		WebElement weeklyEmailCheckbox = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
		WebElement monthlyEmailCheckbox = driver.findElement(By.id("MainContent_checkMonthlyEmail"));
		WebElement occasionalEmailCheckbox = driver.findElement(By.id("MainContent_checkUpdates"));
		
		// Call the checkbox algorithm function
		chooseCheckbox(driver, weeklyEmail, weeklyEmailCheckbox);
		freddie.utilities.Checkbox.choose(driver, monthlyEmail, monthlyEmailCheckbox);
		Checkbox.choose(driver, occasionalEmail, occasionalEmailCheckbox);
		
		/*
		// Weekly Email Checkbox Algorithm
		if (weeklyEmail) {
			if (!weeklyEmailCheckbox.isSelected()) {
				weeklyEmailCheckbox.click();
			}
		}
		else {
			if (weeklyEmailCheckbox.isSelected()) {
				weeklyEmailCheckbox.click();
			}
		}
		// Monthly Email Checkbox Algorithm
		if (monthlyEmail) {
			if (!driver.findElement(By.id("MainContent_checkMonthlyEmail")).isSelected()) {
				driver.findElement(By.id("MainContent_checkMonthlyEmail")).click();
			}
		}
		else {
			if (driver.findElement(By.id("MainContent_checkMonthlyEmail")).isSelected()) {
				driver.findElement(By.id("MainContent_checkMonthlyEmail")).click();
			}
		}
		// Occasional Email Checkbox Algorithm
		
		if (occasionalEmail) {
			driver.findElement(By.id("MainContent_checkUpdates")).clear();
			driver.findElement(By.id("MainContent_checkUpdates")).click();
		}
		else {
			driver.findElement(By.id("MainContent_checkUpdates")).clear();
		}
		
		
		// Click Submit
		driver.findElement(By.id("MainContent_btnSubmit")).click();
		
		// Print confirmation
		String confirmation = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		System.out.println(confirmation);
		if (confirmation.contains("success")) {
			System.out.println("TEST PASSED");
		}
		else {
			System.out.println("TEST FAILED");
		}
		
		driver.quit();
		*/
		
	}
	
	// This method will take a checkbox and the desired value and perform algorithm
	public static void chooseCheckbox(WebDriver driver, boolean checkBox, WebElement checkboxElement) {
		if (checkBox) {
			if (!checkboxElement.isSelected()) {
				checkboxElement.click();
			}
		}
		else {
			if (checkboxElement.isSelected()) {
				checkboxElement.click();
			}
		}
	}

}
