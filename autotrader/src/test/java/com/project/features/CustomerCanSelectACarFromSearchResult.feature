Feature: Result Detail 
  As a customer 
  I want to be able to select a car from the list of search result
  So that I can verify the detail of the car
  
Scenario: Customer can select a car from list
	Given I am on autotrader homepage
	When I enter my postcode as "OL9 8LE"
	And I select distance from postcode as "Within 50 miles"
	And I select "Audi" as my car make
	And I select "Q7" as the model
	And I click on Submit button
	And I select the first car on the list
	Then the car selected is actually displayed
	    