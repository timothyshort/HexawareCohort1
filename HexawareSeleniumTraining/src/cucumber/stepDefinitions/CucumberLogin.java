package cucumber.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import freddie.pages.AMSPage;
import freddie.utilities.DriverFactory;
import freddie.utilities.GlobalSettings;

public class CucumberLogin {
	WebDriver driver;
	AMSPage AMSPage;
	
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
	
	@When("^the user enters correct username and password$")
	public void the_user_enters_correct_username_and_password() {
		AMSPage.login("tim@testemail.com", "trpass");
		
		/*
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass");
		clickLogin();
		*/
	}
	
	@Then("^the user should be able to view their balance$")
	public void the_user_should_be_able_to_view_their_balance() {
		String response = driver.findElement(By.xpath("//*[@id=\"ctl01\"]/div[3]/div[2]/div/div[2]")).getText();
		Assert.assertTrue(response.contains("balance"));
	}
	
	@When("^the user enters bad username$")
	public void the_user_enters_bad_username() {
		AMSPage.setUsername("tim@freddiemail.com");
		// driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@freddiemail.com");
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
