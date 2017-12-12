package freddie.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	WebDriver driver;
	
	// Define all web elements
	@FindBy(id="conf_message")
	WebElement confirmationMessage;
	
	// Constructor
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Define UI actions
	public String getConfirmMessage() {
		return confirmationMessage.getText();
	}
	
	public void clickUpdateSubscription() {
		
	}
	
	public void clickCancelAccount() {
		
	}
	
	public void clickChangePassword() {
		
	}
	
	public String pageTitle() {
		return driver.getTitle();
	}

}
