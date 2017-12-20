package cucumber.stepDefinitions;

import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import freddie.utilities.DriverFactory;

public class CucumberShoppingCart {
	// WebDriver driver;
	
	@Given("^the user is on the shopping cart home page$")
	public void the_user_is_on_the_shopping_cart_home_page() throws Throwable {
	    System.out.println("User is on home page");
	    // driver = DriverFactory.start();
	}

	@When("^the user adds an item to the shopping cart$")
	public void the_user_adds_an_item_to_the_shopping_cart() throws Throwable {
	    System.out.println("User adds item to cart");
	}

	@Then("^the user should see the itemized pricing details in the shopping cart$")
	public void the_user_should_see_the_itemized_pricing_details_in_the_shopping_cart(DataTable itemizedPricing) throws Throwable {
		System.out.println("User should see itemized pricing on cart");
		// Convert DataTable into a list
		List<List<String>> items = itemizedPricing.raw();
		
		// Iterate through horizontal datatable (1 row list)
		for (String item : items.get(0)) {
			System.out.println("Detail: " + item);
			
			// Use xPath to .getText of the shopping cart table
			// Assert that the .getText contains "<item>"
		}
		
		/*
		// Iterate through multi-dimensional datatable list (multi-row list)
		for (List<String> rows : items) {
			for (String item : rows) {
				System.out.println("Detail: " + item);
			}
		}
		*/
		
	}

	@When("^the user searches for \"(.*)\"$")
	public void the_user_searches_for_product(String product) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^the user should see search results for \"(.*)\"$")
	public void the_user_should_see_search_results_for_product_type(String productType) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^the user should see \"(.*)\" for the item on the search results page$")
	public void the_user_should_see_cost_for_the_item_on_the_search_results_page(String cost) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("^the user adds the \"(.*)\" item to the cart$")
	public void the_user_adds_the_n_item_to_the_cart(String itemResult) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^the user should see \"(.*)\" in the cart$")
	public void the_user_should_see_product_in_the_cart(String product) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^the user should see \"(.*)\" for the item in the cart$")
	public void the_user_should_see_cost_for_the_item_in_the_cart(String cost) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

}
