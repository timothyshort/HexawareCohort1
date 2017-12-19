package freddie.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AMSPage {
	WebDriver browser;
	
	// Define all web elements on the page
	@FindBy(id = "MainContent_txtUserName")
	WebElement usernameText;
	@FindBy(id = "MainContent_txtPassword")
	WebElement passwordText;
	@FindBy(id = "MainContent_btnLogin")
	WebElement loginButton;
	
	// Constructor
	public AMSPage(WebDriver driver) {
		// Initialie the driver at class level
		this.browser = driver;
		
		// Initialize all page elements & bind to the driver
		PageFactory.initElements(browser, this);
	}
	
	// This function does everything in one step
	public void login(String username, String password) {
		setUsername(username);
		setPassword(password);
		clickLogin();
	}
	
	public void setUsername(String username) {
		usernameText.clear();
		usernameText.sendKeys(username);
	}
	
	public void setPassword(String password) {
		passwordText.clear();
		passwordText.sendKeys(password);
	}
	
	public void clickLogin() {
		loginButton.click();
	}

}
