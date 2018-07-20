Feature: Login
	As a customer
	I want the ability to search for car of my choice
	So that I can make an informed purchase

@Regression	
Scenario: Customer can search for a car of their choice
	Given I am on autotrader homepage
	When I enter my postcode
	And I select distance from postcode
	And I select Audi as my car make
	And I click on Submit button
	#Then all the Audi cars in within postcode are displayed