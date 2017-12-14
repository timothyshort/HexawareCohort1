package cucumber.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberLogin {
	
	
	@Given("^the user is on the AMS page$")
	public void the_user_is_on_the_AMS_page() {
		System.out.println("Step 1: User is on the AMS page");
	}
	
	@When("^the user enters correct username and password$")
	public void the_user_enters_correct_username_and_password() {
		System.out.println("Step 2: User enters correct username and password");
	}
	
	@Then("^the user should be able to view their balance$")
	public void the_user_should_be_able_to_view_their_balance() {
		System.out.println("Step 3: User should view their balance");
	}
	
	@When("^the user enters bad username$")
	public void the_user_enters_bad_username() {
	    System.out.println("Step 2: User enters bad username");
	}

	@When("^the user enters bad password$")
	public void the_user_enters_bad_password() {
	    System.out.println("Step 2: User enters bad password");
	}

	@Then("^the user should not be able to log in$")
	public void the_user_should_not_be_able_to_log_in() {
	    System.out.println("Step 3: User doesn't log in");
	}
	
	private void print_info(String message) {
		System.out.println(message);
	}

}
