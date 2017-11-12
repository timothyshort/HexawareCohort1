package freddie.utilities;

import org.openqa.selenium.WebDriver;

public class Alert {
	// This function will handle an alert window provided with a boolean decision to accept or dismiss
	public static void handle(WebDriver driver, boolean alertDecision, int waitTime) throws InterruptedException {
		// Print the alert message
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println("ALERT: " + alertMessage);
		Thread.sleep(waitTime);
		
		// Click OK or Cancel on Alert?
		if (alertDecision) {
			driver.switchTo().alert().accept();
		}
		else {
			driver.switchTo().alert().dismiss();
		}
		
		// Accept the confirmation alert
		Thread.sleep(waitTime);
		driver.switchTo().alert().accept();
	}
}
