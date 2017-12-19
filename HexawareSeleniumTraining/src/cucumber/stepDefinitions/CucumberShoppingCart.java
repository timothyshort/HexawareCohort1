package cucumber.stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberShoppingCart {
	@Given("^the user is on the shopping cart home page$")
	public void the_user_is_on_the_shopping_cart_home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("^the user adds an item to the shopping cart$")
	public void the_user_adds_an_item_to_the_shopping_cart() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^the user should see the itemized pricing details in the shopping cart$")
	public void the_user_should_see_the_itemized_pricing_details_in_the_shopping_cart(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	}

	@When("^the user searches for product$")
	public void the_user_searches_for_product() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^the user should see search results for product type$")
	public void the_user_should_see_search_results_for_product_type() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^the user should see cost for the item on the search results page$")
	public void the_user_should_see_cost_for_the_item_on_the_search_results_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("^the user adds the n item to the cart$")
	public void the_user_adds_the_n_item_to_the_cart() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^the user should see product in the cart$")
	public void the_user_should_see_product_in_the_cart() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^the user should see cost for the item in the cart$")
	public void the_user_should_see_cost_for_the_item_in_the_cart() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

}
