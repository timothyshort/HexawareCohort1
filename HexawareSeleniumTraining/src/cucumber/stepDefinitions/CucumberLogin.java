package cucumber.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import freddie.utilities.DriverFactory;
import freddie.utilities.GlobalSettings;

public class CucumberLogin {
	WebDriver driver;
	
	@Given("^the user is on the AMS page$")
	public void the_user_is_on_the_AMS_page() {
		// Step 1: Initialize Driver
		driver = DriverFactory.start();
		
		// Step 2: Navigate to AMS page
		driver.get(GlobalSettings.AMSWebURL);
	}
	
	@When("^the user enters correct username and password$")
	public void the_user_enters_correct_username_and_password() {
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass");
		clickLogin();
	}
	
	@Then("^the user should be able to view their balance$")
	public void the_user_should_be_able_to_view_their_balance() {
		String response = driver.findElement(By.xpath("//*[@id=\"ctl01\"]/div[3]/div[2]/div/div[2]")).getText();
		Assert.assertTrue(response.contains("balance"));
	}
	
	@When("^the user enters bad username$")
	public void the_user_enters_bad_username() {
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@freddiemail.com");
	}

	@When("^the user enters bad password$")
	public void the_user_enters_bad_password() {
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass");
		clickLogin();
	}

	@Then("^the user should not be able to log in$")
	public void the_user_should_not_be_able_to_log_in() {
	    String pageText = driver.findElement(By.xpath("html/body")).getText();
	    Assert.assertTrue(pageText.contains("Login or Create an Account"));
	}
	
	private void clickLogin() {
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
	}
	
	private void print_info(String message) {
		System.out.println(message);
	}

}
