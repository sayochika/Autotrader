package com.project.stepDefinitions;

import com.project.common.BaseClass;
import com.project.pages.HomePage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NegativeTestSteps extends BaseClass
{
	HomePage homepage = new HomePage();
	
	@When("^I click submit button$")
	public void i_click_submit_button() throws Throwable {
	    homepage.clickonSearchButtonAndRemainOnHomepage();
	}

	@Then("^I am redirect to the homepage$")
	public void i_am_redirect_to_the_homepage() throws Throwable {
	    homepage.isHomepageDisplayed();
	}

	@Then("^there is an error message around postcode field$")
	public void there_is_an_error_message_around_postcode_field() throws Throwable {
	  homepage.isErrorMessageDisplayedForWrongPostcodeFormat();
	}

}
