package freddie.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {
	
	// List all UI elements / interactions with UI
	
	// Click Loan Delivery
	public static void clickLoanDelivery(WebDriver driver) {
		driver.findElement(By.partialLinkText("Loan")).click();
	}
	
	// Click AMS
	public static void clickAMS(WebDriver driver) {
		driver.findElement(By.linkText("Account Management System")).click();
	}
	
	// Click Shopping Cart
	public static void clickShoppingCart(WebDriver driver) {
		driver.findElement(By.partialLinkText("Cart")).click();
	}
	
	// Click Window Handling
	public static void clickWindowHandling(WebDriver driver) {
		driver.findElement(By.partialLinkText("Window")).click();
	}

}
