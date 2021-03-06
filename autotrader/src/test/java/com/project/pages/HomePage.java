package com.project.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.project.common.BaseClass;

public class HomePage extends BaseClass
{
	private WebElement postcodeField;
	private WebElement distance;
	private WebElement make;
	private WebElement model;
	private WebElement searchButton;
	private WebElement WrongPostCodeFormatError;
	
	public void enterPostcode() throws Exception
	{
		postcodeField = getElementById("postcode");
		//postcode is hardcoded into the method
		postcodeField.sendKeys("AL7 2HZ");
	}
	
	public void enterPostcode(String postcode) throws Exception
	{
		postcodeField = getElementById("postcode");
		postcodeField.sendKeys(postcode);
	}
	
	public void selectFromDistance() throws Exception
	{
		distance = getElementById("radius");
		selectByText(distance, "Within 40 miles");
	}
	
	
	public void selectFromDistance(String distanceFrom) throws Exception
	{
		distance = getElementById("radius");
		selectByText(distance, distanceFrom);
	}
	
	
	public void selectCarMake() throws Exception
	{
		make = getElementById("searchVehiclesMake");
		selectByValue(make, "AUDI");
	}
	
	public void selectCarMake(String carMake) throws Exception
	{
		make = getElementById("searchVehiclesMake");
		selectByValue(make, carMake.toUpperCase());
	}
	
	public void selectCarModel() throws Exception
	{
		model = getElementById("searchVehiclesModel");
		selectByValue(model, "Q7");
	}
	
	public void selectCarModel(String carModel) throws Exception
	{
		model = getElementById("searchVehiclesModel");
		selectByValue(model, carModel.toUpperCase());
	}
	
	public SearchResultPage clickonSearchButton() throws Exception
	{
		searchButton = getElementById("js-search-button");
		searchButton.click();
		
		return new SearchResultPage();
	}
	
	public void clickonSearchButtonAndRemainOnHomepage() throws Exception
	{
		searchButton = getElementById("js-search-button");
		searchButton.click();
	}
	
	public void isHomepageDisplayed() throws Exception
	{
		Thread.sleep(3000);
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.equalsIgnoreCase("https://www.autotrader.co.uk/"));
	}
	
	public void isErrorMessageDisplayedForWrongPostcodeFormat() throws Exception
	{
		WrongPostCodeFormatError = getElementByCssSelector(".c-form__input.has-error");
		Assert.assertTrue(WrongPostCodeFormatError.isDisplayed());
	}
	
}
