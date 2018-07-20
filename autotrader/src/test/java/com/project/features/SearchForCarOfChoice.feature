Feature: Search
	As a customer
	I want the ability to search for car of my choice
	So that I can make an informed purchase
	
@SmokeTest
Scenario: Customer can search for a car model of their choice
	Given I am on autotrader homepage
	When I enter my postcode
	And I select distance from postcode
	And I select Audi as my car make
	And I select an Audi model
	And I click on Submit button
	Then all the Audi cars within my postcode are displayed
	
@SlowTest		
Scenario: Customer can search for cars
  Given I am on autotrader homepage
	When I enter my postcode as "OL9 8LE"
	And I select distance from postcode as "Within 50 miles"
	And I select "Audi" as my car make
	And I select "Q7" as the model
	And I click on Submit button
	Then all the "Audi Q7" cars within my postcode are displayed
	
@ignore	
Scenario Outline: Customer can search for multiple cars
	Given I am on autotrader homepage
	When I enter my postcode as "<Postcode>"
	And I select distance from postcode as "<Distance>"
	And I select "<Make>" as my car make
	And I select "<Model>" as the model
	And I click on Submit button
	Then all the "<Model>" cars within my postcode are displayed
	
	
Scenarios:
 |Postcode|Distance|Make|Model| 
 |OL9 8LE| Within 40 miles| Audi|Q7|
 #|M40 2EB| Within 30 miles| Mercedes-Benz| G Class|  

	