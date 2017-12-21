@Ignore
Feature: Shopping Cart Application
	As a customer,
	I want to add products to the shopping cart
	So that I can purchase them
	
Background:
Given the user is on the shopping cart home page

@SmokeTest
Scenario: the shopping cart should display the itemized pricing details
When the user adds an item to the shopping cart
Then the user should see the itemized pricing details in the shopping cart
| Subtotal | Online Discount | Grand Total | Tax |

#Scenario: the shopping cart should display the itemized pricing details
#Given the user is on the shopping cart home page
#When the user adds an item to the shopping cart
#Then the user should see the "Subtotal" in the shopping cart
#Then the user should see the "Online Discount" in the shopping cart
#Then the user should see the "Grand Total" in the shopping cart
#Then the user should see the "Tax" in the shopping cart

#@EndtoEnd

#Complete scenario by parameterizing the product and product type. Sample test
#cases: iPhone/phone, apple/phone, phone/phone, tv/tv, cannon/camera, samsung/tv
@SmokeTest
Scenario: the search result page should display products that the user searched
When the user searches for "iPhone"
Then the user should see search results for "phone"

@FunctionalTest
Scenario Outline: the shopping cart should display the product item and price.
When the user searches for "<product>"
Then the user should see search results for "<productType>"
And the user should see "<itemCost>" for the item on the search results page
When the user adds the "<itemResult>" item to the cart
Then the user should see "<product>" in the cart
And the user should see "<itemCost>" for the item in the cart

Examples:
| product | productType | itemResult | itemCost |
| iPhone6 | phone | 1 | 749.00 |
| iPhone6 Plus | phone | 1 | 849.00 |
| samsung hdtv | tv | 1 | 701.00 |