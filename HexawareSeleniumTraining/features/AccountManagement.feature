Feature: The Account Management Application
	As a returning member
	I want to be able to login
	So that I can access my account information
	
Background: the user logs into the account
	Given the user is on the AMS page
	When the user logs in
	Then the user should be on the dashboard page

Scenario: the user should see a welcome message
	Then the user should see a welcome message
	
Scenario: the user should be able to see their account balance
	Then the user should see their account balance
	
Scenario: the user should be able to pay a bill
	When the user clicks on Pay Bill
	And the user selects payment amount
	And the user selects payment method
	And the user selects payment date
	And the user clicks submit payment
	Then the user should get a confirmation message