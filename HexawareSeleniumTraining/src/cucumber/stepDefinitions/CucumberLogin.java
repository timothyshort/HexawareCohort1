package cucumber.stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import freddie.pages.AMSPage;
import freddie.pages.DashboardPage;
import freddie.utilities.DriverFactory;
import freddie.utilities.GlobalSettings;

public class CucumberLogin {
	WebDriver driver;
	AMSPage AMSPage;
	DashboardPage DashboardPage;
	
	@Before
	public void setup() {
		// Step 1: Initialize Driver
		driver = DriverFactory.start();
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
	@Given("^the user is on the AMS page$")
	public void the_user_is_on_the_AMS_page() {
		// Step 2: Navigate to AMS page
		driver.get(GlobalSettings.AMSWebURL);
		AMSPage = new AMSPage(driver);
	}
	
	// Using data tables:
	// 1. We do NOT need to update our step annotation's arguments
	@When("^the user enters correct username and password$")
	public void the_user_enters_correct_username_and_password(DataTable credentials) {
		// Extract data table into List
		List<List<String>> data = credentials.raw();
		
		// Parse list into local variables
		String username = data.get(0).get(0);
		String password = data.get(0).get(1);
		
		// Perform action
		AMSPage.login(username, password);
		
		/*
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass");
		clickLogin();
		*/
	}
	
	@When("^the user enters set of username and password$")
	public void the_user_enters_set_of_username_and_password(DataTable credentials) throws InterruptedException {
		// Extract data table into Map
		for (Map<String, String> data : credentials.asMaps(String.class, String.class)) {
		
			// Parse map into local variables
			String username = data.get("Username");
			String password = data.get("Password");
			
			// Perform action
			AMSPage.login(username, password);
			Thread.sleep(1500);
		}
	}
	
	@Then("^the user should be able to view their balance$")
	public void the_user_should_be_able_to_view_their_balance() {
		String response = driver.findElement(By.xpath("//*[@id=\"ctl01\"]/div[3]/div[2]/div/div[2]")).getText();
		Assert.assertTrue(response.contains("balance"));
	}
	
	// 1. Update step annotation's argument to include the regular expression:  \"(.*)\"
	// 2. Parameterize the function to receive data
	@When("^the user enters bad \"(.*)\"$")
	public void the_user_enters_bad_username(String email) {
		AMSPage.setUsername(email);
		// driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@freddiemail.com");
	}
	
	@When("^the user enters \"(.*)\" and \"(.*)\"$")
	public void the_user_enters_username_and_password(String username, String password) {
		AMSPage.login(username, password);
	}
	
	@Then("^the user receives a welcome message")
	public void dashboard_welcome_message() {
		DashboardPage = new DashboardPage(driver);
		Assert.assertTrue(DashboardPage.welcomeMessage().contains("Welcome back!"));
	}

	@When("^the user enters bad password$")
	public void the_user_enters_bad_password() {
		AMSPage.setPassword("trpass");
		// driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass");
	}
	
	@And("^the user clicks login button$")
	public void click_login() {
		AMSPage.clickLogin();
	}
	
	@Then("^the user should be able to update their subscription$")
	public void the_user_should_be_able_to_update_their_subscription() throws Throwable {
		String response = driver.findElement(By.xpath("//*[@id=\"ctl01\"]/div[3]/div[2]/div/div[2]")).getText();
		Assert.assertTrue(response.contains("Updated subscriptions"));
	}

	@Then("^the user should be able to change their password$")
	public void the_user_should_be_able_to_change_their_password() throws Throwable {
		String response = driver.findElement(By.xpath("//*[@id=\"ctl01\"]/div[3]/div[2]/div/div[2]")).getText();
		Assert.assertTrue(response.contains("Change password"));
	}

	@Then("^the user should be able to cancel their account$")
	public void the_user_should_be_able_to_cancel_their_account() throws Throwable {
		String response = driver.findElement(By.xpath("//*[@id=\"ctl01\"]/div[3]/div[2]/div/div[2]")).getText();
		Assert.assertTrue(response.contains("Cancel account"));
	}

	@Then("^the user should not be able to log in$")
	public void the_user_should_not_be_able_to_log_in() {
	    String pageText = driver.findElement(By.xpath("html/body")).getText();
	    Assert.assertTrue(pageText.contains("Login or Create an Account"));
	}
	
	@But("^the user receives a invalid login message$")
	public void invalidLogIn() {
		String pageText = driver.findElement(By.xpath("html/body")).getText();
	    Assert.assertTrue(pageText.contains("Invalid user name, try again!"));
	}
	
	private void clickLogin() {
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
	}
	
	private void print_info(String message) {
		System.out.println(message);
	}

}
