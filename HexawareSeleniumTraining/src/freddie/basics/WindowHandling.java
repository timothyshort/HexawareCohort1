package freddie.basics;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import freddie.utilities.Alert;
import freddie.utilities.DriverFactory;
import freddie.utilities.GlobalSettings;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		// Exercise:
		// 1. Delete the account: hit cancel on alert (Window0)
		// 2. Login >> NEW TAB (Window1)
		// 3. Delete the account: and accept the alert (Window0)
		
		boolean alert = true;
		String email = "rachel.simmons@testemail.com";
		String password = "password";
		
		WebDriver driver = DriverFactory.start("chrome");
		driver.get(GlobalSettings.rootWebURL + "windows.html");
		System.out.println(driver.getTitle());
		Thread.sleep(2500);
		
		// Click Create Account
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[2]")).click();
		Thread.sleep(2500);
		
		// Generate List of All Windows
		ArrayList<String> allWindows = new ArrayList<String>(driver.getWindowHandles());
		// List (Collections): allWindows.get(0)
		// Array (Primitive): allWindows[0]
		
		// Login Page: Window 1
		driver.switchTo().window(allWindows.get(1));
		
		// Copy Steps to Login
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys(email);
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
		driver.findElement(By.id("MainContent_btnLogin")).click();
		Thread.sleep(2500);
		
		// Windows Page: Window 0
		driver.switchTo().window(allWindows.get(0));
		Thread.sleep(2500);
		
		// Click on the DELETE ACCOUNT button to trigger the alert
		driver.findElement(By.id("delete_account")).click();
		Alert.handle(driver, alert, 1500);
		
		/* Iterate Through All Windows
		for (String window : windows) {
			// System.out.println(window);
			driver.switchTo().window(window);
			System.out.println("PAGE TITLE: " + driver.getTitle());
		}
		*/
		
		// Click on the DELETE ACCOUNT button to trigger the alert
		driver.findElement(By.id("delete_account")).click();
		Alert.handle(driver, !alert, 1500);
	}
}