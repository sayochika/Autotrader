Feature: Negative tests
			As a customer
			I want the website to point out my errors
			So that I can amend them

@regression
Scenario: Customer can not input invalid postcode
	Given I am on autotrader homepage
	When I enter my postcode as "ol9 8le"
	And I click submit button
	Then I am redirect to the homepage
	And there is an error message around postcode field