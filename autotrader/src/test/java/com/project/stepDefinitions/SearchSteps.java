package com.project.stepDefinitions;


import com.project.common.BaseClass;
import com.project.pages.HomePage;
import com.project.pages.ResultDetailPage;
import com.project.pages.SearchResultPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchSteps extends BaseClass
{
	
	HomePage homepage = new HomePage();
	SearchResultPage searchresultpage = new SearchResultPage();
	ResultDetailPage detailpage = new ResultDetailPage();
	
	@Given("^I am on autotrader homepage$")
	public void iAmOnAutotraderHomepage() throws Throwable {
	   
		launchUrl("https://www.autotrader.co.uk/");
	}

	@When("^I enter my postcode$")
	public void iEnterMyPostcode() throws Throwable {
	   homepage.enterPostcode();
	}

	@When("^I select distance from postcode$")
	public void iSelectDistanceFromPostcode() throws Throwable {
	    homepage.selectFromDistance();
	}

	@When("^I select Audi as my car make$")
	public void iSelectAudiAsMyCarMake() throws Throwable {
	    homepage.selectCarMake();
	}
	

	@When("^I select an Audi model$")
	public void i_select_an_Audi_model() throws Throwable {
	    homepage.selectCarModel();
	}

	
	@Then("^all the Audi cars within my postcode are displayed$")
	public void all_the_Audi_cars_within_my_postcode_are_displayed() throws Throwable {
	    searchresultpage.doesSearchContainModel();
	}
	
	
	@When("^I click on Submit button$")
	public void iClickOnSubmitButton() throws Throwable {
	    searchresultpage = homepage.clickonSearchButton();
	}

	
	@When("^I enter my postcode as \"([^\"]*)\"$")
	public void i_enter_my_postcode_as(String postcode) throws Throwable {
	   homepage.enterPostcode(postcode);
	}

	@When("^I select distance from postcode as \"([^\"]*)\"$")
	public void i_select_distance_from_postcode_as(String distance) throws Throwable {
	  homepage.selectFromDistance(distance);
	}

	@When("^I select \"([^\"]*)\" as my car make$")
	public void i_select_as_my_car_make(String carMake) throws Throwable {
	  homepage.selectCarMake(carMake);  
	}

	@When("^I select \"([^\"]*)\" as the model$")
	public void i_select_as_the_model(String carModel) throws Throwable {
	  homepage.selectCarModel(carModel);   
	}

	@Then("^all the \"([^\"]*)\" cars within my postcode are displayed$")
	public void all_the_cars_within_my_postcode_are_displayed(String result) throws Throwable {
		searchresultpage.doesSearchContainModel(result);
	}


	@When("^I select the first car on the list$")
	public void i_select_the_first_car_on_the_list() throws Throwable {
		detailpage = searchresultpage.clickOnResultLink();
	}

	@Then("^the car selected is actually displayed$")
	public void the_car_selected_is_actually_displayed() throws Throwable {
	    detailpage.isCorrectCarDisplayed();
	}
	
	


}
