package com.project.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.project.common.BaseClass;
import com.project.util.StoredValues;

public class ResultDetailPage extends BaseClass
{
	private WebElement resultDetail;
	
	
	public void isCorrectCarDisplayed() throws Exception
	{
		resultDetail = getElementByClassName("vehicle-title__text");
		
		String titleText = resultDetail.getText();
		String storedTitle = new StoredValues().retrieve("StoredList");
		
		Assert.assertTrue(titleText.toLowerCase().equals(storedTitle.toLowerCase()));
		
	}
}
